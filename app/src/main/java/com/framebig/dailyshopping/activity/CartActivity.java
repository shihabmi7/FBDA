package com.framebig.dailyshopping.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.framebig.dailyshopping.R;
import com.framebig.dailyshopping.adapter.OrderListAdapter;
import com.framebig.dailyshopping.utility.ApplicationData;
import com.framebig.dailyshopping.utility.DividerItemDecoration;

public class CartActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    OrderListAdapter orderListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_cart_details);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);


        orderListAdapter = new OrderListAdapter(ApplicationData.orderList);
        recyclerView.setAdapter(orderListAdapter);

        showOrderDtails();
    }

    void showOrderDtails() {

        for (int i = 0; i < ApplicationData.orderSize.length; i++) {

            if (ApplicationData.orderSize[i] > 0) {

                Log.e("", "" + ApplicationData.productArrayList.get(i).getProductName() + "    " + ApplicationData.orderSize[i]);

            }
        }
    }

}
