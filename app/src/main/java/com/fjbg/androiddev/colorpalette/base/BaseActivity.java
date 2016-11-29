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
    private ColorPalette colors;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
    }

    public void loadingDialog(String loadingText) {

    }

    public List<ColorPalette> getListColor500() {

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

        for (int i = 0; i < listColorHex.size(); i++) {
            colors=  new ColorPalette(listColorName.get(i), listColorHex.get(i));

            Log.d(LOG_TAG, "color name::: " + colors.getColorName());

            list.add(colors);
        }

        return list;
    }
}
