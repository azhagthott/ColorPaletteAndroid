package com.fjbg.androiddev.colorpalette.app;

import android.graphics.Color;
import android.widget.ImageView;

/**
 * Created by francisco on 28-11-16.
 */

public class ColorPalette {

    private String colorName;
    private String colorHex;
    private int colorImage;

    public ColorPalette() {
    }

    public ColorPalette(String colorName, String colorHex) {
        this.colorName = colorName;
        this.colorHex = colorHex;
    }


    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getColorHex() {
        return colorHex;
    }

    public void setColorHex(String colorHex) {
        this.colorHex = colorHex;
    }

    public int getColorImage() {
        return colorImage;
    }

    public void setColorImage(int colorImage) {
        this.colorImage = colorImage;
    }
}
