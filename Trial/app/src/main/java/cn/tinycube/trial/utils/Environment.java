package cn.tinycube.trial.utils;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author: WangJianbiao
 * @time: 16/5/2-下午1:30.
 * @email: wangjianbiao@qccr.com
 * @desc:
 */
@Retention(RetentionPolicy.SOURCE)
@StringDef({Environment.RELEASE_HTTP, Environment.PRE_HTTP, Environment.TEST_HTTP, Environment.DEVELOPER_HTTP})
public @interface Environment {

    /**
     * 正式环境
     */
    String RELEASE_HTTP = "正式环境";
    /**
     * 预发布环境
     */
    String PRE_HTTP = "预发布环境";
    /**
     * 测试环境
     */
    String TEST_HTTP = "测试环境";
    /**
     * 开发环境
     */
    String DEVELOPER_HTTP = "开发环境";

}
