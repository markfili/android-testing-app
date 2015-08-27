package hr.dodnari.oneofnine;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;
import hr.dodnari.oneofnine.adapters.MyPagerAdapter;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.main_toolbar)
    protected Toolbar toolbar;
//    @Bind(R.id.scroll_view)
//    protected NestedScrollView scrollView;
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @Bind(R.id.view_pager)
    ViewPager viewPager;

    private ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupToolbar();
        setupViewPager();
        setupTabView();
        setupSnackbar();
    }

    private void setupViewPager() {
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), getApplicationContext()));
    }

    private void setupSnackbar() {
        Snackbar.make(toolbar, "allahu snackbar!", Snackbar.LENGTH_LONG).show();
    }

    private void setupTabView() {
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setShowHideAnimationEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:

        }

        return super.onOptionsItemSelected(item);
    }
}
