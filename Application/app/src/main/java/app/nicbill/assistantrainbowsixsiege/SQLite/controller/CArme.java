package app.nicbill.assistantrainbowsixsiege.SQLite.controller;


import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import app.nicbill.assistantrainbowsixsiege.SQLite.DBHelper;
import app.nicbill.assistantrainbowsixsiege.SQLite.database.model.Arme;

public class CArme extends DBHelper{

    public CArme(Context context) {
        super(context);
    }

    public List<Arme> getOpWeaponsList(String nomOp, String mainWeapon){

        openDatabase();
        List<Arme> listArme = new ArrayList<>();

        Cursor cursor = mDatabase.rawQuery("select ar.idArme, ar.nomArme " +
                "from operateur as op " +
                "join armeOperateur as ao " +
                "on op.idOperateur = ao.idOperateur " +
                "join arme as ar " +
                "on ao.idArme = ar.idArme " +
                "where op.nomCode = '" + nomOp + "' and ar.mainWeapon = '" + mainWeapon + "'", null);

        if (cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            do {
                String idArme = cursor.getString(cursor.getColumnIndex("idArme"));
                String nomArme = cursor.getString(cursor.getColumnIndex("nomArme"));
                Arme arme = new Arme(idArme, nomArme,null,null,null,null,null,null,null, null);

                listArme.add(arme);
            }
            while (cursor.moveToNext());

            cursor.close();
        }
        closeDataBase();
        return listArme;
    }
}
