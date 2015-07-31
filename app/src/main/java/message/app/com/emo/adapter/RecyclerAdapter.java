package message.app.com.emo.adapter;

import android.content.ClipData;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import message.app.com.emo.R;
import message.app.com.emo.model.Item;

/**
 * Created by nguyenvantuan on 7/30/15.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<Item> mItems;
    public RecyclerAdapter(ArrayList<Item> items) {
        if(mItems != null) {
            mItems.clear();
        } else {
            mItems = new ArrayList<>();
        }
        mItems.addAll(items);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_view, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Item item = mItems.get(i);
        viewHolder.img.setImageResource(item.getResourceId());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener{

        public ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img_item_recycler_view);
            itemView.setOnLongClickListener(this);
        }



        @Override
        public boolean onLongClick(View imageView) {
            Log.i("xxx", "12345");
            ClipData clipData = ClipData.newPlainText("", "" + mItems.get(getPosition()).getResourceId());
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(imageView);
            /*start the drag - contains the data to be dragged,
            metadata for this data and callback for drawing shadow*/
            imageView.startDrag(clipData, shadowBuilder, imageView, 0);
            return true;
        }
    }
}
