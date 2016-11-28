package com.fjbg.androiddev.colorpalette.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fjbg.androiddev.colorpalette.R;
import com.fjbg.androiddev.colorpalette.app.ColorPalette;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by moe on 28-11-16.
 */

public class ColorPaletteViewAdapter extends RecyclerView.Adapter<ColorPaletteViewHolder> {

    private List<ColorPalette> items;
    private Context context;

    public ColorPaletteViewAdapter(List<ColorPalette> items) {
        this.items = new ArrayList<>();
        this.items.addAll(items);
    }

    @Override
    public ColorPaletteViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card, viewGroup, false);
        return new ColorPaletteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ColorPaletteViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
