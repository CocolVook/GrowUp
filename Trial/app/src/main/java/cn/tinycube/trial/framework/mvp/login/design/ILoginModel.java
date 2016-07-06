package cn.tinycube.trial.framework.mvp.login.design;

import cn.tinycube.trial.framework.mvp.AbstractModel;
import cn.tinycube.trial.utils.http.Callback;

/**
 * @author: WangJianbiao
 * @time: 16/5/27-下午2:26.
 * @email: wangjianbiao@qccr.com
 * @desc:
 */
public interface ILoginModel extends AbstractModel {

    /**
     * 登录
     */
    void login(String username, String password, Callback<String, String> callback);

}
