package com.gtx.model;

/**
 * Created by Administrator on 2015/6/29.
 */
public class Constant
{
    public final static String SHAKETOEAT = "shaketoeat";
    public final static String ISFIRST = "isfirst";

    public final static String CREATE_CANTEEN_TABLE = "create table canteen(canteen_id INTEGER PRIMARY KEY AUTOINCREMENT, canteen varchar)";
    public final static String CREATE_DISH_TABLE = "create table dish(canteen_id integer, dish varchar(255))";
}
