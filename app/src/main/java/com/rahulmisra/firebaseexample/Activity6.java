package com.rahulmisra.firebaseexample;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.res.ResourcesCompat;

import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Activity6 extends AppCompatActivity {
    ConstraintLayout mV;
    TextView mTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);
        Toolbar toolbar = findViewById(R.id.tbar);
        setSupportActionBar(toolbar);
        mTv = (TextView) findViewById(R.id.textView4);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              mTv.setTypeface(ResourcesCompat.getFont(Activity6.this, R.font.alegreya_black_italic));

              /* ------------- Showing a popup menu */
              PopupMenu pm = new PopupMenu(Activity6.this, view);
              pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                  @Override
                  public boolean onMenuItemClick(MenuItem item) {
                      // Here check item to see what was clicked and then accordingly do something ...
                      return false;
                  }
              });
              pm.inflate(R.menu.menu);
              pm.show();
              /* ------------- Showing a popup menu */

            }
        });


    }
}