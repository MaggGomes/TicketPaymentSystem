package com.tickepaymentsystem.cmov.customerapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tickepaymentsystem.cmov.customerapp.R;
import com.tickepaymentsystem.cmov.customerapp.ShowActivity;
import com.tickepaymentsystem.cmov.customerapp.Singleton;
import com.tickepaymentsystem.cmov.customerapp.Utils.Constants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ShowViewHolder> {

    private Context context;

    public ShowAdapter(Context context){
        this.context = context;
    }

    class ShowViewHolder extends RecyclerView.ViewHolder {

        public final View view;

        TextView name;
        TextView date;
        TextView price;
        ImageView image;
        Button btnSeeDetails;

        ShowViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            name = view.findViewById(R.id.list_item_show_name);
            date = view.findViewById(R.id.list_item_show_date);
            price = view.findViewById(R.id.list_item_show_price);
            image = view.findViewById(R.id.list_item_show_image);
            btnSeeDetails = view.findViewById(R.id.list_item_show_see_details);
        }
    }

    @Override
    public ShowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_show, parent, false);
        return new ShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShowViewHolder holder, int position) {
        SimpleDateFormat month_date = new SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.UK);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:sss");

        try {
            Date date = sdf.parse(Singleton.shows.get(position).getDate());
            String formateDate= month_date.format(date);
            holder.date.setText(formateDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        holder.name.setText(Singleton.shows.get(position).getName());

        String showPrice = Singleton.shows.get(position).getPrice().toString()+" €";

        holder.price.setText(showPrice);
        holder.btnSeeDetails.setOnClickListener((View v) -> onBtnSeeDetails(position));

        Picasso.get()
                .load(Singleton.shows.get(position).getUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return Singleton.shows.size();
    }

    private void onBtnSeeDetails(int position) {
        Intent intent = new Intent(context, ShowActivity.class);
        intent.putExtra(Constants.SHOW_DETAILS, position);
        context.startActivity(intent);
    }
}
