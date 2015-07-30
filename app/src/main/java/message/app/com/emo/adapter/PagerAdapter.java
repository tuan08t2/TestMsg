package message.app.com.emo.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;

import message.app.com.emo.R;

/**
 * Created by nguyenvantuan on 7/30/15.
 */
public class PagerAdapter extends FragmentPagerAdapter implements PagerSlidingTabStrip.CustomTabProvider{

    private ArrayList<Fragment> mTabs;
    private ArrayList<Integer> mIcons;
    private Context mContext;

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public PagerAdapter(Context context, FragmentManager fm, ArrayList<Fragment> tabs, ArrayList<Integer> icons) {
        super(fm);
        mContext = context;
        mTabs = new ArrayList<>();
        mTabs.addAll(tabs);
        mIcons = new ArrayList<>();
        mIcons.addAll(icons);
    }

    @Override
    public Fragment getItem(int position) {
        return mTabs.get(position);
    }

    @Override
    public int getCount() {
        return mTabs.size();
    }

    @Override
    public View getCustomTabView(ViewGroup parent, int position) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(inflater != null){
            View view = inflater.inflate(R.layout.item_tab, null);
            ImageView img = (ImageView) view.findViewById(R.id.img_item_tab);
            img.setImageResource(mIcons.get(position));
            return view;
        }
        return null;
    }

    @Override
    public void tabSelected(View tab) {

    }

    @Override
    public void tabUnselected(View tab) {

    }
}
