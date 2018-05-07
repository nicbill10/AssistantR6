package app.nicbill.assistantrainbowsixsiege.SQLite.controller;


import android.content.Context;
import android.database.Cursor;

import java.util.HashMap;

import app.nicbill.assistantrainbowsixsiege.SQLite.DBHelper;

public class CGadget extends DBHelper{
    public CGadget(Context context) {
        super(context);
    }

    public HashMap<String, String> getOpGadgetList(String nomOp){
        openDatabase();

        HashMap<String, String> hmListGadget = new HashMap<>();

        Cursor cursor = mDatabase.rawQuery("select ga.nomGadget, go.qteGadget " +
                "from operateur as op " +
                "join gadgetOperateur as go " +
                "on go.idOperateur = op.idOperateur " +
                "join gadget as ga " +
                "on go.idGadget = ga.idGadget " +
                "where op.nomCode = '" + nomOp + "'", null);

        if (cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            do {
                String nomGadget = cursor.getString(cursor.getColumnIndex("nomGadget"));
                String qteGadget = cursor.getString(cursor.getColumnIndex("qteGadget"));

                hmListGadget.put(nomGadget, qteGadget);
            }
            while (cursor.moveToNext());

            cursor.close();
        }

        return hmListGadget;
    }

    public String getGadgetID(String gadgetName)
    {
        openDatabase();

        String idGadget;

        Cursor cursor = mDatabase.rawQuery("select idGadget " +
                "from gadget " +
                "where nomGadget = '" + gadgetName + "'", null);

        cursor.moveToFirst();
        do {
            idGadget = cursor.getString(cursor.getColumnIndex("idGadget"));
                    }
        while (cursor.moveToNext());

        closeDataBase();
        return idGadget;
    }
}
