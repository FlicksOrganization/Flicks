package com.example.gaetanejulmiste.flicks.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by gaetanejulmiste on 6/15/16.
 */
public class Movie {
    String posterPath;
    String posterTitle;
    String overView;
    String backdropPath;

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/"+ backdropPath);
    }



    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/"+ posterPath) ;
    }

    public String getPosterTitle() {
        return posterTitle;
    }

    public String getOverView() {
        return overView;
    }




    public Movie (JSONObject jsonObject){

        try {
            this.posterPath = jsonObject.getString("poster_path");
            this.posterTitle = jsonObject.getString("original_title");
            this.overView = jsonObject.getString("overview");
            this.backdropPath =jsonObject.getString("backdrop_path");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    public static ArrayList<Movie> fromJSONArray (JSONArray array){
        ArrayList<Movie> results = new ArrayList<>();
        for (int i=0; i< array.length();i++){
            try {
              results.add(new Movie(array.getJSONObject(i)));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }

}
