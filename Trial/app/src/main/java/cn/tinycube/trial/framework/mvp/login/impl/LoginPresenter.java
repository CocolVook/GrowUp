package cn.tinycube.trial.framework.mvp.login.impl;

import cn.tinycube.trial.framework.mvp.AbstractPresenter;
import cn.tinycube.trial.framework.mvp.login.design.ILoginModel;
import cn.tinycube.trial.framework.mvp.login.design.ILoginPresenter;
import cn.tinycube.trial.framework.mvp.login.design.ILoginView;
import cn.tinycube.trial.utils.http.Callback;

/**
 * @author: WangJianbiao
 * @time: 16/5/27-上午11:30.
 * @email: wangjianbiao@qccr.com
 * @desc:
 */
public class LoginPresenter extends AbstractPresenter<ILoginView> implements ILoginPresenter {

    private ILoginModel mLogin;

    public LoginPresenter(ILoginView view) {
        super(view);
        mLogin = new LoginModel();
    }

    @Override
    public void login() {
        String username = mView.getUsername();
        String password = mView.getPassword();
        mLogin.login(username, password, new Callback<String, String>() {
            @Override
            public void onSuccess(String response) {
                mView.toast(response);
            }

            @Override
            public void onFailure(String s) {
                mView.toast(s);
            }
        });
    }
}
