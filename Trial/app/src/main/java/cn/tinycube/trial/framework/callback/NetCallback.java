package cn.tinycube.trial.framework.callback;

/**
 * @author: WangJianbiao
 * @time: 16/5/27-下午3:18.
 * @email: wangjianbiao@qccr.com
 * @desc:
 */
public interface NetCallback<R, E> {

    void onSuccess(R result);

    void onError(E error);
}
