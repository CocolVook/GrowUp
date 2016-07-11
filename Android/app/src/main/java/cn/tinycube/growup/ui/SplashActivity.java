package cn.tinycube.growup.ui;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.tinycube.growup.R;
import cn.tinycube.growup.utils.SystemBarTintManager;

/**
 * @author: WangJianbiao
 * @time: 16/7/6-下午7:18.
 * @email: wangjianbiao@qccr.com
 * @desc:
 */
public class SplashActivity extends BaseActivity {

    // 启动图
    @Bind(R.id.image)
    ImageView mSplashImage;
    // 版本号
    @Bind(R.id.version_name)
    TextView mVersionName;
    // 版权
    @Bind(R.id.copyright)
    TextView mCopyright;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        ButterKnife.bind(this);
        initUmengConfig();
        initView();
        initAnimation();
    }

    @Override
    protected int onSetStatusBarColor() {
        return android.R.color.transparent;
    }

    private void initUmengConfig() {

    }

    private void initView() {

    }

    private void initAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                finishInitial();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        mSplashImage.startAnimation(animation);
    }

    private void finishInitial() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 拦截返回按钮事件
        return event.getKeyCode() == KeyEvent.KEYCODE_BACK || super.onKeyDown(keyCode, event);
    }
}
