package com.gtx.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/4/27.
 */
public class RandomPick
{
    List<Canteen> list;
    List<Integer> head;

    public RandomPick()
    {
        int current = 0;

        list = new ArrayList<Canteen>();
        head = new ArrayList<Integer>();

        for(int i = 0; i < Canteen.CANTEES.length; i++)
        {
            Canteen c = new Canteen(Canteen.CANTEES[i], Canteen.WEIGHT[i]);
            list.add(c);
            head.add(current);
            current += c.getWeight();
        }
    }

    public Canteen pickCanteen()
    {
        int picknum = (int)(Math.random() * 100);
        System.out.print(picknum);
        for(int i = 0; i < list.size(); i++)
        {
            if(picknum >= head.get(i) && picknum < head.get(i) + list.get(i).getWeight())
            {
                return list.get(i);
            }
        }
        return null;
    }
}
