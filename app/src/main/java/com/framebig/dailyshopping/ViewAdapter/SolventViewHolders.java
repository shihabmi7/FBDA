package com.framebig.dailyshopping.ViewAdapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.framebig.dailyshopping.R;
import com.framebig.dailyshopping.activity.SampleActivity;
import com.framebig.dailyshopping.utility.FDAColorManager;

public class SolventViewHolders extends RecyclerView.ViewHolder //implements View.OnClickListener
{

    public TextView textView_productName, textView_add_to_cart, textView_quantity, textView_product_price, textView_product_weight;
    public ImageView imageview_productPhoto;
    public Button btn_increment, btn_decrease;
    public RelativeLayout relative_product, relative_cart;
    int quatity = 0;
    double totalAmount = 0;
    String TAG_CURRENCY = "Tk ";

    public SolventViewHolders(View itemView) {
        super(itemView);

        // itemView.setOnClickListener(this);

        textView_productName = (TextView) itemView.findViewById(R.id.product_name);
        textView_product_price = (TextView) itemView.findViewById(R.id.product_price);
        textView_product_weight = (TextView) itemView.findViewById(R.id.product_weight);
        imageview_productPhoto = (ImageView) itemView.findViewById(R.id.product_picture);
        btn_increment = (Button) itemView.findViewById(R.id.btn_increment);
        btn_decrease = (Button) itemView.findViewById(R.id.btn_decrease);
        relative_product = (RelativeLayout) itemView.findViewById(R.id.relative_product);
        relative_cart = (RelativeLayout) itemView.findViewById(R.id.relative_cart);
        textView_add_to_cart = (TextView) itemView.findViewById(R.id.textView_add_to_cart);
        textView_quantity = (TextView) itemView.findViewById(R.id.textView_quantity);


//        relative_product.setOnClickListener(this);
//        relative_cart.setOnClickListener(this);
//        btn_decrease.setOnClickListener(this);
//        btn_increment.setOnClickListener(this);

        FDAColorManager.setTextViewColorWhite(textView_quantity);


    }

    void addProduct(Double price) {

        ++quatity;
        textView_quantity.setText("" + quatity);

        //TODO UPDATE PRICE WITH QUANTIITY
        textView_product_price.setText("" + quatity * price);

    }

    void leaveProduct(Double price) {

        --quatity;
        if (quatity <= 0) {

            invisibleCartButton();

        } else {
            textView_quantity.setText("" + quatity);
            //TODO UPDATE PRICE WITH QUANTIITY
            textView_product_price.setText("" + quatity * price);

        }

    }


    void visibleCartButton(Double price) {

        addProduct(price);

        textView_add_to_cart.setVisibility(View.INVISIBLE);
        FDAColorManager.setGridViewColorSelected(relative_cart);

        textView_quantity.setVisibility(View.VISIBLE);
        btn_increment.setVisibility(View.VISIBLE);
        btn_decrease.setVisibility(View.VISIBLE);
    }

    void invisibleCartButton() {

        quatity = 0;
        textView_add_to_cart.setVisibility(View.VISIBLE);
        FDAColorManager.setGridViewColorDefault(relative_cart);

        textView_quantity.setVisibility(View.INVISIBLE);
        btn_increment.setVisibility(View.INVISIBLE);
        btn_decrease.setVisibility(View.INVISIBLE);

    }


   /* @Override
    public void onClick(View view) {
        //Toast.makeText(view.getContext(), "Clicked Position ", Toast.LENGTH_SHORT).show();

        if (view == relative_cart) {

            visibleCartButton();

        } else if (view == btn_increment) {

            addProduct();


        } else if (view == btn_decrease) {

            leaveProduct();


        } else if (view == relative_product) {

            openProductDetails(view);

        }
    }*/

    public void openProductDetails(View view) {
        view.getContext().startActivity(new Intent(view.getContext(), SampleActivity.class));
        Toast.makeText(view.getContext(), "Product Details Clicked   ", Toast.LENGTH_SHORT).show();
    }
}
