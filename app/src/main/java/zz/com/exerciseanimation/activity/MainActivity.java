package zz.com.exerciseanimation.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import zz.com.exerciseanimation.R;

/**
 * Created by Administrator on 2016/10/27.
 */
public class MainActivity extends Activity implements View.OnClickListener {
    private TextView tv_jing_dong, tv_flip_effect;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tv_jing_dong = (TextView) findViewById(R.id.tv_jing_dong);
        tv_jing_dong.setOnClickListener(this);
        tv_flip_effect = (TextView) findViewById(R.id.tv_flip_effect);
        tv_flip_effect.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_jing_dong:
                startActivity(new Intent(this, JingDongFrameActivity.class));
                break;
            case R.id.tv_flip_effect:  //翻牌效果
                startActivity(new Intent(this, FlipEffectActivity.class));
                break;
        }
    }
}
