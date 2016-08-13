package com.framebig.dailyshopping.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;

import com.framebig.dailyshopping.R;
import com.framebig.dailyshopping.ViewAdapter.SolventRecyclerViewAdapter;
import com.framebig.dailyshopping.model.ItemObjects;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity
        // implements NavigationView.OnNavigationItemSelectedListener
{

    RecyclerView recycler_view;
    private StaggeredGridLayoutManager gaggeredGridLayoutManager;
    Activity activity = this;
    final int COLUMN_NO = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //super.onCreateDrawer();


        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        /*

        *//*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*//*

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);*/

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        gaggeredGridLayoutManager = new StaggeredGridLayoutManager(COLUMN_NO, 1);
        recyclerView.setLayoutManager(gaggeredGridLayoutManager);

        List<ItemObjects> gaggeredList = getListItemData();

        SolventRecyclerViewAdapter rcAdapter = new SolventRecyclerViewAdapter(activity, gaggeredList);
        recyclerView.setAdapter(rcAdapter);
    }

  /*  @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }*/



    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    /*@SuppressWarnings("StatementWithEmptyBody")
    @Override
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
    }*/

    private List<ItemObjects> getListItemData() {


        List<ItemObjects> listViewItems = new ArrayList<ItemObjects>();
        listViewItems.add(new ItemObjects("Alkane", R.drawable.one));
        listViewItems.add(new ItemObjects("Alkane", R.drawable.one));
        listViewItems.add(new ItemObjects("Alkane", R.drawable.one));


        return listViewItems;
    }
}
