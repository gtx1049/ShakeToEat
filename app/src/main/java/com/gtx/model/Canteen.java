package com.gtx.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/4/27.
 */
public class Canteen
{
    public final static String[] CANTEES =
    {"新食堂1楼","新食堂2楼", "新食堂3楼","7食堂", "3食堂", "清真食堂","京工食堂"};
    public final static int[] WEIGHT =
            {10, 30, 20, 10, 10, 10, 10};

    private String name;
    private int weight;

    private List<Dish> dishs;

    public Canteen(String name, int weight)
    {
        this.name = name;
        this.weight = weight;
        dishs = new ArrayList<Dish>();
    }

    public String getName()
    {
        return name;
    }

    public int getWeight()
    {
        return weight;
    }

    static public void insertCanteen(String canteenname)
    {

    }
}
