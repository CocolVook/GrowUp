package cn.tinycube.trial.category;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.tinycube.trial.R;
import cn.tinycube.trial.utils.MotionEventView;
import cn.tinycube.trial.utils.MotionEventViewGroup;

/**
 * @author: WangJianbiao
 * @time: 16/7/5-上午10:35.
 * @email: wangjianbiao@qccr.com
 * @desc: 事件分发
 */
public class MotionEventActivity extends AppCompatActivity {

    @Bind(R.id.e)
    MotionEventView mE;
    @Bind(R.id.c)
    MotionEventViewGroup mC;
    @Bind(R.id.g)
    MotionEventView mG;
    @Bind(R.id.h)
    MotionEventView mH;
    @Bind(R.id.f)
    MotionEventViewGroup mF;
    @Bind(R.id.k)
    MotionEventView mK;
    @Bind(R.id.d)
    MotionEventViewGroup mD;
    @Bind(R.id.i)
    MotionEventView mI;
    @Bind(R.id.b)
    MotionEventViewGroup mB;
    @Bind(R.id.j)
    MotionEventView mJ;
    @Bind(R.id.a)
    MotionEventViewGroup mA;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion_event);
        ButterKnife.bind(this);
    }
}
