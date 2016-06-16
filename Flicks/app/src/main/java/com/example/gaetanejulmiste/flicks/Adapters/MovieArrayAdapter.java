package com.example.gaetanejulmiste.flicks.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gaetanejulmiste.flicks.Models.Movie;
import com.example.gaetanejulmiste.flicks.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by gaetanejulmiste on 6/15/16.
 */
public class MovieArrayAdapter extends ArrayAdapter<Movie>{


    private static class ViewHolder {
        ImageView ivImage ;
        TextView tvTitle ;
        TextView tvOverview ;


    }


    public MovieArrayAdapter(Context context, List<Movie> movieList) {
        super(context, android.R.layout.simple_list_item_1,movieList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Movie movie = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater =LayoutInflater.from(getContext());
            convertView= inflater.inflate(R.layout.item_movie,parent,false);
            viewHolder.ivImage = (ImageView) convertView.findViewById(R.id.ivImage);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvDescription);
            viewHolder.tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);
           convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvTitle.setText(movie.getPosterTitle());
        viewHolder.tvOverview.setText(movie.getOverView());

      /*
      ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivImage);
        ivImage.setImageResource(0);
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvDescription);
        TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);
        tvTitle.setText(movie.getPosterTitle());
        tvOverview.setText(movie.getOverView());
        */
        Picasso.with(getContext()).load(movie.getPosterPath()).into(viewHolder.ivImage);


        return convertView;
    }
}
