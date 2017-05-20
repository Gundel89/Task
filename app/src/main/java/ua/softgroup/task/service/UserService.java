package ua.softgroup.task.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import ua.softgroup.task.repository.UserRepository;

/**
 * Created by Слава on 19.05.2017.
 */

public class UserService {

    private UserRepository repository;

    public UserService(Context context) {
        repository = new UserRepository(context);
    }
    
    public String getPassByEmail(String email) {
        SQLiteDatabase db = repository.getReadableDatabase();
        Cursor cursor = db.query(repository.TABLE, new String[] {repository.KEY_PASS}, repository.KEY_EMAIL
                    + " = ?", new String[] {email}, null, null, null);
        if (!cursor.moveToFirst()) {
            cursor.close();
            repository.close();
            return null;
        }
        String pass = cursor.getString(cursor.getColumnIndex(repository.KEY_PASS));
        cursor.close();
        repository.close();
        return pass;
    }

    public boolean createUser(String email, String pass) {
        SQLiteDatabase db = repository.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put(repository.KEY_EMAIL, email);
        val.put(repository.KEY_PASS, pass);
        if (db.insert(repository.TABLE, null, val) != -1) {
            repository.close();
            return true;
        } else {
            repository.close();
            return false;
        }
    }
}
