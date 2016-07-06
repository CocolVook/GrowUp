package cn.tinycube.trial.framework.mvp;

/**
 * @author: WangJianbiao
 * @time: 16/5/27-上午11:27.
 * @email: wangjianbiao@qccr.com
 * @desc: 父类Presenter
 */
public abstract class AbstractPresenter<V> {
    protected V mView;

    public AbstractPresenter(V view) {
        attach(view);
    }

    public void attach(V view) {
        mView = view;
    }

    public void detach() {
        mView = null;
    }

    public void attach() {

    }
}
