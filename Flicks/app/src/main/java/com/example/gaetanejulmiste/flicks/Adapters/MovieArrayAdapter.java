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

    public MovieArrayAdapter(Context context, List<Movie> movieList) {
        super(context, android.R.layout.simple_list_item_1,movieList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Movie movie = getItem(position);
        if (convertView == null){
            LayoutInflater inflater =LayoutInflater.from(getContext());
            convertView= inflater.inflate(R.layout.item_movie,parent,false);

        }

        ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivImage);
        ivImage.setImageResource(0);
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvDescription);
        TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);
        tvTitle.setText(movie.getPosterTitle());
        tvOverview.setText(movie.getOverView());

        Picasso.with(getContext()).load(movie.getPosterPath()).into(ivImage);


        return convertView;
    }
}
