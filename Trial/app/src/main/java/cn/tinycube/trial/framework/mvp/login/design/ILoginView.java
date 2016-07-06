package cn.tinycube.trial.framework.mvp.login.design;

import cn.tinycube.trial.framework.mvp.AbstractView;

/**
 * @author: WangJianbiao
 * @time: 16/5/27-上午11:30.
 * @email: wangjianbiao@qccr.com
 * @desc: 登录
 */
public interface ILoginView extends AbstractView {

    /**
     * 账号
     */
    String getUsername();

    /**
     * 密码
     */
    String getPassword();

}
