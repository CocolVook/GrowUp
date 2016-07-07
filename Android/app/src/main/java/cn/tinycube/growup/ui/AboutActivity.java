package cn.tinycube.growup.ui;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import cn.tinycube.growup.R;

/**
 * @author: WangJianbiao
 * @time: 16/7/6-下午8:38.
 * @email: wangjianbiao@qccr.com
 * @desc: 关于
 */
public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
    }
}
