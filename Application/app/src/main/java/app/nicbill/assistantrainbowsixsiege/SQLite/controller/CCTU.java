package app.nicbill.assistantrainbowsixsiege.SQLite.controller;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import app.nicbill.assistantrainbowsixsiege.SQLite.DBHelper;

public class CCTU extends DBHelper {
    public CCTU(Context context) {
        super(context);
    }

    public List<String> getCTUList(){
        openDatabase();
        List<String> listCTU = new ArrayList<>();

        Cursor cursor = mDatabase.rawQuery("select abrevCTU from CTU as ct order by nomCTU", null);

        Log.v("DICJ", "cursor.getCount() : " + cursor.getCount());
        if (cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            do {
                String abrevCTU = cursor.getString(cursor.getColumnIndex("abrevCTU"));

                listCTU.add(abrevCTU);
            }
            while (cursor.moveToNext());

            cursor.close();
        }
        closeDataBase();
        return listCTU;
    }
}
