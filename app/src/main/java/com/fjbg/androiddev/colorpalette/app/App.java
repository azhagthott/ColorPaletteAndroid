package com.fjbg.androiddev.colorpalette.app;

/**
 * Created by francisco on 28-11-16.
 */

import android.app.Application;
import android.os.SystemClock;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.concurrent.TimeUnit;


public class App extends Application {

    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    public void onCreate() {
        super.onCreate();


        // Don't do this! This is just so cold launches take some time
        //SystemClock.sleep(TimeUnit.SECONDS.toMillis(3));

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
    }
}
