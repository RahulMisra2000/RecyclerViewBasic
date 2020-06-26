package com.rahulmisra.firebaseexample;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity implements ExampleRecyclerViewAdapter.I1 {
    // MEMBER FIELDS   m
    RecyclerView mRecyclerView;                                         // RecyclerView
    RecyclerView.LayoutManager lManager;                                // LayoutManager
    ExampleRecyclerViewAdapter mRecyclerViewAdapter;                    // Adapter
    ArrayList<Customer> mData = new ArrayList<>();                      // Data

    FloatingActionButton mFab;

    // This code's Github is here: https://github.com/RahulMisra2000/RecyclerViewBasic.git
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buildRecyclerView();
        buildFabListener();                                                                /* C of CRUD        - Clicking the FAB button does C of CRUD*/
    }

    private void buildFabListener() {
        mFab = findViewById(R.id.fab);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(v, "RRReplace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                */
                mData.add(new Customer(R.drawable.ic_2, ((Integer) (new Random().nextInt(100))).toString(), "New"));
                mRecyclerViewAdapter.notifyItemInserted(mData.size() - 1);          // Insert the data into the last position
                mRecyclerView.scrollToPosition(mRecyclerViewAdapter.getItemCount() - 1);    // And then scroll to it
            }
        });
    }

    private void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);

        getCustomers(mData);                                                                // Fill up data

        mRecyclerViewAdapter = new ExampleRecyclerViewAdapter(mData);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        /*
        There are 2 ways of sending reference to this Activity to the Adapter :
            1) Have the activity implement the interface and then send the activity (this) to the Adapter so it can call the methods
            2) Comment the above and then uncomment marker 2
         */
        mRecyclerViewAdapter.set1(this);

        /* - Marker 2
        mRecyclerViewAdapter.set1(new ExampleRecyclerViewAdapter.I1() {
            @Override
            public void entireRowClicked(int pos) {
                Toast.makeText(MainActivity2.this, "Row clicked " + String.valueOf(pos) + "-" + mData.get(pos).getCity(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void imageClicked(int pos) {
                Toast.makeText(MainActivity2.this, "Image clicked " + String.valueOf(pos) + "-" + mData.get(pos).getCity(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void text1Clicked(int pos) {
                Toast.makeText(MainActivity2.this, "Text1 clicked " + String.valueOf(pos) + "-" + mData.get(pos).getCity(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void text2Clicked(int pos) {
                Toast.makeText(MainActivity2.this, "Text2 clicked " + String.valueOf(pos) + "-" + mData.get(pos).getCity(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void btnUpdateClicked(int pos) {
                mData.set(pos, new Customer(R.drawable.ic_2,((Integer) (new Random().nextInt(100))).toString(), "updated"));
                mRecyclerViewAdapter.notifyItemChanged(pos);
            }

            @Override
            public void btnDeleteClicked(int pos) {
                Toast.makeText(MainActivity2.this, "Button Delete clicked " + String.valueOf(pos) + "-" + mData.get(pos).getCity(), Toast.LENGTH_SHORT).show();
                mData.remove(pos);
                mRecyclerViewAdapter.notifyItemRemoved(pos);
            }

        });
       */
    }

    @Override
    public void entireRowClicked(int pos) {
        Toast.makeText(MainActivity2.this, "Entire Row clicked " + String.valueOf(pos), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void imageClicked(int pos) {
        Toast.makeText(MainActivity2.this, "Image clicked " + String.valueOf(pos), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void text1Clicked(int pos) {
        Toast.makeText(MainActivity2.this, "Text1 clicked " + String.valueOf(pos) + "-" + mData.get(pos).getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void text2Clicked(int pos) {
        Toast.makeText(MainActivity2.this, "Text2 clicked " + String.valueOf(pos) + "-" + mData.get(pos).getCity(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void btnUpdateClicked(int pos) {
        mData.set(pos, new Customer(R.drawable.ic_2, ((Integer) (new Random().nextInt(100))).toString(), "updated"));
        mRecyclerViewAdapter.notifyItemChanged(pos);
    }

    @Override
    public void btnDeleteClicked(int pos) {
        Toast.makeText(MainActivity2.this, "Button Delete clicked " + String.valueOf(pos), Toast.LENGTH_SHORT).show();
        mData.remove(pos);
        mRecyclerViewAdapter.notifyItemRemoved(pos);
    }

    // Fill up data
    private void getCustomers(ArrayList<Customer> ac) {
        ac.add(new Customer(R.drawable.ic_1, ((Integer) (new Random().nextInt(100))).toString(), "M"));
        ac.add(new Customer(R.drawable.ic_2, ((Integer) (new Random().nextInt(100))).toString(), "M2"));
        ac.add(new Customer(R.drawable.ic_3, ((Integer) (new Random().nextInt(100))).toString(), "M3"));
    }
}