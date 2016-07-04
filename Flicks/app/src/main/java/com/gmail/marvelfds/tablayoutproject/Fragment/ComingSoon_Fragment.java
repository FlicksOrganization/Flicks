package com.gmail.marvelfds.tablayoutproject.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.gmail.marvelfds.tablayoutproject.Adapters.MovieArrayAdapter;
import com.gmail.marvelfds.tablayoutproject.Models.Movie;
import com.gmail.marvelfds.tablayoutproject.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by gaetanejulmiste on 6/30/16.
 */
public class ComingSoon_Fragment extends Fragment {
    // /movie/upcoming  --page

    public static final String ARG_PAGE = "ARG_PAGE";
    ArrayList<Movie> movies;
    MovieArrayAdapter moviesAdapter;
    GridView lvItems;
    String API_KEY="a07e22bc18f5cb106bfe4cc1f83ad8ed";

    private int mPage;

    public static ComingSoon_Fragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        ComingSoon_Fragment fragment = new ComingSoon_Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.comingsoon_page, container, false);
        lvItems = (GridView)  view;
        lvItems.findViewById(R.id.lvMovies);
        movies=new ArrayList<>();
        moviesAdapter = new MovieArrayAdapter(getContext(),movies);
        lvItems.setAdapter(moviesAdapter);



        String url = "https://api.themoviedb.org/3/movie/upcoming?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                JSONArray movieJSONResults = null;
                try {
                    movieJSONResults = response.getJSONArray("results");
                    movies.addAll(Movie.fromJSONArray(movieJSONResults)) ;
                    moviesAdapter.notifyDataSetChanged();
                    Log.d("DEBUG",movieJSONResults.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }
        });
        return view;
    }
}
