package cn.tinycube.trial.framework.callback;

/**
 * @author: WangJianbiao
 * @time: 16/5/27-下午3:16.
 * @email: wangjianbiao@qccr.com
 * @desc:
 */
public interface Callback<R> {

    void onResponse(R response);
    
}
