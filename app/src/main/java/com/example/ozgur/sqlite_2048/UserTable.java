package com.example.ozgur.sqlite_2048;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Ozgur on 27/03/2016.
 */
public class UserTable {

    public static final String TABLE_NAME = "user";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_ZIPCODE = "zipcode";
    public static final String COLUMN_CITY = "city";

    private static final String CREATE_TABLE = "create table IF NOT EXISTS " + TABLE_NAME
            + " (_id integer primary key autoincrement, "
            + COLUMN_NAME + " text, "
            + COLUMN_AGE + " numeric, "
            + COLUMN_ADDRESS + " text, "
            + COLUMN_ZIPCODE + " numeric, "
            + COLUMN_CITY + " text "
            + ");";

    public static void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    public static void onUpdate(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static User constructFromDatabase(Cursor cursor) {
        User user = new User();
        user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
        user.setAge(cursor.getInt(cursor.getColumnIndex(COLUMN_AGE)));
        user.setAdress(cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESS)));
        user.setZipcode(cursor.getInt(cursor.getColumnIndex(COLUMN_ZIPCODE)));
        user.setCity(cursor.getString(cursor.getColumnIndex(COLUMN_CITY)));
        return user;
    }

    public static ContentValues getContentValues(User user) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_NAME, user.getName());
        contentValues.put(COLUMN_AGE, user.getAge());
        contentValues.put(COLUMN_ADDRESS, user.getAdress());
        contentValues.put(COLUMN_ZIPCODE, user.getZipcode());
        contentValues.put(COLUMN_CITY, user.getCity());

        return contentValues;
    }
}
