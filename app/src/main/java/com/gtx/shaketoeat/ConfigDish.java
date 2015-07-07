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
import android.widget.RadioGroup;

import com.gtx.model.Constant;
import com.gtx.model.Database;


public class ConfigDish extends ActionBarActivity
{

    private ListView dishlist;
    private Button dishbutton;

    private AddDialog adddialog;

    private String canteenname;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_dish);

        canteenname = getIntent().getStringExtra(Constant.DB_CANTEEN);
        

        dishlist = (ListView)findViewById(R.id.dishlist);
        dishlist.setAdapter(new DishAdapter());

        adddialog = new AddDialog(ConfigDish.this);
        adddialog.setOnPositiveListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EditText editText = adddialog.getEditText();
                String name = editText.getText().toString();
                RadioGroup radioGroup = adddialog.getRadioGroup();
                int id = radioGroup.getCheckedRadioButtonId();

                int canteenid = Database.getInstance().getCanteenId(canteenname);
                Database.getInstance().insertDish(canteenid, name, id);
            }
        });
        adddialog.setOnNegativeListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                adddialog.dismiss();
            }
        });

        dishbutton = (Button)findViewById(R.id.add_dish);
        dishbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                adddialog.show();
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
