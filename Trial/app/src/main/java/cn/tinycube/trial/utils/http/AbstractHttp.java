package cn.tinycube.trial.utils.http;

import com.android.volley.Request;

import java.util.Map;

/**
 * @author: WangJianbiao
 * @time: 16/5/2-下午9:55.
 * @email: wangjianbiao@qccr.com
 * @desc:
 */
public abstract class AbstractHttp {

    protected <T> void request(int method, String url, Map<String, Object> headers, Map<String, Object> datas, final SimpleCallback<T> callback) {
        // TODO: WangJianbiao 16/5/2 调用发网络请求
    }

    protected <T> void getRequest(String url, Map<String, Object> headers, String queryString, SimpleCallback<T> callback) {
        request(Request.Method.GET, url + "?" + queryString, headers, null, callback);
    }

    protected <T> void postRequest(String url, Map<String, Object> headers, Map<String, Object> params, SimpleCallback<T> callback) {
        request(Request.Method.POST, url, headers, params, callback);
    }

    protected <T> void putRequest(String url, Map<String, Object> headers, Map<String, Object> params, SimpleCallback<T> callback) {
        request(Request.Method.PUT, url, headers, params, callback);
    }
}
