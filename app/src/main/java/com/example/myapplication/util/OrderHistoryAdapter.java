package com.example.myapplication.util;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.OrderDetailActivity;
import com.example.myapplication.OrderModel;
import com.example.myapplication.R;

import java.util.ArrayList;

public class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryAdapter.OrderHistoryViewHolder> {
    private ArrayList<OrderModel> orderHistory;
    private LayoutInflater inflater;
    private Context context;

    public OrderHistoryAdapter(Context context, ArrayList<OrderModel> orderHistory) {
        this.orderHistory = orderHistory;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public OrderHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_order_details, parent, false);
        return new OrderHistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHistoryViewHolder holder, int position) {
        final OrderModel currentOrder = orderHistory.get(position);
        holder.orderId.setText("Order ID: " + currentOrder.getOrderId());
        holder.orderDetails.setText( currentOrder.getOrderDetails());

        // Add click listener for each order to open a separate Order Detail Activity
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OrderDetailActivity.class);
                intent.putExtra("orderId", currentOrder.getOrderId());
                intent.putExtra("orderDetails", currentOrder.getOrderDetails());
//                orderHistory.add(currentOrder);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderHistory.size();
    }

    static class OrderHistoryViewHolder extends RecyclerView.ViewHolder {
        TextView orderId, orderDetails;

        public OrderHistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            orderId = itemView.findViewById(R.id.order_id);
            orderDetails = itemView.findViewById(R.id.order_details);
        }
    }
}