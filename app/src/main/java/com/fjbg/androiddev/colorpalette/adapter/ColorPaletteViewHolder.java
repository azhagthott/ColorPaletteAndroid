package com.fjbg.androiddev.colorpalette.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fjbg.androiddev.colorpalette.R;

/**
 * Created by moe on 28-11-16.
 */

public class ColorPaletteViewHolder extends RecyclerView.ViewHolder{

    public TextView cvTextColorName;
    public TextView cvTextColorHex;
    public ImageView cvImageView;
    public CardView card;

    public ColorPaletteViewHolder(final View view) {
        super(view);

        card = (CardView) view;
        cvImageView =(ImageView) view.findViewById(R.id.cvImageView);
        cvTextColorName =(TextView) view.findViewById(R.id.cvTextColorName);
        cvTextColorHex =(TextView) view.findViewById(R.id.cvTextColorHex);
    }
}
