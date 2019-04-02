package com.maruf.bloodfinder.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class BloodDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "Donor_DB";
    public static final int DB_VERSION = 1;

    public static final String TABLE_DONOR = "table_donor";
    public static final String TABLE_DONOR_COL_ID = "donor_id";
    public static final String TABLE_DONOR_COL_NAME = "donor_name";
    public static final String TABLE_DONOR_COL_BG = "donor_bg";
    public static final String TABLE_DONOR_COL_GENDER = "donor_gender";
    public static final String TABLE_DONOR_COL_PHONE = "donor_phone";
    public static final String TABLE_DONOR_COL_EMAIL = "donor_email";
    public static final String TABLE_DONOR_COL_ADDRESS = "donor_address";
    public static final String TABLE_DONOR_COL_STATUS = "donor_status";
    public static final String TABLE_DONOR_COL_PASSWORD = "donor_password";

    public static final String TABLE_BLOODREQUEST = "table_blood_request";
    public static final String TABLE_BLOODREQUEST_COL_ID = "request_id";
    public static final String TABLE_BLOODREQUEST_COL_NAME = "request_name";
    public static final String TABLE_BLOODREQUEST_COL_PHONE = "request_phone";
    public static final String TABLE_BLOODREQUEST_COL_EMAIL = "request_email";
    public static final String TABLE_BLOODREQUEST_COL_ADDRESS = "request_address";
    public static final String TABLE_BLOODREQUEST_COL_DONORID = "request_donor_id";


    public static final String TABLE_FAVOURITE = "table_favourite";
    public static final String TABLE_FAVOURITE_COL_ID = "id";
    public static final String TABLE_FAVOURITE_COL_FAVDONOR_ID = "fav_donor_id";

    public static final String CREATE_TABLE_DONOR =
            "create table " +TABLE_DONOR +"("+
                    TABLE_DONOR_COL_ID +" integer primary key, "+
                    TABLE_DONOR_COL_NAME +" text, "+
                    TABLE_DONOR_COL_BG +" text, "+
                    TABLE_DONOR_COL_GENDER +" text, "+
                    TABLE_DONOR_COL_PHONE +" text, "+
                    TABLE_DONOR_COL_EMAIL +" text, "+
                    TABLE_DONOR_COL_ADDRESS +" text, "+
                    TABLE_DONOR_COL_STATUS +" text, " +
                    TABLE_DONOR_COL_PASSWORD +" text )";


    public static final String CREATE_TABLE_BLOODREQUEST =
            "create table " +TABLE_BLOODREQUEST +"("+
                    TABLE_BLOODREQUEST_COL_ID +" integer primary key, "+
                    TABLE_BLOODREQUEST_COL_NAME +" text, "+
                    TABLE_BLOODREQUEST_COL_PHONE +" text, "+
                    TABLE_BLOODREQUEST_COL_EMAIL +" text, "+
                    TABLE_BLOODREQUEST_COL_ADDRESS +" text, "+
                    TABLE_BLOODREQUEST_COL_DONORID +" integer )";

    public static final String CREATE_TABLE_FAVOURITE =
            "create table " +TABLE_FAVOURITE +"("+
                    TABLE_FAVOURITE_COL_ID +" integer primary key, "+
                    TABLE_FAVOURITE_COL_FAVDONOR_ID +" integer )";




    public BloodDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_DONOR);
        db.execSQL(CREATE_TABLE_BLOODREQUEST);
        db.execSQL(CREATE_TABLE_FAVOURITE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
