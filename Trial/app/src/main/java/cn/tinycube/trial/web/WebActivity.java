package cn.tinycube.trial.web;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

import java.lang.ref.WeakReference;

import cn.tinycube.trial.R;

/**
 * @author: WangJianbiao
 * @time: 16/5/9-下午4:46.
 * @email: wangjianbiao@qccr.com
 * @desc:
 */
public class WebActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "WebActivity";
    private static final String KEY_URL = "url";
    public ValueCallback<Uri[]> uploadMessage;
    private WebView mWebview;
    private ProgressBar mProgressbar;
    private WebHandler mWebHandler;
    private int mProgress = 1;
    private static final int UPDATE_PROGRESS = 1;
    private static final int DISMISS_PROGRESS = 2;

    private String mUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        mWebview = (WebView) findViewById(R.id.web);
        mWebHandler = new WebHandler(this);
        getIntentData();
        initView();
        initData();
    }

    private void initData() {
        mWebview.loadUrl(mUrl);
        WebSettings ws = mWebview.getSettings();
        ws.setJavaScriptEnabled(true);
        mWebview.addJavascriptInterface(new MyJavaScriptInterface(this, mWebview), "toApp");
    }

    @Override
    protected void onDestroy() {
        mWebHandler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    private void getIntentData() {
        mUrl = getIntent().getStringExtra(KEY_URL);
        if (TextUtils.isEmpty(mUrl)) {
            mUrl = "file:///android_asset/test1.html";
        }
    }

    private void initView() {

    }

    private void startActivity(String packageName, String className) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        ComponentName cn = new ComponentName(packageName, className);
        intent.setComponent(cn);
        startActivity(intent);
    }

    String compressPath = "";

    String imagePaths;
    Uri cameraUri;

    @Override
    public void onClick(View v) {

    }

    static class WebHandler extends Handler {
        WeakReference<WebActivity> mActivity;

        WebHandler(WebActivity activity) {
            mActivity = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_PROGRESS:
                    removeMessages(UPDATE_PROGRESS);
                    WebActivity activity = mActivity.get();
                    activity.mProgressbar.setVisibility(View.VISIBLE);
                    if (activity.mProgressbar.getProgress() < activity.mProgress) {
                        if (activity.mProgress < 60) {
                            // 此处是在加载h5页面比较卡顿时可以模拟前60%的加载进度
                            activity.mProgress += 2;
                            sendEmptyMessageDelayed(UPDATE_PROGRESS, 100);
                        }
                        activity.mProgressbar.setProgress(activity.mProgress);
                    }
                    if (activity.mProgress >= 100) {
                        sendEmptyMessageDelayed(DISMISS_PROGRESS, 100);
                    }
                    break;
                case DISMISS_PROGRESS:
                    activity = mActivity.get();
                    activity.mProgressbar.setVisibility(View.GONE);
                    activity.mProgress = 1;
                    break;
            }
        }

    }

    static class MyJavaScriptInterface {
        private Activity mActivity;
        private WebView mWebView;
        private boolean mNeedZan;

        private MyJavaScriptInterface() {
        }

        public MyJavaScriptInterface(Activity activity, WebView web) {
            mActivity = activity;
            mWebView = web;
        }

        // 获取品牌
        @JavascriptInterface
        public void addCar(JsCallback callback) {
            try {
                callback.apply("你添加了爱车");
            } catch (JsCallback.JsCallbackException e) {
                e.printStackTrace();
            }
        }
    }
}
