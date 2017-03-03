package com.uk.umf_solutions.warehousehelper.common;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ToxicBakery.viewpager.transforms.CubeOutTransformer;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.uk.umf_solutions.warehousehelper.R;

public class MainActivity extends AppCompatActivity {

    private Drawer mResult = null;
    private ViewPager mViewPager;
    private Toolbar mToolbar;
    private TextView mTextView_tabs;
    private ViewPagerAdapter mPager;
    private String mTITLE = "its null";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.custom_toolbar);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTextView_tabs = (TextView) findViewById(R.id.text_tab_name_viewpager);
        setSupportActionBar(mToolbar);
        mPager = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPager);
        mViewPager.setPageTransformer(true, new CubeOutTransformer());
        GetTabTitle();
        GetFab();
        GetDrawItem();
    }

    private void GetTabTitle() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position,
                                       float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mTITLE = "Main";
                        mTextView_tabs.setText(mTITLE);
                        break;
                    case 1:
                        mTITLE = "WMS";
                        mTextView_tabs.setText(mTITLE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void GetDrawItem() {
        PrimaryDrawerItem item1 = new PrimaryDrawerItem()
                .withIdentifier(1)
                .withName(R.string.drawer_item_calc);
        PrimaryDrawerItem item2 = new PrimaryDrawerItem()
                .withIdentifier(2)
                .withName(R.string.drawer_item_barcode);
        PrimaryDrawerItem item3 = new PrimaryDrawerItem()
                .withIdentifier(3)
                .withName(R.string.draw_item_camera);
        PrimaryDrawerItem item4 = new PrimaryDrawerItem()
                .withIdentifier(4)
                .withName(R.string.draw_item_web);
        PrimaryDrawerItem item5 = new PrimaryDrawerItem()
                .withIdentifier(5)
                .withName(R.string.draw_item_email);
        PrimaryDrawerItem item6 = new PrimaryDrawerItem()
                .withIdentifier(6)
                .withName(R.string.draw_item_settings);
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.dmuk)
                .addProfiles(
                        new ProfileDrawerItem().withName("Eaun Ballinger")
                                .withEmail("eaun.ballinger@gmail.com")
                                .withIcon(getResources()
                                        .getDrawable(R.drawable.ic_favorites))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view,
                                                    IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();

        mResult = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .addDrawerItems(
                        item1,
                        item2, item3, item4, item5, item6,
                        new DividerDrawerItem()

                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                                                   @Override
                                                   public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                                                       // do something with the clicked item :D
                                                       String name = String.valueOf(position);
                                                       switch (position) {
                                                           case 1:
                                                               Toast.makeText(MainActivity.this, name,
                                                                       Toast.LENGTH_SHORT)
                                                                       .show();
                                                               break;
                                                           case 2:
                                                               Toast.makeText(MainActivity.this, name,
                                                                       Toast.LENGTH_SHORT)
                                                                       .show();
                                                               break;
                                                           case 3:
                                                               Toast.makeText(MainActivity.this, name,
                                                                       Toast.LENGTH_SHORT)
                                                                       .show();
                                                               break;
                                                           case 4:
                                                               Toast.makeText(MainActivity.this, name,
                                                                       Toast.LENGTH_SHORT)
                                                                       .show();
                                                               break;
                                                           case 5:
                                                               Toast.makeText(MainActivity.this, name,
                                                                       Toast.LENGTH_SHORT)
                                                                       .show();
                                                               break;

                                                           case 6:
                                                               Toast.makeText(MainActivity.this, name,
                                                                       Toast.LENGTH_SHORT)
                                                                       .show();
                                                               break;
                                                       }
                                                       return false;
                                                   }
                                               }
                )
                .build();
    }

    private void GetFab() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (mResult != null && mResult.isDrawerOpen()) {
            mResult.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }
}
