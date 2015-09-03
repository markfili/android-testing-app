package hr.dodnari.oneofnine.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import hr.dodnari.oneofnine.R;
import hr.dodnari.oneofnine.base.BaseActivity;

public class HelpActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActivityTitle(R.string.help);
        setContentView(R.layout.activity_help);
    }
}
