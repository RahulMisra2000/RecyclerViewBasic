package com.rahulmisra.firebaseexample;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Toolbar toolbar = findViewById(R.id.tbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.mnu_1:
                startActivity(new Intent(this, MainActivity.class));
                return true;
            case R.id.mnu_2:
                startActivity(new Intent(this, MainActivity2.class));
                return true;
            case R.id.mnu_3:
                startActivity(new Intent(this, MainActivity3.class));
                return true;
            case R.id.mnu_4:
                startActivity(new Intent(this, MainActivity4.class));
                return true;
            case R.id.mnu_5:
                startActivity(new Intent(this, SensorActivity5.class));
                return true;
            case R.id.mnu_6:
                startActivity(new Intent(this, Activity6.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}