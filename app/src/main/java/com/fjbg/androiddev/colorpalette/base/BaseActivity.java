package com.fjbg.androiddev.colorpalette.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.fjbg.androiddev.colorpalette.app.ColorPalette;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by francisco on 28-11-16.
 */

public class BaseActivity extends AppCompatActivity {

    public FirebaseAnalytics mFirebaseAnalytics;
    public static final String LOG_TAG = "LOG::: ";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
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
