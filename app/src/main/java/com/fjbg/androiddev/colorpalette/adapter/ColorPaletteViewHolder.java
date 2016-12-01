package com.fjbg.androiddev.colorpalette.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fjbg.androiddev.colorpalette.R;

/**
 * Created by moe on 28-11-16.
 */

public class ColorPaletteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView cvTextColorName;
    public TextView cvTextColorHex;
    public ImageView cvImageView;
    public CardView card;
    public Context context;

    public ColorPaletteViewHolder(final View view) {
        super(view);

        card = (CardView) view;
        cvImageView = (ImageView) view.findViewById(R.id.cvImageView);
        cvTextColorName = (TextView) view.findViewById(R.id.cvTextColorName);
        cvTextColorHex = (TextView) view.findViewById(R.id.cvTextColorHex);
        card.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        context = view.getContext();

        switch (view.getId()) {
            case R.id.card:
                Toast.makeText(context, cvTextColorName.getText(), Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
