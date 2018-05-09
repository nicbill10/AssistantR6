package app.nicbill.assistantrainbowsixsiege.SQLite.controller;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import app.nicbill.assistantrainbowsixsiege.SQLite.DBHelper;
import app.nicbill.assistantrainbowsixsiege.SQLite.database.model.CTU;

public class CCTU extends DBHelper {
    public CCTU(Context context) {
        super(context);
    }

    public List<CTU> getCTUList(){
        openDatabase();
        List<CTU> listCTU = new ArrayList<>();

        Cursor cursor = mDatabase.rawQuery("select * from CTU order by nomCTU", null);

        Log.v("DICJ", "cursor.getCount() : " + cursor.getCount());
        if (cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            do {
                String idCTU = cursor.getString(cursor.getColumnIndex("idCTU"));
                String nomCTU =cursor.getString(cursor.getColumnIndex("nomCTU"));
                String abrevCTU = cursor.getString(cursor.getColumnIndex("abrevCTU"));
                String locationCTU = cursor.getString(cursor.getColumnIndex("locationCTU"));
                String descCTU = cursor.getString(cursor.getColumnIndex("descCTU"));

                listCTU.add(new CTU(idCTU, nomCTU, abrevCTU, locationCTU, descCTU));
            }
            while (cursor.moveToNext());

            cursor.close();
        }
        closeDataBase();
        return listCTU;
    }
}
