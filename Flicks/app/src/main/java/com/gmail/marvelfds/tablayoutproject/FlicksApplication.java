package com.gmail.marvelfds.tablayoutproject;

import android.content.Context;

/**
 * Created by gaetanejulmiste on 6/30/16.
 */
public class FlicksApplication extends com.activeandroid.app.Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        FlicksApplication.context = this;
    }

    //public static FlicksClient getRestClient() {
    //    return (FlicksClient) FlicksClient.getInstance(FlicksClient.class, FlicksApplication.context);
   // }
}