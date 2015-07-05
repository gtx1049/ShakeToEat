package com.gtx.shaketoeat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.DataSetObserver;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.gtx.model.Canteen;
import com.gtx.model.Database;

import java.util.List;


public class Config extends ActionBarActivity
{
    private ListView canteenlsit;
    private Button canteenbutton;

    private List<Canteen> canteenList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        canteenList = Database.getInstance().getCanteens();

        canteenlsit = (ListView)findViewById(R.id.canteenlist);
        canteenlsit.setAdapter(new CanteenAdapter());

        canteenbutton = (Button)findViewById(R.id.add_canteen);

        canteenbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(Config.this).setTitle("Please Input :").setIcon(
                        android.R.drawable.ic_dialog_info).setView(
                        new EditText(Config.this)).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int which) {
                        // TODO Auto-generated method stub

                    }
                })
                .setNegativeButton("Cancel", null).show();
            }
        });
    }

    public class CanteenAdapter extends BaseAdapter
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
            convertView = LayoutInflater.from(Config.this).inflate(R.layout.canteen_item, null);
            TextView tv = (TextView)convertView.findViewById(R.id.canteen_name);
            tv.setText(canteenList.get(position).getName());

            return convertView;
        }
    }
}
