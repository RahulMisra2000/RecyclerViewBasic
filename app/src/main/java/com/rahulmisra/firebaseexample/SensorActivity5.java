package com.rahulmisra.firebaseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

// https://www.tutlane.com/tutorial/android/android-sensors-with-examples
// List of sensors
public class SensorActivity5 extends AppCompatActivity {

    SensorManager sm;
    Sensor s;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor5);
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        tv = findViewById(R.id.textViewSensorDetails);
        List<Sensor> sensorList = sm.getSensorList(Sensor.TYPE_ALL);
        StringBuilder strBuilder = new StringBuilder();
        for(Sensor s: sensorList){
            strBuilder.append(s.getName()+"\n");
        }
        tv.setVisibility(View.VISIBLE);
        tv.setText(strBuilder);

    }
}