package com.squaddigital.navigationdrawergridlayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.squaddigital.navigationdrawergridlayout.adapters.DrawerAdapter;
import com.squaddigital.navigationdrawergridlayout.models.DrawerItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private DrawerLayout mDrawerLayout;
    private ArrayList<DrawerItem> mDrawerItemList;
    private RecyclerView mRecyclerView;

    public int ItemPosition=1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);



        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        addDummyData();
        //Get The recuyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.drawerRecyclerView);
        final DrawerAdapter adapter = new DrawerAdapter(mDrawerItemList);
        final GridLayoutManager manager = new GridLayoutManager(this, 2);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (position == 0) || position==5 || position==8 ? 2 : 1; }
        });

        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickLister(new DrawerAdapter.OnItemSelecteListener() {
            @Override
            public void onItemSelected(View v, int position) {

                if (position==0){
                    Log.e(TAG,"Atis alet atieno");
                }else{
                    int pos=position-1;
                    if (ItemPosition==pos){
                        Log.e(TAG,"Atis alet atieno");
                    }else
                    {
                        resetPreviuosClicked(ItemPosition);
                        showItemClicked(pos);
                        adapter.notifyDataSetChanged();

                    }
               }
                //TODO change if the position has changed
                Toast.makeText(MainActivity.this, "You clicked at position: "+ position, Toast.LENGTH_SHORT).show();
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
            }
        });


    }

    private void resetPreviuosClicked(int ItemPositionPrevious) {
        mDrawerItemList.get(ItemPositionPrevious).setLayoutBgColor(Color.WHITE);


    }

    private void showItemClicked(int i) {

        mDrawerItemList.get(i).setTitle("Home");
//        mDrawerItemList.get(i).setIcon(R.drawable.ic_menu_share);
//        mDrawerItemList.get(i).setLayoutBgColor(R.color.colorClickedItem);
        ItemPosition=i;

    }

    private void addDummyData() {
        //Dummy Data
        mDrawerItemList = new ArrayList<DrawerItem>();
        DrawerItem item = new DrawerItem();
        item.setIcon(R.drawable.ic_menu_camera);
        item.setTitle("Inbox");
        mDrawerItemList.add(item);

        DrawerItem item2 = new DrawerItem();
        item2.setIcon(R.drawable.ic_menu_camera);
        item2.setTitle("Send");
        mDrawerItemList.add(item2);

        DrawerItem item3 = new DrawerItem();
        item3.setIcon(R.drawable.ic_menu_manage);
        item3.setTitle("One");
        mDrawerItemList.add(item3);

        DrawerItem item4 = new DrawerItem();
        item4.setIcon(R.drawable.ic_menu_share);
        item4.setTitle("three");
        mDrawerItemList.add(item4);

        DrawerItem item5 = new DrawerItem();
        item5.setIcon(R.drawable.ic_menu_slideshow);
        item5.setTitle("Inbox");
        mDrawerItemList.add(item5);

        DrawerItem item6 = new DrawerItem();
        item6.setIcon(R.drawable.ic_menu_camera);
        item6.setTitle("Send");
        mDrawerItemList.add(item6);

        DrawerItem item7 = new DrawerItem();
        item7.setIcon(R.drawable.ic_menu_manage);
        item7.setTitle("three");
        mDrawerItemList.add(item7);

        DrawerItem item8 = new DrawerItem();
        item8.setIcon(R.drawable.ic_menu_manage);
        item8.setTitle("three");
        mDrawerItemList.add(item8);

        DrawerItem item9 = new DrawerItem();
        item9.setIcon(R.drawable.ic_menu_manage);
        item9.setTitle("three");
        mDrawerItemList.add(item9);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
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
    }

    @SuppressWarnings("StatementWithEmptyBody")
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
    }
}
