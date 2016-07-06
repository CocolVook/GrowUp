package cn.tinycube.trial.framework.mvp.login.impl;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.tinycube.trial.R;
import cn.tinycube.trial.framework.mvp.MvpActivity;
import cn.tinycube.trial.framework.mvp.login.design.ILoginView;

/**
 * @author: WangJianbiao
 * @time: 16/5/27-上午11:34.
 * @email: wangjianbiao@qccr.com
 * @desc:
 */
public class LoginActivity extends MvpActivity<LoginPresenter> implements ILoginView, View.OnClickListener {

    @Bind(R.id.et_account)
    EditText mEtAccount;
    @Bind(R.id.et_password)
    EditText mEtPassword;
    @Bind(R.id.btn_login)
    Button mBtnLogin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }

    private void initView() {
        mBtnLogin.setOnClickListener(this);
    }

    private void initData() {

    }

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                mPresenter.login();
                break;
        }
    }

    @Override
    public String getUsername() {
        return mEtAccount.getText().toString();
    }

    @Override
    public String getPassword() {
        return mEtPassword.getText().toString();
    }
}
