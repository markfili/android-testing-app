package hr.dodnari.oneofnine.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import hr.dodnari.oneofnine.R;
import hr.dodnari.oneofnine.fragments.TestFragment;

/**
 * Created by marko on 8/27/15.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    private final Context context;
    private String[] titles = {"NEWS", "MAPS", "TRIPS", "MESS"};

    public MyPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return TestFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 3:
                Drawable image = context.getResources().getDrawable(R.drawable.ic_notifications_none_white_24dp);
                image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
                SpannableString sb = new SpannableString(" ");
                ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
                sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                return sb;
        }
        return titles[position];
    }
}
