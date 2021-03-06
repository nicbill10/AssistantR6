package app.nicbill.assistantrainbowsixsiege.SQLite.controller;


import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import app.nicbill.assistantrainbowsixsiege.SQLite.DBHelper;
import app.nicbill.assistantrainbowsixsiege.SQLite.database.model.CTU;
import app.nicbill.assistantrainbowsixsiege.SQLite.database.model.Operateur;

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
            String idOperateur = cursor.getString(cursor.getColumnIndex("idOperateur"));
            String nomOperateur = cursor.getString(cursor.getColumnIndex("nomOperateur"));
            String nomCode = cursor.getString(cursor.getColumnIndex("nomCode"));
            String bio = cursor.getString(cursor.getColumnIndex("bio"));
            String ddn = cursor.getString(cursor.getColumnIndex("ddn"));
            String nomCap = cursor.getString(cursor.getColumnIndex("nomCap"));
            String descCap = cursor.getString(cursor.getColumnIndex("descCap"));
            String cheminImageCap = cursor.getString(cursor.getColumnIndex("cheminImageCap"));
            String type = cursor.getString(cursor.getColumnIndex("type"));
            String vitesse = cursor.getString(cursor.getColumnIndex("vitesse"));
            String armure = cursor.getString(cursor.getColumnIndex("armure"));
            String nomRole = cursor.getString(cursor.getColumnIndex("nomRole"));
            String abrevCTU = cursor.getString(cursor.getColumnIndex("abrevCTU"));
            String idCTU  = cursor.getString(cursor.getColumnIndex("idCTU"));

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

    public List<Operateur> getOpsListByType(String Type){
        openDatabase();
        List<Operateur> listOps = new ArrayList<>();

        Cursor cursor = mDatabase.rawQuery("select * from operateur as op join typeOperateur ty on op.idTypeOp = ty.idTypeOp join ctu as ct on op.idCTU = ct.idCTU where ty.Type = '" + Type + "' order by nomCode", null);

        Log.v("DICJ", "cursor.getCount() : " + cursor.getCount());
        if (cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            do {
                String idOperateur = cursor.getString(cursor.getColumnIndex("idOperateur"));
                String nomOperateur = cursor.getString(cursor.getColumnIndex("nomOperateur"));
                String nomCode = cursor.getString(cursor.getColumnIndex("nomCode"));
                String bio = cursor.getString(cursor.getColumnIndex("bio"));
                String ddn = cursor.getString(cursor.getColumnIndex("ddn"));
                listOps.add(new Operateur(idOperateur, nomOperateur, nomCode, bio, ddn, null, null, 0, 0, 0, 0 ));
            }
            while (cursor.moveToNext());

            cursor.close();
        }
        closeDataBase();
        return listOps;
    }

    public List<Operateur> getOpsListByWeapon(String armeID){
        openDatabase();
        List<Operateur> listOps = new ArrayList<>();

        Cursor cursor = mDatabase.rawQuery("select op.idOperateur, op.nomCode from operateur as op join armeOperateur ao on op.idOperateur = ao.idOperateur where ao.idArme = '" + armeID + "'", null);

        Log.v("DICJ", "cursor.getCount() : " + cursor.getCount());
        if (cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            do {
                String idOperateur = cursor.getString(cursor.getColumnIndex("idOperateur"));
                String nomCode = cursor.getString(cursor.getColumnIndex("nomCode"));
                listOps.add(new Operateur(idOperateur, null, nomCode, null, null, null, null, 0, 0, 0, 0 ));
            }
            while (cursor.moveToNext());

            cursor.close();
        }
        closeDataBase();
        return listOps;
    }

    public List<Operateur> getOpsListByCTU(CTU ctu){
        openDatabase();
        List<Operateur> listOps = new ArrayList<>();

        Cursor cursor = mDatabase.rawQuery("select * from operateur as op join ctu as ct on op.idCTU = ct.idCTU where ct.idCTU = '" + ctu.getIdCTU() + "' order by nomCode", null);

        Log.v("DICJ", "cursor.getCount() : " + cursor.getCount());
        if (cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            do {
                String idOperateur = cursor.getString(cursor.getColumnIndex("idOperateur"));
                String nomOperateur = cursor.getString(cursor.getColumnIndex("nomOperateur"));
                String nomCode = cursor.getString(cursor.getColumnIndex("nomCode"));
                String bio = cursor.getString(cursor.getColumnIndex("bio"));
                String ddn = cursor.getString(cursor.getColumnIndex("ddn"));

                listOps.add(new Operateur(idOperateur, nomOperateur, nomCode, bio, ddn, null, null, 0, 0, 0, 0));
            }
            while (cursor.moveToNext());

            cursor.close();
        }
        closeDataBase();
        return listOps;
    }


}
