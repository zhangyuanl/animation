package zz.com.exerciseanimation.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import zz.com.exerciseanimation.R;


/**
 * Created by Administrator on 2016/10/28.  翻牌效果
 */
public class FlipEffectActivity extends Activity implements View.OnClickListener {

    private ImageView imgView;
    private ImageView iv_arrow_rotation;
    //声明一个boolean用来切换背面和正面
    private boolean bool = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flip_effect);

        initview();
    }

    private void initview() {

        imgView = (ImageView) findViewById(R.id.imgView);
        //给ImageView添加点击事件
        imgView.setOnClickListener(this);
        iv_arrow_rotation = (ImageView) findViewById(R.id.iv_arrow_rotation);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgView:
                 /*也可通过代码来实现   这个是收缩效果
            AnimationSet animation = new AnimationSet(true);
            ScaleAnimation scale = new ScaleAnimation(1, 0f, 1, 1f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
            animation.addAnimation(scale);
            animation.setDuration(150);
            */
                Animation animation = AnimationUtils.loadAnimation(FlipEffectActivity.this,R.anim.back_scale);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }
                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }


                    @Override
                    public void onAnimationEnd(Animation animation) {
                        if(bool){
                            imgView.setImageResource(R.drawable.back);
                            bool = false;
                        }else {
                            imgView.setImageResource(R.drawable.front);
                            bool = true;
                        }
                        //通过AnimationUtils得到动画配置文件(/res/anim/front_scale.xml),然后在把动画交给ImageView
                        imgView.startAnimation(AnimationUtils.loadAnimation(FlipEffectActivity.this, R.anim.front_scale));

                    }



                });
                imgView.startAnimation(animation);
                break;
            case R.id.iv_arrow_rotation:  //箭头的旋转

                Animation anim =new RotateAnimation(0f, 180f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                anim.setFillAfter(true); // 设置保持动画最后的状态
                anim.setDuration(3000); // 设置动画时间
                anim.setInterpolator(new AccelerateInterpolator()); // 设置插入器
                iv_arrow_rotation.setImageResource(R.drawable.concern_open);
                iv_arrow_rotation.startAnimation(anim);
                break;
        }
    }
}
