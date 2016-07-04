package com.gmail.marvelfds.tablayoutproject;

import android.content.Context;

import com.codepath.oauth.OAuthBaseClient;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.scribe.builder.api.Api;

/**
 * Created by gaetanejulmiste on 6/30/16.
 */
public class FlicksClient {

    public static final String API_BASE_URL = "https://api.themoviedb.org/3/";
    public static final String API_KEY = "a07e22bc18f5cb106bfe4cc1f83ad8ed";
    private AsyncHttpClient client;

    public FlicksClient() {
        this.client=new AsyncHttpClient();
    }

    public String getApiUrl(String relativeUrl){
        return API_BASE_URL +"?api_key="+ API_KEY;
    }
    public void getNowPlaying(JsonHttpResponseHandler handler) {
        String apiUrl = getApiUrl("movie/now_playing.json");
        RequestParams params = new RequestParams();
      //  params.put("page", page);
        client.get(apiUrl,params,handler);

    }

    public void getTop10(int page,JsonHttpResponseHandler handler) {
        String apiUrl = getApiUrl("movie/top_rated.json");
        RequestParams params = new RequestParams();
        params.put("page", page);;
        client.get(apiUrl,params,handler);

    }


    public void getComingSoon(int page,JsonHttpResponseHandler handler) {
        String apiUrl = getApiUrl("movie/upcoming.json");
        RequestParams params = new RequestParams();
        params.put("page", page);;
        client.get(apiUrl,params,handler);

    }


}
