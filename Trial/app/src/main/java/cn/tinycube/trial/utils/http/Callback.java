package cn.tinycube.trial.utils.http;

/**
 * @author: WangJianbiao
 * @time: 16/5/2-下午10:10.
 * @email: wangjianbiao@qccr.com
 * @desc: 请求返回
 */
public interface Callback<Result, Error> {

    /**
     * 数据返回成功
     * 要注意，这里只是应答成功，并不等同于请求成功，
     * 具体业务，还需根据具体返回的数据判断正确与否
     */
    void onSuccess(Result response);

    /**
     * 数据返回错误
     */
    void onFailure(Error error);
}

