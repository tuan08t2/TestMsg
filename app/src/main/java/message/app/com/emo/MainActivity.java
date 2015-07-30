package message.app.com.emo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends ActionBarActivity {

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

    @AfterViews
    public void init() {

    }

    @Click(R.id.img_first)
    public void increaseVpHeight() {
        mVp.setVisibility(mVp.getVisibility() == View.GONE? View.VISIBLE : View.GONE);
    }

}
