package com.md.mataka;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class adaptertransaction extends RecyclerView.Adapter<adaptertransaction.ViewHolder> {

    Context context;
    ArrayList<String> date = new ArrayList<>();
    ArrayList<String> remark = new ArrayList<>();
    ArrayList<String> amount = new ArrayList<>();

    public adaptertransaction(Context context,ArrayList<String> date,ArrayList<String> remark,ArrayList<String> amount) {
        this.context = context;
        this.date = date;
        this.remark = remark;
        this.amount = amount;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        holder.date.setText(date.get(position));
        holder.remark.setText(remark.get(position));
        holder.amount.setText(amount.get(position));

    }

    @Override
    public int getItemCount() {
        return date.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView date,amount,remark;

        public ViewHolder(View view) {
            super(view);

            date = view.findViewById(R.id.date);
            amount = view.findViewById(R.id.amount);
            remark = view.findViewById(R.id.remark);
        }
    }



}
