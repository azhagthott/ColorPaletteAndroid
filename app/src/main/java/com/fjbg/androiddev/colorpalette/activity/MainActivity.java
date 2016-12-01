package com.fjbg.androiddev.colorpalette.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.fjbg.androiddev.colorpalette.R;
import com.fjbg.androiddev.colorpalette.adapter.ColorPaletteViewAdapter;
import com.fjbg.androiddev.colorpalette.app.ColorPalette;
import com.fjbg.androiddev.colorpalette.base.BaseActivity;
import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {

    private DatabaseReference refColor;
    private StorageReference refImage;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        refColor = FirebaseDatabase.getInstance().getReference("material_color").child("5").child("color_name_500");
        refColor.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                executeTask(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                FirebaseCrash.log("ERROR: " + databaseError);
            }
        });
    }

    private void executeTask(DataSnapshot dataSnapshot) {

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
