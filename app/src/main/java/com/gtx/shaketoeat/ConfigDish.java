package com.gtx.shaketoeat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.DataSetObserver;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.gtx.model.Database;


public class ConfigDish extends ActionBarActivity
{

    private ListView dishlist;
    private Button dishbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_dish);

        dishlist = (ListView)findViewById(R.id.dishlist);
        dishlist.setAdapter(new DishAdapter());

        dishbutton = (Button)findViewById(R.id.add_dish);
        dishbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText editText = new EditText(ConfigDish.this);
                new AlertDialog.Builder(ConfigDish.this).setTitle("Please Input :").setIcon(
                        android.R.drawable.ic_dialog_info).setView(
                        editText).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int which) {
                        // TODO Auto-generated method stub
                        String canteenname = editText.getText().toString();
                        Database.getInstance().insertCanteen(canteenname);
                    }
                })
                        .setNegativeButton("Cancel", null).show();
            }
        });
    }

    public class DishAdapter extends BaseAdapter
    {


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
        public View getView(int position, View convertView, ViewGroup parent)
        {
            return null;
        }
    }
}
