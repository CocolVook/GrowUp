package cn.tinycube.trial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * @author: WangJianbiao
 * @time: 16/4/25-下午4:51.
 * @email: wangjianbiao@qccr.com
 * @desc: 启动页面
 */
public class SplashActivity extends AppCompatActivity {

    private Timer mTimer;
    TextView skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        skip = (TextView) findViewById(R.id.skip);

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTimer.stop();
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        });

        mTimer = new Timer.Builder(new Timer.Callback() {
            @Override
            public void onFinish() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }

            @Override
            public void onTick(long millisSpend, long millisLeft) {
                skip.setText(getString(R.string.skip, millisLeft / 1000));
            }
        }).setTotalMillis(5000).builder();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mTimer.start();
    }

}
