package com.gtx.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/7/2.
 */
public class Database
{
    private static Database instance = null;

    private String SELECT_ID = "select canteen_id from canteen where canteen = ";
    private String SELECT_ALL = "select * from " + Constant.DB_CANTEEN;
    private String SELECT_ALL_DISH = "select * from " + Constant.DB_DISH;
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

    public Canteen insertCanteen(String canteenname)
    {
        ContentValues values = new ContentValues();

        values.put(Constant.DB_CANTEEN, canteenname);

        sqLiteDatabase.insert(Constant.TABLE_CANTEEN, null, values);

        return new Canteen(canteenname, 0);
    }

    public void insertDish(int id, String dishname)
    {
        ContentValues values = new ContentValues();

        values.put(Constant.DB_CANTEEN_ID, id);
        values.put(Constant.DB_DISH, dishname);

        sqLiteDatabase.insert(Constant.TABLE_CANTEEN, null, values);
    }

    public int getCanteenId(String canteenname)
    {
        int ret = 0;

        String query = SELECT_ID + "'" + canteenname + "'";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        cursor.moveToFirst();
        ret = cursor.getInt(cursor.getColumnIndex(Constant.DB_CANTEEN_ID));

        return ret;
    }

    public List<Canteen> getCanteens()
    {
        List<Canteen> lists = new ArrayList<Canteen>();
        String query = SELECT_ALL;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        cursor.moveToFirst();
        while (cursor.moveToNext())
        {
            String canteenname = cursor.getString(cursor.getColumnIndex(Constant.DB_CANTEEN));
            Canteen canteen = new Canteen(canteenname, 0);
            lists.add(canteen);
        }
        return lists;
    }
    public List<Dish> getDishes(String canteenname)
    {
        int id = getCanteenId(canteenname);
        String query = SELECT_ALL_DISH + " where canteen_id = " + id;
        List<Dish> list = new ArrayList<Dish>();

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        cursor.moveToFirst();
        while (cursor.moveToNext())
        {
            String dishname = cursor.getString(cursor.getColumnIndex(Constant.DB_DISH));
            Dish dish = new Dish(id, dishname, 0);
            list.add(dish);
        }
        return list;
    }
}
