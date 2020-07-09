package com.example.disasterpro;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>
{
    private ArrayList<IndiaItem> races;
    public CustomAdapter(ArrayList<IndiaItem> races){
        this.races=races;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_layout,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TextView location=holder.location;
        TextView time=holder.time;
        //TextView date=holder.date;
        ImageView track=holder.track;
        location.setText(races.get(position).getLocation());

       // date.setText(races.get(position).getDate());
        track.setImageResource(races.get(position).getImageId());

    }

    @Override
    public int getItemCount() {
        return races.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView location,time,date;
        ImageView track;
        public MyViewHolder(View itemView){
            super(itemView);
            location=(TextView)itemView.findViewById(R.id.Location);
            date=(TextView)itemView.findViewById(R.id.Date);
            track=(ImageView)itemView.findViewById(R.id.Track);

        }
    }


}
