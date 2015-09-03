package hr.dodnari.oneofnine.activities;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import butterknife.Bind;
import butterknife.ButterKnife;
import hr.dodnari.oneofnine.R;
import hr.dodnari.oneofnine.adapters.MyPagerAdapter;
import hr.dodnari.oneofnine.base.BaseActivity;

public class MainActivity extends BaseActivity {


    private static final String TAG = MainActivity.class.getSimpleName();
    // @Bind(R.id.scroll_view)
    // protected NestedScrollView scrollView;
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @Bind(R.id.view_pager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActivityTitle(R.string.title_activity_main);
        useTabs(true);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
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
}
