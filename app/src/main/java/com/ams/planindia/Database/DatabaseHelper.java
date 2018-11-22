package com.ams.planindia.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {


    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     * @param context
     */

    private static String DB_NAME = "PlanIndiaDb.sqlite";
    private final Context myContext;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
        this.myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table if not exists PackageDetails (packageName TEXT PRIMARY KEY NOT NULL ,packageDiscritption TEXT)");
        db.execSQL("create table if not exists MenuListName (menuName TEXT PRIMARY KEY NOT NULL )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertMenuName(String menuName){
        SQLiteDatabase db2 = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("menuName",menuName);
        db2.insert("MenuListName", null , contentValues);
        db2.close();
    }

    public void insertPackageData(String packageName,String packageDiscritption){
        SQLiteDatabase db2 = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("PackageName",packageName);
        contentValues.put("PackageDiscription",packageDiscritption);
        db2.insert("PackageDetails", null , contentValues);
        db2.close();
    }





    // Get Methods

    public Cursor getMenuNames(){

        SQLiteDatabase db3 = this.getWritableDatabase();
        Cursor packageList = db3.rawQuery("select * from MenuListName ", null);
        return packageList;

    }



    public Cursor getPackageData(){

        SQLiteDatabase db3 = this.getWritableDatabase();
        Cursor menuList = db3.rawQuery("select * from PackageDetails ", null);
        return menuList;

    }
}
