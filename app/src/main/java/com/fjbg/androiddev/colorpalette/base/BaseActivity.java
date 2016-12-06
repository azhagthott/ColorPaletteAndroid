package com.fjbg.androiddev.colorpalette.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.fjbg.androiddev.colorpalette.adapter.ColorPaletteViewAdapter;
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

    public static final String LOG_TAG = "LOG::: ";
    public static final String API_KEY = "AIzaSyDXj1uf80Ci4SNX3yabtVwIM9oLILXxcuA";
    public FirebaseAnalytics mFirebaseAnalytics;
    public ColorPalette colors;
    public String URL_SEARCH = "https://www.googleapis.com/customsearch/v1?q=color%2Bred%2Bpattern&cx=partner-pub-0746199382324097%3Arm1wfqvos9m&hl=EN&imgColorType=color&imgDominantColor=pink&imgType=lineart&num=10&safe=high&searchType=image&key=";
    public String URL_SEARCH_RED_WALLPAPER_HD = "https://www.googleapis.com/customsearch/v1?q=red%20wallpaper%20hd&cx=partner-pub-0746199382324097%3Arm1wfqvos9m&hl=EN&imgColorType=color&imgDominantColor=pink&imgType=lineart&num=3&safe=high&searchType=image&key=";
    public DatabaseReference colorGroup;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
    }

    public void getColorData(DataSnapshot dataSnapshot, RecyclerView recyclerView) {

        List<ColorPalette> colors = new ArrayList<>();
        for (DataSnapshot color : dataSnapshot.getChildren()) {

            colors.add(new ColorPalette(
                    color.child("name").getValue().toString(),
                    color.child("hex").getValue().toString(),
                    color.child("url_image").getValue().toString())
            );
        }
        recyclerView.setAdapter(new ColorPaletteViewAdapter(colors));
    }


}
