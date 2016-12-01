package com.fjbg.androiddev.colorpalette.app;

/**
 * Created by francisco on 28-11-16.
 */

import android.app.Application;

import com.google.firebase.analytics.FirebaseAnalytics;

public class App extends Application {

    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    public void onCreate() {
        super.onCreate();
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
    }
}
