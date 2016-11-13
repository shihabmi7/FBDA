package com.framebig.dailyshopping.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.framebig.dailyshopping.R;
import com.framebig.dailyshopping.model.Order;
import com.framebig.dailyshopping.utility.ApplicationData;

import java.util.List;

/**
 * Created by Shihab on 1/28/2016.
 */
public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.MyViewHolder> {
    private List<Order> orderList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView_product_name, textView_product_spec, textView_total_unit_price, textView_unit_price, textView_quantity;
        ImageView cardimage;

        public MyViewHolder(View view) {
            super(view);
            textView_product_name = (TextView) view.findViewById(R.id.textView_product_name);
            textView_product_spec = (TextView) view.findViewById(R.id.textView_product_spec);
            textView_total_unit_price = (TextView) view.findViewById(R.id.textView_total_unit_price);
            textView_unit_price = (TextView) view.findViewById(R.id.textView_unit_price);
            textView_quantity = (TextView) view.findViewById(R.id.textView_quantity);
        }
    }


    public OrderListAdapter(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product_details, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //Order movie = orderList.get(position);

        //Log.e("", "" + ApplicationData.productArrayList.get(i).getProductName() + "    " + ApplicationData.orderSize[i]);
        //holder.textView_product_name.setText(movie.getProduct_id());
        if (ApplicationData.orderSize[position] > 0) {

            // Log.e("", "" + ApplicationData.productArrayList.get(position).getProductName() + "    " + ApplicationData.orderSize[position]);
            holder.textView_product_name.setText(ApplicationData.productArrayList.get(position).getProductName());
            holder.textView_quantity.setText(ApplicationData.orderSize[position]);

        }

        /* holder.textView_product_spec.setText(movie.get);*/
        /*holder.year.setText(movie.getYear());*/

    }

    @Override
    public int getItemCount() {

        return ApplicationData.orderSize.length;

        // return orderList.size();
    }
}
