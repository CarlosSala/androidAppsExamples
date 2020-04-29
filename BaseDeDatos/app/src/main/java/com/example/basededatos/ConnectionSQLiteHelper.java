package com.example.basededatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.basededatos.utilities.Utilities;

// class to connect to SQLite
public class ConnectionSQLiteHelper extends SQLiteOpenHelper {


    // once instanced the class is created the connection with database
    public ConnectionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase_) {
        sqLiteDatabase_.execSQL(Utilities.CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase_, int i, int i1) {
        sqLiteDatabase_.execSQL("DROP TABLE IF EXISTS users");
        onCreate(sqLiteDatabase_);
    }
}
