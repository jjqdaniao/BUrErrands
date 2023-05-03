package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderDetailActivity extends AppCompatActivity {

    TextView orderId, orderDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        orderId = findViewById(R.id.order_id);
        orderDetails = findViewById(R.id.order_details);

        Intent intent = getIntent();
        String orderIdText = intent.getStringExtra("orderId");
        String orderDetailsText = intent.getStringExtra("orderDetails");

        orderId.setText("Order ID: " + orderIdText);
        orderDetails.setText("Order Details: " + orderDetailsText);
    }
}
