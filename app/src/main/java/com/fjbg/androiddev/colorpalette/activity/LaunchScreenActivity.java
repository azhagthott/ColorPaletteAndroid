package com.fjbg.androiddev.colorpalette.activity;

import android.content.Intent;
import android.os.Bundle;

import com.fjbg.androiddev.colorpalette.base.BaseActivity;

/**
 * Created by francisco on 28-11-16.
 */

public class LaunchScreenActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
