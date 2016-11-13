package com.framebig.dailyshopping.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.framebig.dailyshopping.R;
import com.framebig.dailyshopping.adapter.SolventRecyclerViewAdapter;
import com.framebig.dailyshopping.model.ItemObjects;
import com.framebig.dailyshopping.model.ProductType;
import com.framebig.dailyshopping.network.CustomListener;
import com.framebig.dailyshopping.network.GetProductListAPI;
import com.framebig.dailyshopping.utility.ApplicationData;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity
        // implements NavigationView.OnNavigationItemSelectedListener
{

    RecyclerView recycler_view;
    private StaggeredGridLayoutManager gaggeredGridLayoutManager;
    Activity activity = this;
    final int COLUMN_NO = 2;
    private RecyclerView recyclerView;
    private SolventRecyclerViewAdapter rcAdapter = null;
    DrawerLayout drawer;
    Toolbar toolbar;
    private ActionBarDrawerToggle toggle;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //super.onCreateDrawer();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        imageButton = (ImageButton) findViewById(R.id.imagebutton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e("imagebutton", "hello...");
                Toast.makeText(getApplicationContext(), "imagebutton clicked...", Toast.LENGTH_LONG).show();

                //showOrderDtails();

                Intent intent = new Intent(HomeActivity.this, CartActivity.class);
                startActivity(intent);


            }
        });


        /*

        */
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_left_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                drawer.closeDrawer(GravityCompat.END);

                return true;
            }
        });


        NavigationView rightNavigationView = (NavigationView) findViewById(R.id.nav_right_view);
        rightNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                // Handle Right navigation view item clicks here.
                int id = item.getItemId();


                drawer.closeDrawer(GravityCompat.END);
                /*Important Line*/
                return true;
            }

        });

        // convert your offset percent (here 15% ) into decimal by dividing 100
        float offset = .15f * getResources().getDisplayMetrics().widthPixels;
        float width = getResources().getDisplayMetrics().widthPixels - offset;
        DrawerLayout.LayoutParams params = (android.support.v4.widget.DrawerLayout.LayoutParams) rightNavigationView.getLayoutParams();
        params.width = (int) width;
        rightNavigationView.setLayoutParams(params);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        gaggeredGridLayoutManager = new StaggeredGridLayoutManager(COLUMN_NO, 1);
        recyclerView.setLayoutManager(gaggeredGridLayoutManager);
//        recyclerView.setAdapter(rcAdapter);

        // List<ItemObjects> gaggeredList = getListItemData();

        /*SolventRecyclerViewAdapter rcAdapter = new SolventRecyclerViewAdapter(activity, gaggeredList);
        recyclerView.setAdapter(rcAdapter);*/

        GetProductListAPI getProductListAPI = new GetProductListAPI(this, true, ProductType.Breakfast);
        getProductListAPI.setListener(new CustomListener() {
            @Override
            public void ModificationMade() {

                rcAdapter = new SolventRecyclerViewAdapter(activity, ApplicationData.productArrayList);
                ApplicationData.orderSIze(ApplicationData.productArrayList.size());

//                rcAdapter.notifyDataSetChanged();
                recyclerView.setAdapter(rcAdapter);
            }
        });
        getProductListAPI.execute();

    }

    void showOrderDtails() {

        for (int i = 0; i < ApplicationData.orderSize.length; i++) {

            if (ApplicationData.orderSize[i] > 0) {

                Log.e("", "" + ApplicationData.productArrayList.get(i).getProductName() + "    " + ApplicationData.orderSize[i]);

            }
        }
    }

    private void initUI() {


    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);


        } else if (drawer.isDrawerOpen(GravityCompat.END)) {
            /*Closes the Appropriate Drawer*/
            drawer.closeDrawer(GravityCompat.END);
        } else {

            // clear data
            ApplicationData.orderSize = new int[0];

            super.onBackPressed();
            System.exit(0);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify orderSize parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            drawer.openDrawer(GravityCompat.END); /*Opens the Right Drawer*/
            return true;
        } else if (toggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    /*@Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
*/


    private List<ItemObjects> getListItemData() {


        List<ItemObjects> listViewItems = new ArrayList<ItemObjects>();
        listViewItems.add(new ItemObjects("Alkane", R.drawable.one));
        listViewItems.add(new ItemObjects("Alkane", R.drawable.one));
        listViewItems.add(new ItemObjects("Alkane", R.drawable.one));


        return listViewItems;
    }
}
