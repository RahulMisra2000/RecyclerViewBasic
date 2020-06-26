package com.rahulmisra.firebaseexample;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;

public class ExampleRecyclerViewAdapter extends RecyclerView.Adapter<ExampleRecyclerViewAdapter.ExampleViewHolder> {

    // Interface            -- This could have been defined in a separate file
    public interface I1 {
        void entireRowClicked(int pos);
        void imageClicked(int pos);
        void text1Clicked(int pos);
        void text2Clicked(int pos);
        void btnUpdateClicked(int pos);
        void btnDeleteClicked(int pos);
    }

    // Member variables
    ArrayList<Customer> mCustomers;
    I1 mI1;

    // Constructor
    public ExampleRecyclerViewAdapter(ArrayList<Customer> c) {
        mCustomers = c;
    }

    // Methods - think of this as getting a reference to the activity
    public void set1(I1 i){
        mI1 = i;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlayout, parent, false);
        return new ExampleViewHolder(v, mI1);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        holder.iV.setImageResource(mCustomers.get(position).getImage());
        holder.tV1.setText(mCustomers.get(position).getName());
        holder.tV2.setText(mCustomers.get(position).getCity());
    }

    @Override
    public int getItemCount() {
        return mCustomers.size();
    }

    // Static Class **********************************************************************
    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView iV;
        TextView tV1;
        TextView tV2;
        Button btnUpdate;
        Button btnDelete;

        public ExampleViewHolder(@NonNull View itemView, final I1 i) {
            super(itemView);
            iV = (ImageView) itemView.findViewById(R.id.imageView);
            tV1 = (TextView) itemView.findViewById(R.id.textView1);
            tV2 = (TextView) itemView.findViewById(R.id.textView2);

            btnUpdate = (Button) itemView.findViewById(R.id.btnUpdate);
            btnDelete = (Button) itemView.findViewById(R.id.btnDelete);

            // Listeners
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (i != null && pos != RecyclerView.NO_POSITION) {
                        i.entireRowClicked(getAdapterPosition());
                    }
                }
            });

            iV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (i != null && pos != RecyclerView.NO_POSITION) {
                        i.imageClicked(getAdapterPosition());
                    }

                }
            });

            tV1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (i != null && pos != RecyclerView.NO_POSITION) {
                        i.text1Clicked(getAdapterPosition());
                    }

                }
            });

            tV2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (i != null && pos != RecyclerView.NO_POSITION) {
                        i.text2Clicked(getAdapterPosition());
                    }

                }
            });

            btnUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (i != null && pos != RecyclerView.NO_POSITION) {
                        i.btnUpdateClicked(getAdapterPosition());
                    }

                }
            });

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (i != null && pos != RecyclerView.NO_POSITION) {
                        i.btnDeleteClicked(getAdapterPosition());
                    }

                }
            });
        }

    }
}
