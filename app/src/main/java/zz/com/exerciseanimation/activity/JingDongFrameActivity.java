package zz.com.exerciseanimation.activity;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import zz.com.exerciseanimation.R;

/**
 * Created by Administrator on 2016/10/27.帧动画
 */
public class JingDongFrameActivity extends Activity {

    private ImageView iv_jing_dong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jingdong);

        initView();
    }

    private void initView() {
        iv_jing_dong = (ImageView) findViewById(R.id.iv_jing_dong);
        iv_jing_dong.setBackgroundResource(R.drawable.jing_dong_animation_list);
        AnimationDrawable ad = (AnimationDrawable) iv_jing_dong.getBackground();
        ad.start();


    }
}
