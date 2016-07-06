package cn.tinycube.trial.utils.http;

/**
 * @author: WangJianbiao
 * @time: 16/5/2-下午10:14.
 * @email: wangjianbiao@qccr.com
 * @desc: 基础应答
 */
public class BaseResponse {
    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
