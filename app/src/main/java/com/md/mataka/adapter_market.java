package com.md.mataka;


import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

class adapter_market extends RecyclerView.Adapter<adapter_market.ViewHolder> {

    Context context;
    String game;
    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> is_open = new ArrayList<>();
    private ArrayList<String> time = new ArrayList<>();
    private ArrayList<String> close_time = new ArrayList<>();

    private ArrayList<String> numbers = new ArrayList<>();

    public adapter_market(Context context, String game, ArrayList<String> name, ArrayList<String> is_open, ArrayList<String> open_time, ArrayList<String> close_time, ArrayList<String> numbers) {
        this.context = context;
        this.game = game;
        this.name = name;
        this.is_open = is_open;
        this.time = open_time;
        this.close_time = close_time;
        this.numbers = numbers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.market_layout, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {


        holder.name.setText(name.get(position));
        holder.time.setText(time.get(position));
        holder.close_time.setText(close_time.get(position));
        if (is_open.get(position).equals("1")) {
//            holder.layout.setBackgroundColor(context.getResources().getColor(R.color.md_green_800));

            holder.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    switch (game) {
//                        case "halfsangam":
//                            context.startActivity(new Intent(context, halfsangam.class).putExtra("market", name.get(position).replace(" ", "_")).putExtra("list", numbers).putExtra("game", game).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
//                            break;
//                        case "fullsangam":
//                            context.startActivity(new Intent(context, fullsangam.class).putExtra("market", name.get(position).replace(" ", "_")).putExtra("list", numbers).putExtra("game", game).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
//                            break;
//                        case "crossing":
//                            context.startActivity(new Intent(context, crossing.class).putExtra("market", name.get(position).replace(" ", "_")).putExtra("list", numbers).putExtra("game", game).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
//                            break;
//                        default:
//                            context.startActivity(new Intent(context, betting.class).putExtra("market", name.get(position).replace(" ", "_")).putExtra("list", numbers).putExtra("game", game).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
//                            break;
//                    }

                    Log.e("All Games ---- ", game);
                    context.startActivity(new Intent(context, days_game.class).putExtra("game", game).putExtra("market", name.get(position).replace(" ", "_")).putExtra("list", numbers).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                }
            });

        } else {
            holder.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Market is closed for betting", Toast.LENGTH_SHORT).show();
                }
            });

//            holder.layout.setBackgroundColor(context.getResources().getColor(R.color.md_red_600));
        }


        holder.setIsRecyclable(false);

        holder.chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(holder.itemView.getContext(), chart_menu.class));
            }
        });

    }


    @Override
    public int getItemCount() {
        return time.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, time, close_time;
        LinearLayout layout;
        ImageView chart;

        public ViewHolder(View view) {
            super(view);
            layout = view.findViewById(R.id.layout);
            name = view.findViewById(R.id.name);
            time = view.findViewById(R.id.time);
            close_time = view.findViewById(R.id.close_time);
            chart = view.findViewById(R.id.chart);

        }

    }


}
