package app.nicbill.assistantrainbowsixsiege.SQLite.controller;


import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import app.nicbill.assistantrainbowsixsiege.SQLite.DBHelper;

public class COperateurs extends DBHelper{
    public COperateurs(Context context) {
        super(context);
    }

    public HashMap<String, String> getInfoOperateur(String nomOp){
        openDatabase();
        HashMap<String, String> hmInfoOp = new HashMap<>();

        Cursor cursor = mDatabase.rawQuery("select op.idOperateur, nomOperateur, nomCode, bio, ddn, ca.nomCap, ca.descCap, ca.cheminImageCap, " +
                                            "ty.type, ty.vitesse, ty.armure, ro.nomRole, ct.abrevCTU, ct.idCTU " +
                                            "from operateur as op " +
                                            "join capacite as ca " +
                                            "on op.idCapacite = ca.idCap " +
                                            "join typeOperateur ty " +
                                            "on op.idTypeOp = ty.idTypeOp " +
                                            "join role as ro " +
                                            "on op.idRole = ro.idRole " +
                                            "join ctu as ct " +
                                            "on op.idCTU = ct.idCTU " +
                                            "where nomCode = '" + nomOp + "'", null);

        Log.v("Assistant R6", "cursor.getCount() : " + cursor.getCount());
        if (cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            int idOperateur = cursor.getInt(cursor.getColumnIndex("idOperateur"));
            String nomOperateur = cursor.getString(cursor.getColumnIndex("nomOperateur"));
            String nomCode = cursor.getString(cursor.getColumnIndex("nomCode"));
            String bio = cursor.getString(cursor.getColumnIndex("bio"));
            String ddn = cursor.getString(cursor.getColumnIndex("ddn"));
            String nomCap = cursor.getString(cursor.getColumnIndex("nomCap"));
            String descCap = cursor.getString(cursor.getColumnIndex("descCap"));
            String cheminImageCap = cursor.getString(cursor.getColumnIndex("cheminImageCap"));
            String type = cursor.getString(cursor.getColumnIndex("type"));
            int vitesse = cursor.getInt(cursor.getColumnIndex("vitesse"));
            int armure = cursor.getInt(cursor.getColumnIndex("armure"));
            String nomRole = cursor.getString(cursor.getColumnIndex("nomRole"));
            String abrevCTU = cursor.getString(cursor.getColumnIndex("abrevCTU"));
            int idCTU  = cursor.getInt(cursor.getColumnIndex("idCTU"));

            Log.i("Assistant R6", nomOperateur + " nomOperateur");
            Log.i("Assistant R6", nomCap + " nomCap");
            Log.i("Assistant R6", type + " type");
            Log.i("Assistant R6", nomRole + " nomRole");
            Log.i("Assistant R6", abrevCTU + " abrevCTU");

            hmInfoOp.put("idOperateur", String.valueOf(idOperateur));
            hmInfoOp.put("nomOperateur", String.valueOf(nomOperateur));
            hmInfoOp.put("nomCode", String.valueOf(nomCode));
            hmInfoOp.put("bio", String.valueOf(bio));
            hmInfoOp.put("ddn", String.valueOf(ddn));
            hmInfoOp.put("nomCap", String.valueOf(nomCap));
            hmInfoOp.put("descCap", String.valueOf(descCap));
            hmInfoOp.put("cheminImageCap", String.valueOf(cheminImageCap));
            hmInfoOp.put("type", String.valueOf(type));
            hmInfoOp.put("vitesse", String.valueOf(vitesse));
            hmInfoOp.put("armure", String.valueOf(armure));
            hmInfoOp.put("nomRole", String.valueOf(nomRole));
            hmInfoOp.put("abrevCTU", String.valueOf(abrevCTU));
            hmInfoOp.put("idCTU", String.valueOf(idCTU));
        }
        cursor.close();

        closeDataBase();
        return hmInfoOp;
    }

    public List<String> getOpsListByType(String Type){
        openDatabase();
        List<String> listOps = new ArrayList<>();

        Cursor cursor = mDatabase.rawQuery("select nomCode, ty.type, ct.abrevCTU from operateur as op join typeOperateur ty on op.idTypeOp = ty.idTypeOp join ctu as ct on op.idCTU = ct.idCTU where ty.Type = '" + Type + "' order by nomCode", null);

        Log.v("DICJ", "cursor.getCount() : " + cursor.getCount());
        if (cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            do {
                String nomCode = cursor.getString(cursor.getColumnIndex("nomCode"));

                listOps.add(nomCode);
            }
            while (cursor.moveToNext());

            cursor.close();
        }
        closeDataBase();
        return listOps;
    }

    public List<String> getOpsListByCTU(String CTU){
        openDatabase();
        List<String> listOps = new ArrayList<>();

        Cursor cursor = mDatabase.rawQuery("select nomCode from operateur as op join ctu as ct on op.idCTU = ct.idCTU where ct.abrevCTU = '" + CTU + "' order by nomCode", null);

        Log.v("DICJ", "cursor.getCount() : " + cursor.getCount());
        if (cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            do {
                String nomCode = cursor.getString(cursor.getColumnIndex("nomCode"));

                listOps.add(nomCode);
            }
            while (cursor.moveToNext());

            cursor.close();
        }
        closeDataBase();
        return listOps;
    }


}
