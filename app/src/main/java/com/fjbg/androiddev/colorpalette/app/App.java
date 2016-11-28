package com.fjbg.androiddev.colorpalette.app;

/**
 * Created by francisco on 28-11-16.
 */

import android.app.Application;
import android.util.Log;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.fjbg.androiddev.colorpalette.base.BaseActivity.LOG_TAG;

public class App extends Application {

    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    public void onCreate() {
        super.onCreate();

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        getListColor500();

        //SystemClock.sleep(TimeUnit.SECONDS.toMillis(3));
    }

    public List<ColorPalette> getListColor500() {

        List<ColorPalette> list = new ArrayList<>();

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference reference = db.getReference("material_color");

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d(LOG_TAG, "dataSnapshot: " + dataSnapshot.child("2").child("color_500").getValue());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                FirebaseCrash.log("ERROR:::" + databaseError);
                Log.d(LOG_TAG, "ERROR::: " + databaseError);
            }
        });

        return list;
    }
}
