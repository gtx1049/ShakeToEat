package com.gtx.shaketoeat;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.gtx.model.Canteen;
import com.gtx.model.Constant;
import com.gtx.model.RandomPick;


public class MainActivity extends Activity implements SensorEventListener
{
    private Button clear;
    private Button config;
    private SensorManager sensorManager;
    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取传感器管理服务
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        //震动
        vibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);


        config = (Button)findViewById(R.id.config);
        config.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, Config.class);
                startActivityForResult(intent, 0);
            }
        });

        firstRun();
    }

    @Override
    protected  void onResume()
    {
        super.onResume();
        //加速度传感器
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                //还有SENSOR_DELAY_UI、SENSOR_DELAY_FASTEST、SENSOR_DELAY_GAME等，
                //根据不同应用，需要的反应速率不同，具体根据实际情况设定
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        // TODO Auto-generated method stub
        int sensorType = event.sensor.getType();

        //values[0]:X轴，values[1]：Y轴，values[2]：Z轴
        float[] values = event.values;

        if (sensorType == Sensor.TYPE_ACCELEROMETER)
        {

          /*因为一般正常情况下，任意轴数值最大就在9.8~10之间，只有在你突然摇动手机
          *的时候，瞬时加速度才会突然增大或减少。
          *所以，经过实际测试，只需监听任一轴的加速度大于14的时候，改变你需要的设置
          *就OK了~~~
          */
            if ((Math.abs(values[0]) > 14 || Math.abs(values[1]) > 14 || Math.abs(values[2]) > 14))
            {

                String name = pickToEat();
                //摇动手机后，设置button上显示的字为空
                //clear.setText(name);

                //摇动手机后，再伴随震动提示~~
                vibrator.vibrate(500);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {

    }

    private String pickToEat()
    {
        RandomPick rp = new RandomPick();
        Canteen c = rp.pickCanteen();
        return c.getName();
    }

    private void firstRun()
    {
        SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase(Constant.SHAKETOEAT, MODE_PRIVATE,null);
        SharedPreferences sharedPreferences = getSharedPreferences(Constant.SHAKETOEAT, MODE_PRIVATE);

        boolean isfirstrun = sharedPreferences.getBoolean(Constant.ISFIRST, false);
        if(!isfirstrun)
        {

            sqLiteDatabase.execSQL(Constant.CREATE_TABLE);

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(Constant.ISFIRST, true);
            editor.commit();
        }
    }

}
