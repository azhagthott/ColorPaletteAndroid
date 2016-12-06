package com.fjbg.androiddev.colorpalette.app;

/**
 * Created by francisco on 28-11-16.
 */

public class ColorPalette {

    private String colorName;
    private String colorHex;
    private String colorImage;

    public ColorPalette() {
    }

    public ColorPalette(String colorHex) {
        this.colorHex = colorHex;
    }

    public ColorPalette(String colorName, String colorHex) {
        this.colorName = colorName;
        this.colorHex = colorHex;
    }

    public ColorPalette(String colorName, String colorHex, String colorImage) {
        this.colorName = colorName;
        this.colorHex = colorHex;
        this.colorImage = colorImage;
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

    public String getColorImage() {
        return colorImage;
    }

    public void setColorImage(String colorImage) {
        this.colorImage = colorImage;
    }
}
