package cn.tinycube.growup.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import cn.tinycube.growup.R;

/**
 * @author: WangJianbiao
 * @time: 16/7/6-下午8:38.
 * @email: wangjianbiao@qccr.com
 * @desc: 关于
 */
public class AboutActivity extends SimpleBackActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        setTitle(R.string.page_about);
    }
}
