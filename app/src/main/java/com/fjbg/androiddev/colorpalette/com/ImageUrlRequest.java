package com.fjbg.androiddev.colorpalette.com;

import android.util.Log;

import com.google.firebase.crash.FirebaseCrash;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.fjbg.androiddev.colorpalette.base.BaseActivity.LOG_TAG;

/**
 * Created by francisco on 24-08-16.
 */

public class ImageUrlRequest {

    public ImageUrlRequest() {
    }

    public List<String> getData(JSONObject jsonObject) {

        List<String> list = new ArrayList<>();

        try {

            JSONArray array = jsonObject.getJSONArray("items");


            for (int i = 0; i < array.length(); i++) {

                JSONObject element = array.getJSONObject(i);
                JSONObject image = element.getJSONObject("image");
                String thumbnailLink = image.getString("thumbnailLink");

                Log.d(LOG_TAG, "thumbnailLink::: " + thumbnailLink);




            }


        } catch (Exception e) {
            Log.d(LOG_TAG, "Exception: " + e);
            FirebaseCrash.log("Exception" + e);
        }

        return list;
    }
}

