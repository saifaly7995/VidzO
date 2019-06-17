package com.example.vidzo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    Context context;
    List<Movie> mData;

    public MovieAdapter(Context context, List<Movie> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //Layout Inflater
        View v= LayoutInflater.from(context).inflate(R.layout.item_movie,viewGroup,false);

        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MyViewHolder myViewHolder, int i) {

        //Set Image and Title here
        myViewHolder.title.setText(mData.get(i).getTitle());
        myViewHolder.img.setImageResource(mData.get(i).getThumbnail());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    //Initialize widgets here

    public class MyViewHolder extends RecyclerView.ViewHolder{

        //Widgets
        private TextView title;
        private ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.tv_item_movie_title);
            img=itemView.findViewById(R.id.item_movie_img);
        }
    }
}
