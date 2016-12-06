package com.fjbg.androiddev.colorpalette.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fjbg.androiddev.colorpalette.R;
import com.fjbg.androiddev.colorpalette.activity.ScrollingActivity;
import com.fjbg.androiddev.colorpalette.app.ColorPalette;
import com.squareup.picasso.Picasso;

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
    public void onBindViewHolder(final ColorPaletteViewHolder holder, final int position) {

        ColorPalette colors = items.get(position);
        context = holder.cvImageView.getContext();

        Picasso.with(context).load(colors.getColorImage()).into(holder.cvImageView);

        holder.cvTextColorName.setText(colors.getColorName());
        holder.cvTextColorHex.setText(colors.getColorHex());
        holder.card.setCardBackgroundColor(Color.parseColor(colors.getColorHex()));

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, ScrollingActivity.class);
                View sharedView = holder.card;
                String transitionName = context.getString(R.string.detail_transition_main);
                ActivityOptionsCompat options = ActivityOptionsCompat
                        .makeSceneTransitionAnimation((Activity) context, sharedView, transitionName);

                switch (position) {

                    case 0:
                        intent.putExtra("GROUP_COLOR_NAME", "red");
                        break;
                    case 1:
                        intent.putExtra("GROUP_COLOR_NAME", "pink");
                        break;
                    case 2:
                        intent.putExtra("GROUP_COLOR_NAME", "purple");
                        break;
                    case 3:
                        intent.putExtra("GROUP_COLOR_NAME", "deep_purple");
                        break;
                    case 4:
                        intent.putExtra("GROUP_COLOR_NAME", "indigo");
                        break;
                    case 5:
                        intent.putExtra("GROUP_COLOR_NAME", "blue");
                        break;
                    case 6:
                        intent.putExtra("GROUP_COLOR_NAME", "light_blue");
                        break;
                    case 7:
                        intent.putExtra("GROUP_COLOR_NAME", "cyan");
                        break;
                    case 8:
                        intent.putExtra("GROUP_COLOR_NAME", "teal");
                        break;
                    case 9:
                        intent.putExtra("GROUP_COLOR_NAME", "green");
                        break;
                    case 10:
                        intent.putExtra("GROUP_COLOR_NAME", "light_green");
                        break;
                    case 11:
                        intent.putExtra("GROUP_COLOR_NAME", "lime");
                        break;
                    case 12:
                        intent.putExtra("GROUP_COLOR_NAME", "yellow");
                        break;
                    case 13:
                        intent.putExtra("GROUP_COLOR_NAME", "amber");
                        break;
                    case 14:
                        intent.putExtra("GROUP_COLOR_NAME", "orange");
                        break;
                    case 15:
                        intent.putExtra("GROUP_COLOR_NAME", "deep_orange");
                        break;
                    case 16:
                        intent.putExtra("GROUP_COLOR_NAME", "brown");
                        break;
                    case 17:
                        intent.putExtra("GROUP_COLOR_NAME", "gray");
                        break;
                    case 18:
                        intent.putExtra("GROUP_COLOR_NAME", "blue_gray");
                        break;
                }
                context.startActivity(intent, options.toBundle());
            }
        });


    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
