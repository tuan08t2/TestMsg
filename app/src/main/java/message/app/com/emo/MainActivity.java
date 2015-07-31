package message.app.com.emo;

import android.content.ClipDescription;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.astuetz.PagerSlidingTabStrip;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

import message.app.com.emo.adapter.PagerAdapter;
import message.app.com.emo.fragments.EmojiconFragment_;

@EActivity(R.layout.activity_main)
public class MainActivity extends ActionBarActivity implements View.OnDragListener{

    @ViewById(R.id.tabs)
    protected PagerSlidingTabStrip mTab;

    @ViewById(R.id.vp)
    protected ViewPager mVp;

    @ViewById(R.id.img_first)
    protected ImageView mImgFirst;

    @ViewById(R.id.img_second)
    protected ImageView mImgSecond;

    @ViewById(R.id.img_result)
    protected ImageView mImgResult;

    @ViewById(R.id.ll_chat_content)
    protected LinearLayout mLlChatContent;

    private PagerAdapter mAdapter;
    private String TAG = "xxx";

    @AfterViews
    public void init() {
        initDrag();
        initPager();
        initTab();
    }

    public void initDrag() {
        mImgFirst.setOnDragListener(this);
        mImgSecond.setOnDragListener(this);
        mVp.setOnDragListener(this);
    }

    public void initPager() {
        ArrayList<Fragment> tabs = new ArrayList<>();
        tabs.add(EmojiconFragment_.builder().build());
        ArrayList<Integer> icons = new ArrayList<>();
        icons.add(R.drawable.tastey);
        mAdapter = new PagerAdapter(this, getSupportFragmentManager(), tabs, icons);
        mVp.setAdapter(mAdapter);
    }

    public void initTab() {
        mTab.setViewPager(mVp);
    }


    @Click(R.id.img_first)
    public void increaseVpHeight() {

    }

    @Override
    public boolean onDrag(View imageViewTarget, DragEvent dragEvent) {

        View draggedImageView = (View) dragEvent.getLocalState();

        // Handles each of the expected events
        switch (dragEvent.getAction()) {

            case DragEvent.ACTION_DRAG_STARTED:
                Log.i(TAG, "drag action started");

                // Determines if this View can accept the dragged data
                if (dragEvent.getClipDescription()
                        .hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                    Log.i(TAG, "Can accept this data");

                    // returns true to indicate that the View can accept the dragged data.
                    return true;

                } else {
                    Log.i(TAG, "Can not accept this data");

                }

                // Returns false. During the current drag and drop operation, this View will
                // not receive events again until ACTION_DRAG_ENDED is sent.
                return false;

            case DragEvent.ACTION_DRAG_ENTERED:
                Log.i(TAG, "drag action entered");
//                the drag point has entered the bounding box
                return true;

            case DragEvent.ACTION_DRAG_LOCATION:
                Log.i(TAG, "drag action location");
                /*triggered after ACTION_DRAG_ENTERED
                stops after ACTION_DRAG_EXITED*/
                return true;

            case DragEvent.ACTION_DRAG_EXITED:
                Log.i(TAG, "drag action exited");
//                the drag shadow has left the bounding box
                return true;

            case DragEvent.ACTION_DROP:
                  /* the listener receives this action type when
                  drag shadow released over the target view
                 the action only sent here if ACTION_DRAG_STARTED returned true
                 return true if successfully handled the drop else false*/
                Log.i("size", dragEvent.getClipData().getItemCount() + "");
                int resourceId = Integer.parseInt(dragEvent.getClipData().getItemAt(0).getText().toString());
                Log.i(TAG, "Tennis ball");
                ViewGroup draggedImageViewParentLayout
                        = (ViewGroup) draggedImageView.getParent();
                draggedImageViewParentLayout.removeView(draggedImageView);
                if(imageViewTarget instanceof  ImageView) {
                    ImageView imgTarget = (ImageView) imageViewTarget;
                    imgTarget.setImageResource(resourceId);
                    draggedImageView.setVisibility(View.VISIBLE);
                }
                return true;

            // An unknown action type was received.
            default:
                Log.i(TAG, "Unknown action type received by OnDragListener.");
                break;
        }
        return false;
    }
}
