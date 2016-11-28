package com.fjbg.androiddev.colorpalette.app;

import android.graphics.Color;

/**
 * Created by francisco on 28-11-16.
 */

public class ColorPalette{

    private String colorName;
    private String colorHex;

    public ColorPalette() {
    }

    public ColorPalette(String colorName, String colorHex) {
        this.colorName = colorName;
        this.colorHex = colorHex;
    }
}
