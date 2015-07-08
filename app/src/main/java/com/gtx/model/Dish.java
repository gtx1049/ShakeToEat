package com.gtx.model;

/**
 * Created by Administrator on 2015/4/27.
 */
public class Dish
{
    private String dishname;
    private int weight;

    public Dish(int canteenid, String dishname, int weight)
    {
        this.dishname = dishname;
        this.weight = weight;
    }

    public String getDishname()
    {
        return dishname;
    }
}
