package hr.dodnari.oneofnine.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import hr.dodnari.oneofnine.R;

/**
 * Created by marko on 8/31/15.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<FragmentPagerViewHolder> {

    private Context context;

    public MyRecyclerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public FragmentPagerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_view_text_item, parent, false);
        return new FragmentPagerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FragmentPagerViewHolder holder, int position) {
        holder.textView.setText("" + position);
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}

class FragmentPagerViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.cardview_textview)
    TextView textView;

    public FragmentPagerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
