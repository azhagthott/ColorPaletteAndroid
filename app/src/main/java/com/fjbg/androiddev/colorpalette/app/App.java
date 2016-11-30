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
import java.util.HashMap;
import java.util.List;

import static com.fjbg.androiddev.colorpalette.base.BaseActivity.LOG_TAG;

public class App extends Application {

    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    public void onCreate() {
        super.onCreate();

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        getListColor500();
    }

    public static List<ColorPalette> getListColor500() {

        final List<ColorPalette> list = new ArrayList<>();
        final List<String> listColorName = new ArrayList<>();
        final List<String> listColorHex = new ArrayList<>();

        try {

            FirebaseDatabase db = FirebaseDatabase.getInstance();
            DatabaseReference refColorHex = db.getReference("material_color").child("2").child("color_500");
            DatabaseReference refColorName = db.getReference("material_color").child("3").child("color_name");

            refColorName.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataColorName) {
                    for (DataSnapshot colorName : dataColorName.getChildren()) {
                        listColorName.add(colorName.getValue().toString());
                        Log.d(LOG_TAG, "colorName: " + colorName.getValue());
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    FirebaseCrash.log("ERROR:::" + databaseError);
                    Log.d(LOG_TAG, "ERROR::: " + databaseError);
                }
            });

            refColorHex.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot dataColorHex) {
                    for (DataSnapshot colorHex : dataColorHex.getChildren()) {
                        listColorHex.add(colorHex.getValue().toString());
                        Log.d(LOG_TAG, "colorHex: " + colorHex.getValue());
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    FirebaseCrash.log("ERROR:::" + databaseError);
                    Log.d(LOG_TAG, "ERROR::: " + databaseError);
                }
            });

        } catch (Exception e) {
            FirebaseCrash.log("ERROR:::" + e);
            Log.d(LOG_TAG, "ERROR::: " + e);
        }


        return list;
    }
}
