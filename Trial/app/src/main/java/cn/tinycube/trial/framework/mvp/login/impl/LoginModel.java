package cn.tinycube.trial.framework.mvp.login.impl;

import android.text.TextUtils;

import cn.tinycube.trial.framework.mvp.login.design.ILoginModel;
import cn.tinycube.trial.utils.http.Callback;

/**
 * @author: WangJianbiao
 * @time: 16/5/27-下午4:00.
 * @email: wangjianbiao@qccr.com
 * @desc:
 */
public class LoginModel implements ILoginModel {

    @Override
    public void login(String username, String password, Callback<String, String> callback) {
        if (!TextUtils.isEmpty(username)) {
            callback.onSuccess("登录成功! \n 你好, " + username);
        } else {
            callback.onFailure("网络错误");
        }
    }
}
