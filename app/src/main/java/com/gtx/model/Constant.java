package com.gtx.model;

/**
 * Created by Administrator on 2015/6/29.
 */
public class Constant
{
    public final static String SHAKETOEAT = "shaketoeat";
    public final static String ISFIRST = "isfirst";

    public final static String CREATE_CANTEEN_TABLE = "create table canteen(canteen_id INTEGER PRIMARY KEY AUTOINCREMENT, canteen varchar, canteen_weight INTEGER)";
    public final static String CREATE_DISH_TABLE = "create table dish(canteen_id integer, dish varchar(255), dish_weight INTEGER)";

    public final static String DB_CANTEEN = "canteen";
    public final static String TABLE_CANTEEN = "canteen";

    public final static String DB_CANTEEN_ID = "canteen_id";
    public final static String DB_DISH = "dish";
    public final static String TABLE_DISH = "dish";

    public final static String DB_CANTEEN_WEIGHT = "canteen_weight";
    public final static String DB_DISH_WEIGHT = "dish_weight";
}
