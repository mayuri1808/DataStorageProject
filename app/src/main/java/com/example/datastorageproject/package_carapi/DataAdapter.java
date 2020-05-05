package com.example.datastorageproject.package_carapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.datastorageproject.R;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<CarModel> articles=new ArrayList<>();
    private Context context;

    public DataAdapter(ArrayList<CarModel> articles, Context context) {
        this.context=context;
        this.articles=articles;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.items_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, final int i) {

        final String car_name=articles.get(i).getName();
        final String car_desc=articles.get(i).getDesc();

        viewHolder.car_name.setText(car_name);
        viewHolder.car_desc.setText(car_desc);

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView car_name,car_desc;


        public ViewHolder(View view) {
            super(view);
            car_name = (TextView)view.findViewById(R.id.car_name);
            car_desc = (TextView)view.findViewById(R.id.car_desc);
        }
    }

}