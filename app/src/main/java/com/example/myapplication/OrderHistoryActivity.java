package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.util.OrderHistory;
import com.example.myapplication.util.OrderHistoryAdapter;

import java.util.ArrayList;

public class OrderHistoryActivity extends AppCompatActivity {

    private RecyclerView rvOrderHistory;
    private RecyclerView orderHistoryRecyclerView;

    private OrderHistoryAdapter orderHistoryAdapter;
    private ArrayList<OrderModel> orderHistoryList;

    private void initViews() {
//        rvOrderHistory = findViewById(R.id.rv_order_history);
        orderHistoryRecyclerView = findViewById(R.id.order_history_recyclerview);

        orderHistoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);

        initViews();
        initOrderHistoryList();

    }

    private void initOrderHistoryList() {
//        orderHistoryAdapter = new OrderHistoryAdapter(this,OrderActivity.orderHistoryList);
//        OrderHistory orderHistory = new OrderHistory(this);
//        ArrayList<OrderModel> orderHistoryList = orderHistory.getOrderHistory();

//        orderHistoryAdapter = new OrderHistoryAdapter(this, orderHistoryList);
//        rvOrderHistory.setAdapter(orderHistoryAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        orderHistoryRecyclerView.setLayoutManager(layoutManager);
        orderHistoryAdapter = new OrderHistoryAdapter(this,OrderActivity.orderHistoryList);
        orderHistoryRecyclerView.setAdapter(orderHistoryAdapter);
    }
}

