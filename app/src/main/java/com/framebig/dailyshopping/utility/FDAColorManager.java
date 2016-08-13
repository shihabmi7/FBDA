package com.framebig.dailyshopping.utility;

import android.view.View;
import android.widget.TextView;

import com.framebig.dailyshopping.R;

/**
 * Created by Shihab on 7/26/2016.
 */
public class FDAColorManager {

    public static void setGridViewColorSelected(View view) {

        view.setBackgroundColor(view.getContext().getResources().getColor(
                R.color.colorPrimary));

    }

    public static void setGridViewColorDefault(View view) {

        view.setBackgroundColor(view.getContext().getResources().getColor(
                R.color.white));

    }

    public static void setTextViewColorWhite(TextView view) {

        view.setTextColor(view.getContext().getResources().getColor(
                R.color.white));

    }

}
