package com.tickepaymentsystem.cmov.customerapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.tickepaymentsystem.cmov.customerapp.R;
import com.tickepaymentsystem.cmov.customerapp.Singleton;
import com.tickepaymentsystem.cmov.customerapp.Utils.Constants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import es.dmoral.toasty.Toasty;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder> {

    private Context context;

    public TransactionAdapter(Context context){
        this.context = context;
    }

    class TransactionViewHolder extends RecyclerView.ViewHolder {

        public final View view;
        TextView name;
        TextView total;

        TransactionViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            name = view.findViewById(R.id.list_item_transaction_name);
            total = view.findViewById(R.id.list_item_transaction_total);
        }
    }

    @Override
    public TransactionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_transaction, parent, false);
        return new TransactionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TransactionViewHolder holder, int position) {
        String totalPrice = Singleton.ticketTransactions.get(position).getTotalPrice() + " €";
        holder.name.setText(Singleton.ticketTransactions.get(position).getShowName());
        holder.total.setText(totalPrice);
    }

    @Override
    public int getItemCount() {
        return Singleton.ticketTransactions.size();
    }
}
