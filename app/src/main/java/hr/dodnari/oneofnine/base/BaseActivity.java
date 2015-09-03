package hr.dodnari.oneofnine.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hr.dodnari.oneofnine.R;
import hr.dodnari.oneofnine.activities.HelpActivity;

/**
 * Created by marko on 9/2/15.
 */
public class BaseActivity extends AppCompatActivity {

    private static final String TAG = BaseActivity.class.getSimpleName();
    @Bind(R.id.toolbar)
    protected Toolbar toolbar;

    @Bind(R.id.tab_layout)
    protected TabLayout tabLayout;

    @Bind(R.id.activity_container)
    protected DrawerLayout drawerLayout;

    @Bind(R.id.navigationView)
    protected NavigationView navigationView;

    private ActionBar actionBar;
    private ActionBarDrawerToggle drawerToggle;
    private int activityTitle;
    private boolean useTabs;

    @Override
    public void setContentView(int layoutResID) {
        DrawerLayout fullView = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
        FrameLayout activityContainer = (FrameLayout) fullView.findViewById(R.id.activity_content);
        getLayoutInflater().inflate(layoutResID, activityContainer, true);
        super.setContentView(fullView);
        ButterKnife.bind(this);

        setupToolbar();
        setupNavigationDrawer();
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }


    private void setupNavigationDrawer() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.help:
                        startActivity(HelpActivity.class, R.id.help);
                }

                return false;
            }
        });
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(drawerToggle);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);

        if (activityTitle != 0) {
            setTitle(activityTitle);
        }

        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setShowHideAnimationEnabled(true);
        }

        if (useTabs) {
            tabLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return drawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (navigationView.isShown()) {
            drawerLayout.closeDrawers();
        } else {
            super.onBackPressed();
        }
    }

    protected void setActivityTitle(int activityTitle) {
        this.activityTitle = activityTitle;
    }

    protected void useTabs(boolean tabs) {
        useTabs = tabs;
    }

    public <T extends BaseActivity> void startActivity(Class<T> className, int title) {
        Intent intent = new Intent(this, className);
        intent.putExtra("title", title);
        startActivity(intent);
        closeNavDrawers();
    }

    private void closeNavDrawers() {
        // TODO close navigation drawer
        if (navigationView.isShown()) {
            drawerLayout.closeDrawers();
        }
    }

    @OnClick(R.id.nav_drawer_image)
    protected void onNaiveClick() {
        Toast.makeText(this, "Got you! This does nothing!", Toast.LENGTH_LONG).show();
    }
}
