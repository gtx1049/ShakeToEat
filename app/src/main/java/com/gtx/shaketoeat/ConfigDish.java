package com.gtx.shaketoeat;

import android.database.DataSetObserver;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;


public class ConfigDish extends ActionBarActivity
{

    private ListView dishlist;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_dish);

        dishlist = (ListView)findViewById(R.id.dishlist);
        dishlist.setAdapter(new DishAdapter());

    }

    public class DishAdapter implements ListAdapter
    {

        @Override
        public boolean areAllItemsEnabled()
        {
            return false;
        }

        @Override
        public boolean isEnabled(int position)
        {
            return false;
        }

        @Override
        public void registerDataSetObserver(DataSetObserver observer)
        {

        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver observer)
        {

        }

        @Override
        public int getCount()
        {
            return 0;
        }

        @Override
        public Object getItem(int position)
        {
            return null;
        }

        @Override
        public long getItemId(int position)
        {
            return 0;
        }

        @Override
        public boolean hasStableIds()
        {
            return false;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            return null;
        }

        @Override
        public int getItemViewType(int position)
        {
            return 0;
        }

        @Override
        public int getViewTypeCount()
        {
            return 0;
        }

        @Override
        public boolean isEmpty()
        {
            return false;
        }
    }
}
