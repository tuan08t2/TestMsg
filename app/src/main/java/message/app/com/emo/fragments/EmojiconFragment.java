package message.app.com.emo.fragments;

import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

import message.app.com.emo.R;
import message.app.com.emo.adapter.RecyclerAdapter;
import message.app.com.emo.model.Item;

@EFragment(R.layout.fragment_emojicon)
public class EmojiconFragment extends Fragment {

    @ViewById(R.id.recycler_view)
    protected RecyclerView mRecyclerView;

    private RecyclerAdapter mAdapter;

    @AfterViews
    public void init() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(0, "", R.drawable.beaten));
        items.add(new Item(0, "", R.drawable.faill));
        items.add(new Item(0, "", R.drawable.bouaaaaah));
        items.add(new Item(0, "", R.drawable.brzzzzz));
        items.add(new Item(0, "", R.drawable.burnt));
        items.add(new Item(0, "", R.drawable.nose_bleed));
        items.add(new Item(0, "", R.drawable.hidden));
        items.add(new Item(0, "", R.drawable.high));
        items.add(new Item(0, "", R.drawable.want));
        mAdapter = new RecyclerAdapter(items);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
    }
}
