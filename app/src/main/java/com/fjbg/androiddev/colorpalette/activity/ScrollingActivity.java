package com.fjbg.androiddev.colorpalette.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.fjbg.androiddev.colorpalette.R;
import com.fjbg.androiddev.colorpalette.app.ColorPalette;
import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.fjbg.androiddev.colorpalette.base.BaseActivity.LOG_TAG;

public class ScrollingActivity extends AppCompatActivity {

    public DatabaseReference colorGroup;
    public DatabaseReference colorName;
    private ImageView cvImageView;
    private ColorPalette colorPalette;
    private ScrollView scrollView;
    private LinearLayout llListColors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.gray_100));
        toolbar.setTitleTextColor(getResources().getColor(R.color.text_color_toolbar));

        llListColors = (LinearLayout) findViewById(R.id.llListColors);
        scrollView = (ScrollView) findViewById(R.id.scrollView);


        final String color = getIntent().getStringExtra("GROUP_COLOR_NAME");

        colorGroup = FirebaseDatabase.getInstance().getReference("material_color").child("4").child("color_hex");
        colorGroup.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                getColorList(dataSnapshot, color);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                FirebaseCrash.log("ERROR:::" + databaseError);
            }
        });

        colorName = FirebaseDatabase.getInstance().getReference("material_color").child("3").child("color_name");

        colorName.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                getColorName(dataSnapshot, color);
                toolbar.setTitle(getColorName(dataSnapshot, color));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        setSupportActionBar(toolbar);
    }

    public void getColorList(DataSnapshot dataSnapshot, String color) {

        float TEXT_VIEW_PADDING_LEFT = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, getResources().getDisplayMetrics());
        float TEXT_VIEW_PADDING_RIGHT = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, getResources().getDisplayMetrics());
        float TEXT_VIEW_PADDING_BOTTOM = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, getResources().getDisplayMetrics());
        float TEXT_VIEW_PADDING_TOP = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, getResources().getDisplayMetrics());
        float TEXT_VIEW_HEIGHT = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 54, getResources().getDisplayMetrics());

        try {

            for (int i = 0; i < dataSnapshot.getChildrenCount(); i++) {

                String colorGroup = dataSnapshot.child("" + i + "").child("group").getValue().toString();

                if (colorGroup.equals(color)) {

                    Log.d(LOG_TAG, "color: " + color);

                    for (int j = 0; j < dataSnapshot.child("" + i + "").child("items").getChildrenCount(); j++) {

                        String name = dataSnapshot.child("" + i + "").child("items").child("" + j + "").child("name-visible").getValue().toString();
                        String hex = dataSnapshot.child("" + i + "").child("items").child("" + j + "").child("hex").getValue().toString();

                        colorPalette = new ColorPalette();

                        colorPalette.setColorName(name);
                        colorPalette.setColorHex(hex);

                        TextView textViewHex = new TextView(this);
                        textViewHex.setMinHeight((int) TEXT_VIEW_HEIGHT);
                        textViewHex.setText(hex);
                        textViewHex.setBackgroundColor(Color.parseColor(hex));

                        textViewHex.setPadding(
                                (int) TEXT_VIEW_PADDING_LEFT,
                                (int) TEXT_VIEW_PADDING_TOP,
                                (int) TEXT_VIEW_PADDING_RIGHT,
                                (int) TEXT_VIEW_PADDING_BOTTOM);

                        Log.d(LOG_TAG, "hex: " + hex);

                        llListColors.addView(textViewHex);

                    }

                }
            }
        } catch (Exception e) {
            FirebaseCrash.log("ERROR::: " + e);
        }
    }

    private String getColorName(DataSnapshot dataSnapshot, String codeName) {

        String name = "";

        try {
            for (DataSnapshot color : dataSnapshot.getChildren()) {

                if (color.getKey().equals(codeName)) {
                    name = color.getValue().toString();
                }
            }
        } catch (Exception e) {
            FirebaseCrash.log("ERROR::" + e);
        }

        return name;
    }
}
