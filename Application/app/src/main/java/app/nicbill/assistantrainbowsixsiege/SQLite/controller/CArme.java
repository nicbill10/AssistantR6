package app.nicbill.assistantrainbowsixsiege.SQLite.controller;


import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import app.nicbill.assistantrainbowsixsiege.SQLite.DBHelper;
import app.nicbill.assistantrainbowsixsiege.SQLite.database.model.Arme;
import app.nicbill.assistantrainbowsixsiege.SQLite.database.model.TypeArme;

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
                "where op.nomCode = '" + nomOp + "' and ar.mainWeapon = '" + mainWeapon + "' order by ar.nomArme", null);

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

    public Arme getWeaponInfo(String weaponID){

        openDatabase();
        Arme arme = null;

        Cursor cursor = mDatabase.rawQuery("select * from arme where idArme = '" + weaponID + "'", null);

        if (cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            String idArme = cursor.getString(cursor.getColumnIndex("idArme"));
            String nomArme = cursor.getString(cursor.getColumnIndex("nomArme"));
            String calibreBalle = cursor.getString(cursor.getColumnIndex("calibreBalle"));
            String magSize = cursor.getString(cursor.getColumnIndex("magSize"));
            String maxAmmo = cursor.getString(cursor.getColumnIndex("maxAmmo"));
            String fireRate = cursor.getString(cursor.getColumnIndex("fireRate"));
            String mobility = cursor.getString(cursor.getColumnIndex("mobility"));
            String idTypeArme = cursor.getString(cursor.getColumnIndex("idTypeArme"));
            String mainWeapon = cursor.getString(cursor.getColumnIndex("mainWeapon"));

            arme = new Arme(idArme, nomArme,calibreBalle,magSize,maxAmmo,fireRate,mobility,null,idTypeArme, mainWeapon);
        }
        cursor.close();
        closeDataBase();
        return arme;
    }

    public TypeArme getType(String weaponID){

        openDatabase();
        TypeArme typeArme = null;

        Cursor cursor = mDatabase.rawQuery("select ta.idTypeArme, ta.nomTypeArme from typeArme ta join arme ar on ta.idTypeArme = ar.idTypeArme where ar.idArme = '" + weaponID + "'", null);

        if (cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            String idTypeArme = cursor.getString(cursor.getColumnIndex("idTypeArme"));
            String nomTypeArme = cursor.getString(cursor.getColumnIndex("nomTypeArme"));

            typeArme = new TypeArme(idTypeArme, nomTypeArme);
        }
        cursor.close();
        closeDataBase();
        return typeArme;
    }

    public List<Arme> getWeaponsbyType(String idType){

        openDatabase();
        List<Arme> listArme = new ArrayList<>();

        Cursor cursor = mDatabase.rawQuery("select * " +
                "from arme " +
                "where idTypeArme = '" + idType + "' order by nomArme", null);

        if (cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            do {
                String idArme = cursor.getString(cursor.getColumnIndex("idArme"));
                String nomArme = cursor.getString(cursor.getColumnIndex("nomArme"));
                String calibreBalle = cursor.getString(cursor.getColumnIndex("calibreBalle"));
                String magSize = cursor.getString(cursor.getColumnIndex("magSize"));
                String maxAmmo = cursor.getString(cursor.getColumnIndex("maxAmmo"));
                String fireRate = cursor.getString(cursor.getColumnIndex("fireRate"));
                String mobility = cursor.getString(cursor.getColumnIndex("mobility"));
                String idTypeArme = cursor.getString(cursor.getColumnIndex("idTypeArme"));
                String mainWeapon = cursor.getString(cursor.getColumnIndex("mainWeapon"));
                Arme arme = new Arme(idArme, nomArme,calibreBalle,magSize,maxAmmo,fireRate,mobility,null,idTypeArme, mainWeapon);

                listArme.add(arme);
            }
            while (cursor.moveToNext());

            cursor.close();
        }
        closeDataBase();
        return listArme;
    }

    public List<TypeArme> getWeaponsTypes(){

        openDatabase();
        List<TypeArme> listTypeArme = new ArrayList<>();

        Cursor cursor = mDatabase.rawQuery("select * from typeArme", null);

        if (cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            do {
                String idTypeArme = cursor.getString(cursor.getColumnIndex("idTypeArme"));
                String nomTypeArme = cursor.getString(cursor.getColumnIndex("nomTypeArme"));
                TypeArme typeArme = new TypeArme(idTypeArme, nomTypeArme);

                listTypeArme.add(typeArme);
            }
            while (cursor.moveToNext());

            cursor.close();
        }
        closeDataBase();
        return listTypeArme;
    }
}
