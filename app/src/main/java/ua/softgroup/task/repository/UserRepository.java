package ua.softgroup.task.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Слава on 19.05.2017.
 */

public class UserRepository extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DATABASE = "UserDb";
    public static final String TABLE = "Users";

    public static final String KEY_ID = "_id";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASS = "password";

    public UserRepository(Context context) {
        super(context, DATABASE, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE + "("
                    + KEY_ID + " integer primary key, "
                    + KEY_EMAIL + " text not null unique, "
                    + KEY_PASS + " text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE);
        onCreate(db);
    }
}
