package com.gtx.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Administrator on 2015/7/2.
 */
public class Database
{
    private static Database instance = null;

    private SQLiteDatabase sqLiteDatabase;

    private Database(Context context)
    {
        sqLiteDatabase = context.openOrCreateDatabase(Constant.SHAKETOEAT, context.MODE_PRIVATE, null);
    }

    public static Database getInstance(Context context)
    {
        if(instance == null)
        {
            instance = new Database(context);
        }
        return instance;
    }

    public static Database getInstance()
    {
        return instance;
    }

    public void insertCanteen(String canteenname)
    {
        ContentValues values = new ContentValues();

        values.put(Constant.DB_CANTEEN, canteenname);

        sqLiteDatabase.insert(Constant.TABLE_CANTEEN, null, values);
    }

    public void insertDish(int id, String dishname)
    {
        ContentValues values = new ContentValues();

        values.put(Constant.DB_CANTEEN_ID, id);
        values.put(Constant.DB_DISH, dishname);

        sqLiteDatabase.insert(Constant.TABLE_CANTEEN, null, values);
    }
}
