package cn.tinycube.growup.ui;

import android.content.Intent;
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
public class SplashActivity extends AppCompatActivity {
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
        if (是否设置状态栏颜色()) {
            设置状态栏颜色(getResources().getDrawable(R.drawable.sr_primary));
        }
        setContentView(R.layout.splash);
        ButterKnife.bind(this);
        初始化友盟配置();

        初始化界面();

        初始化首页动画();
    }


    protected boolean 是否设置状态栏颜色() {
        return false;
    }

    protected void 设置状态栏颜色(Drawable tintDrawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            SystemBarTintManager mTintManager = new SystemBarTintManager(this);
            if (tintDrawable != null) {
                mTintManager.setStatusBarTintEnabled(true);
                mTintManager.setTintDrawable(tintDrawable);
            } else {
                mTintManager.setStatusBarTintEnabled(false);
                mTintManager.setTintDrawable(null);
            }
        }
    }

    private void 初始化友盟配置() {

    }

    private void 初始化界面() {

    }

    private void 初始化首页动画() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                完成初始化();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        mSplashImage.startAnimation(animation);
    }

    private void 完成初始化() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 拦截返回按钮事件
        return event.getKeyCode() == KeyEvent.KEYCODE_BACK || super.onKeyDown(keyCode, event);
    }
}
