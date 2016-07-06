package cn.tinycube.trial.utils.http;

/**
 * @author: WangJianbiao
 * @time: 16/5/2-下午10:14.
 * @email: wangjianbiao@qccr.com
 * @desc: 应答抽象泛型类
 */
public class Response<T> extends BaseResponse {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
