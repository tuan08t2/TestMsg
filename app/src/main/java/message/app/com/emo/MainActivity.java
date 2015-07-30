package message.app.com.emo;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
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
public class MainActivity extends ActionBarActivity {

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

    @AfterViews
    public void init() {
        initPager();
        initTab();
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

}
