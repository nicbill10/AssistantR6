package app.nicbill.assistantrainbowsixsiege.SQLite;


import android.annotation.SuppressLint;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DBHelper extends SQLiteOpenHelper {

    protected static SQLiteDatabase mDatabase;
    private final Context mContext;
    private static final String DATABASE_NAME = "BD_R6.db";
    @SuppressLint("SdCardPath")
    private static String DATABASE_PATH = "/data/data/app.nicbill.assistantrainbowsixsiege/databases/";
    private static final int DATABASE_VERSION = 2;

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.mContext = context;
    }

    public void createDatabase() throws IOException{
        Log.i("db_log","création de la BD");
        boolean dbExist = checkDatabase();

        if(dbExist){
            Log.i("db_log", "db exists");
        }
        else {
            try{
                getReadableDatabase();
                close();

                copyDatabase();
            }catch (IOException e){
                throw new Error("Error copying database");
            }
        }
    }

    private static boolean checkDatabase() {
        boolean checkDB = false;
        try {
            String myPath = DATABASE_PATH + DATABASE_NAME;
            File dbFile = new File(myPath);
            checkDB = dbFile.exists();
        } catch (SQLiteException e) {
            Log.v("db_log", e.getMessage());
        }
        return checkDB;
    }

    private void copyDatabase() throws IOException{
        InputStream myInput = mContext.getAssets().open(DATABASE_NAME);
        String outFileName = DATABASE_PATH + DATABASE_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0)
        {
            myOutput.write(buffer, 0, length);
            Log.i("db_log", "copyDatabase");
        }
        myOutput.flush();
        myInput.close();
        myOutput.close();
        Log.i("db_log","copyDatabase() terminé");
    }

    public void db_delete(){
        File file = new File(DATABASE_PATH + DATABASE_NAME);
        if(file.exists()){
            file.delete();
        }
    }

    public void openDatabase() throws SQLException{
        try {
            createDatabase();
        } catch (IOException e) {
            throw new Error("Impossible de créer la BD");
        }
        String myPath = DATABASE_PATH + DATABASE_NAME;
        mDatabase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public synchronized void closeDataBase() throws SQLException{
        if(mDatabase != null)
            mDatabase.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {   }

    //TODO faire le onUprade pour vrai
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion > oldVersion){
            Log.v("Database Upgrade", "Database version higher than old.");
            db_delete();
        }
    }
}


