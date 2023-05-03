package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.example.myapplication.R;
import com.example.myapplication.DeliveryAdapter;
import com.example.myapplication.Order;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

public class DeliveryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SmartRefreshLayout smartRefreshLayout;
    private DeliveryAdapter deliveryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        recyclerView = findViewById(R.id.recyclerView);
        smartRefreshLayout = findViewById(R.id.smartRefreshLayout);

        deliveryAdapter = new DeliveryAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(deliveryAdapter);

        // Populate the adapter with sample data
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("#202301", "Pepperoni pizza ", "1075 CommonWealth Ave", "455 CommonWealth Ave"));
        orders.add(new Order("#202302", "Cheese Burger ", "1075 CommonWealth Ave", "455 CommonWealth Ave"));

        orders.add(new Order("#202304", "Vegetable Pizza ", "1075 CommonWealth Ave", "455 CommonWealth Ave"));
        orders.add(new Order("#202305", "Hot Brewed Coffee ", "1075 CommonWealth Ave", "455 CommonWealth Ave"));
        orders.add(new Order("#202306", "The Poke ", "809 CommonWealth Ave", "1010 CommonWealth Ave"));
        orders.add(new Order("#202307", "Mobile Power ", "809 CommonWealth Ave", "1010 CommonWealth Ave"));


        deliveryAdapter.setNewInstance(orders); //将新的数据列表设置为适配器的数据源

        // Set up refresh listener
        smartRefreshLayout.setOnRefreshListener(refreshLayout -> {
            // Perform actions when the layout is refreshed, 下拉刷新
            refreshLayout.finishRefresh(2000); // Set the refresh duration to 2 seconds
        });
    }
}
