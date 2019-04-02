package com.maruf.bloodfinder.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.maruf.bloodfinder.Model.Donor;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    private BloodDBHelper dbHelper;
    private SQLiteDatabase db;

    public DataSource(Context context) {

       dbHelper = new BloodDBHelper(context);
    }

    public void openDB(){

        db = dbHelper.getWritableDatabase();
    }

    public void closeDB(){

        db.close();
    }

    public long insertNewDonor(Donor donor){

        this.openDB();

        ContentValues values = new ContentValues();

        values.put(BloodDBHelper.TABLE_DONOR_COL_NAME, donor.getName());
        values.put(BloodDBHelper.TABLE_DONOR_COL_BG, donor.getBloodGroup());
        values.put(BloodDBHelper.TABLE_DONOR_COL_GENDER, donor.getGender());
        values.put(BloodDBHelper.TABLE_DONOR_COL_PHONE, donor.getPhone());
        values.put(BloodDBHelper.TABLE_DONOR_COL_EMAIL, donor.getEmail());
        values.put(BloodDBHelper.TABLE_DONOR_COL_ADDRESS, donor.getAddress());
        values.put(BloodDBHelper.TABLE_DONOR_COL_STATUS, donor.getStatus());
        values.put(BloodDBHelper.TABLE_DONOR_COL_PASSWORD, donor.getPassword());

        long insertedRow = db.insert(BloodDBHelper.TABLE_DONOR, null, values);

        this.closeDB();

        return insertedRow;
    }


    public long insertFavourite(int donorid){

        this.openDB();

        ContentValues values = new ContentValues();

        values.put(BloodDBHelper.TABLE_FAVOURITE_COL_FAVDONOR_ID, donorid);

        long insertedRow = db.insert(BloodDBHelper.TABLE_FAVOURITE, null, values);

        this.closeDB();

        return insertedRow;
    }

    public int deleteDonor(int donorid){

        this.openDB();

        int deletedRow = db.delete(BloodDBHelper.TABLE_DONOR,
                 BloodDBHelper.TABLE_DONOR_COL_ID +" = "+donorid, null);

        this.closeDB();

        return deletedRow;
    }

    public int updateDonor(Donor donor){

        this.openDB();

        ContentValues values = new ContentValues();

        values.put(BloodDBHelper.TABLE_DONOR_COL_NAME, donor.getName());
        values.put(BloodDBHelper.TABLE_DONOR_COL_BG, donor.getBloodGroup());
        values.put(BloodDBHelper.TABLE_DONOR_COL_GENDER, donor.getGender());
        values.put(BloodDBHelper.TABLE_DONOR_COL_PHONE, donor.getPhone());
        values.put(BloodDBHelper.TABLE_DONOR_COL_EMAIL, donor.getEmail());
        values.put(BloodDBHelper.TABLE_DONOR_COL_ADDRESS, donor.getAddress());
        values.put(BloodDBHelper.TABLE_DONOR_COL_STATUS, donor.getStatus());
        values.put(BloodDBHelper.TABLE_DONOR_COL_PASSWORD, donor.getPassword());

        int updatedRow = db.update(BloodDBHelper.TABLE_DONOR,values
                ,BloodDBHelper.TABLE_DONOR_COL_ID +" = "+donor.getId(),
                null);

        this.closeDB();

        return updatedRow;
    }

    public List<Donor> searchDonor(String bg, String gndr, String area){

        List<Donor> donorList = new ArrayList<>();

        this.openDB();

        Cursor cursor = db.rawQuery("select * from " +BloodDBHelper.TABLE_DONOR /*+" where "
                +BloodDBHelper.TABLE_DONOR_COL_BG +" = " +bg +" and "
                +BloodDBHelper.TABLE_DONOR_COL_GENDER +" = " +gndr +" and "
                +BloodDBHelper.TABLE_DONOR_COL_ADDRESS +" like " +"%" +area +"%"
                */,null);

        if(cursor != null && cursor.getCount() > 0){

            cursor.moveToFirst();

            do {

                int id = cursor.getInt(cursor.getColumnIndex(BloodDBHelper.TABLE_DONOR_COL_ID));
                String name = cursor.getString(cursor.getColumnIndex(BloodDBHelper.TABLE_DONOR_COL_NAME));
                String gender = cursor.getString(cursor.getColumnIndex(BloodDBHelper.TABLE_DONOR_COL_GENDER));
                String bloodGroup = cursor.getString(cursor.getColumnIndex(BloodDBHelper.TABLE_DONOR_COL_BG));
                String phone = cursor.getString(cursor.getColumnIndex(BloodDBHelper.TABLE_DONOR_COL_PHONE));
                String email = cursor.getString(cursor.getColumnIndex(BloodDBHelper.TABLE_DONOR_COL_EMAIL));
                String address = cursor.getString(cursor.getColumnIndex(BloodDBHelper.TABLE_DONOR_COL_ADDRESS));
                String status = cursor.getString(cursor.getColumnIndex(BloodDBHelper.TABLE_DONOR_COL_STATUS));
                String password = cursor.getString(cursor.getColumnIndex(BloodDBHelper.TABLE_DONOR_COL_PASSWORD));

                donorList.add(new Donor(id,name,bloodGroup,gender,phone,email,address,status,password));

            }while (cursor.moveToNext());


        }

        cursor.close();
        this.closeDB();

        return donorList;
    }


    public Donor getDonorDetailByID(int donorID) {

        Donor donor = null;

        this.openDB();

        Cursor cursor = db.rawQuery("select * from " +BloodDBHelper.TABLE_DONOR +" where "
                        +BloodDBHelper.TABLE_DONOR_COL_ID +" = " +donorID,null);

        if(cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();

            int id = cursor.getInt(cursor.getColumnIndex(BloodDBHelper.TABLE_DONOR_COL_ID));
            String name = cursor.getString(cursor.getColumnIndex(BloodDBHelper.TABLE_DONOR_COL_NAME));
            String gender = cursor.getString(cursor.getColumnIndex(BloodDBHelper.TABLE_DONOR_COL_GENDER));
            String bloodGroup = cursor.getString(cursor.getColumnIndex(BloodDBHelper.TABLE_DONOR_COL_BG));
            String phone = cursor.getString(cursor.getColumnIndex(BloodDBHelper.TABLE_DONOR_COL_PHONE));
            String email = cursor.getString(cursor.getColumnIndex(BloodDBHelper.TABLE_DONOR_COL_EMAIL));
            String address = cursor.getString(cursor.getColumnIndex(BloodDBHelper.TABLE_DONOR_COL_ADDRESS));
            String status = cursor.getString(cursor.getColumnIndex(BloodDBHelper.TABLE_DONOR_COL_STATUS));
            String password = cursor.getString(cursor.getColumnIndex(BloodDBHelper.TABLE_DONOR_COL_PASSWORD));

            donor = new Donor(id,name,bloodGroup,gender,phone,email,address,status,password);



        }

        cursor.close();
        this.closeDB();

        return donor;
    }

    public int getDonorIDByEmailPass(String email, String password) {

        int donorID = -1;

        this.openDB();

        Cursor cursor = db.rawQuery("select * from " +BloodDBHelper.TABLE_DONOR +" where "
                +BloodDBHelper.TABLE_DONOR_COL_EMAIL +" = " +email +" and "
                +BloodDBHelper.TABLE_DONOR_COL_PASSWORD +" = " +password ,null);

        if(cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();

            donorID = cursor.getInt(cursor.getColumnIndex(BloodDBHelper.TABLE_DONOR_COL_ID));


        }

        cursor.close();
        this.closeDB();

        return donorID;
    }
}
