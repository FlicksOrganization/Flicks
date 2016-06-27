package com.example.gaetanejulmiste.flicks.Adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.widget.RecyclerView;
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

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gaetanejulmiste on 6/15/16.
 */
public class MovieArrayAdapter extends ArrayAdapter<Movie> {


    public static class ViewHolder {
         // ImageView ivImage ;
        //TextView tvTitle ;
        //TextView tvOverview ;
        @BindView(R.id.ivImage)  ImageView ivImage ;
        @BindView(R.id.tvDescription) TextView tvTitle ;
        @BindView(R.id.tvOverview) TextView tvOverview ;
        @BindView(R.id.ivBackDrop) ImageView iBackdrop ;

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
            viewHolder.iBackdrop = (ImageView) convertView.findViewById(R.id.ivBackDrop);

           convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvTitle.setText(movie.getPosterTitle());
        viewHolder.tvOverview.setText(movie.getOverView());
        //viewHolder.ivImage.setImageResource(0);
        //viewHolder.iBackdrop.setImageResource(0);

      /*
      ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivImage);
        ivImage.setImageResource(0);
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvDescription);
        TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);
        tvTitle.setText(movie.getPosterTitle());
        tvOverview.setText(movie.getOverView());
        */
        int orientation;
        orientation = getContext().getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT){
            Picasso.with(getContext()).load(movie.getPosterPath()).into(viewHolder.ivImage);
        }else if (orientation==Configuration.ORIENTATION_LANDSCAPE){
            Picasso.with(getContext()).load(movie.getBackdropPath()).into(viewHolder.iBackdrop);
        }


        //Picasso.with(getContext()).load(movie.getPosterPath()).into(viewHolder.ivImage);
        //Picasso.with(getContext()).load(movie.getBackdropPath()).into(viewHolder.iBackdrop);

        ButterKnife.bind(convertView);
        return convertView;
    }
}
