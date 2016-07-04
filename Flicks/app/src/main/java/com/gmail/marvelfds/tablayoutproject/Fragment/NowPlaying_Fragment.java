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
import com.gmail.marvelfds.tablayoutproject.FlicksClient;
import com.gmail.marvelfds.tablayoutproject.Models.Movie;
import com.gmail.marvelfds.tablayoutproject.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * A simple {@link Fragment} subclass.
 * MovieArrayAdapter that contain this fragment must implement the

 * to handle interaction events.
 * Use the {@link NowPlaying_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NowPlaying_Fragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    ArrayList<Movie> movies;
    MovieArrayAdapter moviesAdapter;
    GridView  lvItems;
    private FlicksClient client;



    private int mPage;

    public static NowPlaying_Fragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        NowPlaying_Fragment fragment = new NowPlaying_Fragment();
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
        View view = inflater.inflate(R.layout.nowplaying_page, container, false);
        lvItems = (GridView)  view;
        lvItems.findViewById(R.id.lvMovies);
        movies=new ArrayList<>();
        moviesAdapter = new MovieArrayAdapter(getContext(),movies);
        lvItems.setAdapter(moviesAdapter);

 //generate();

       String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
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

       // listView.setAdapter(mPage);
      // TextView textView = (TextView) view;
        //textView.setText("Fragment #" + mPage);
        return view;
    }


/*private void generate () {
    client= new FlicksClient();
    client.getNowPlaying( new JsonHttpResponseHandler() {
        @Override
        public void onSuccess(int statusCode, Header[] headers,JSONObject response) {

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
}*/

}
