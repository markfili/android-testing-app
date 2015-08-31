package hr.dodnari.oneofnine.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import hr.dodnari.oneofnine.R;

/**
 * Created by marko on 8/27/15.
 */
public class TestFragment extends Fragment {

    public static final String POSITION = "position";

    @Bind(R.id.textview)
    TextView textView;

    CardView cardView;

    private int[] colors;
    private int position;

    public TestFragment() {
    }

    public static TestFragment newInstance(int position) {
        TestFragment tf = new TestFragment();
        Bundle args = new Bundle();
        args.putInt(POSITION, position);
        tf.setArguments(args);
        return tf;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments() != null ? getArguments().getInt(POSITION) : 1;
        colors = getResources().getIntArray(R.array.colors);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pager_item, container, false);
        ButterKnife.bind(this, v);
        v.setBackgroundColor(colors[position]);

        cardView = (CardView) v.findViewById(R.id.card_view);
        textView.setText("" + position);

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
