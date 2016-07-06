package cn.tinycube.trial.framework.mvp;

/**
 * @author: WangJianbiao
 * @time: 16/5/27-上午11:29.
 * @email: wangjianbiao@qccr.com
 * @desc:
 */
public interface AbstractView {

    void showRefreshing();

    void hideRefreshing();

    void showLoading();

    void hideLoading();

    void toast(String msg);
}
