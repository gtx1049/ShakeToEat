package com.gtx.shaketoeat;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.gtx.model.Canteen;
import com.gtx.model.Constant;
import com.gtx.model.Database;

import java.util.List;


public class Config extends ActionBarActivity
{
    private ListView canteenlistView;
    private Button canteenbutton;

    private List<Canteen> canteenList;
    private CanteenAdapter canteenAdapter;

    private AddDialog adddialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        canteenList = Database.getInstance().getCanteens();

        canteenAdapter = new CanteenAdapter();
        canteenlistView = (ListView)findViewById(R.id.canteenlist);
        canteenlistView.setAdapter(canteenAdapter);

        canteenbutton = (Button)findViewById(R.id.add_canteen);

        adddialog = new AddDialog(Config.this);
        adddialog.setOnPositiveListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EditText editText = adddialog.getEditText();
                String name = editText.getText().toString();
                RadioGroup radioGroup = adddialog.getRadioGroup();
                int id = radioGroup.getCheckedRadioButtonId();
                Database.getInstance().insertCanteen(name, id);
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

        canteenbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                adddialog.show();
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

            convertView.setOnClickListener(new ViewClickListener(position));

            return convertView;
        }
    }

    public class ViewClickListener implements View.OnClickListener
    {
        private int tmpposition;

        public ViewClickListener(int position)
        {
            tmpposition = position;
        }

        @Override
        public void onClick(View v)
        {
            Intent intent = new Intent(Config.this, ConfigDish.class);
            intent.putExtra(Constant.DB_CANTEEN, canteenList.get(tmpposition).getName());
            startActivity(intent);
        }
    }
}
