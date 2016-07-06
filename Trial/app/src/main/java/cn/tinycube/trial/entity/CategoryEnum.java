package cn.tinycube.trial.entity;

import cn.tinycube.trial.category.MotionEventActivity;
import cn.tinycube.trial.category.RecyclerViewActivity;
import cn.tinycube.trial.category.RetrofitActivity;
import cn.tinycube.trial.category.SearchViewActivity;
import cn.tinycube.trial.framework.mvp.login.impl.LoginActivity;
import cn.tinycube.trial.web.WebActivity;

/**
 * @author: WangJianbiao
 * @time: 16/4/29-上午10:39.
 * @email: wangjianbiao@qccr.com
 * @desc:
 */
public enum CategoryEnum {

    SearchView(0, "搜索框", SearchViewActivity.class),
    RecycleView(1, "视图回收", RecyclerViewActivity.class),
    WebViewJS(2, "JS交互", WebActivity.class),
    Login(3, "登录",LoginActivity.class),
    Retrofit(4, "retrofit", RetrofitActivity.class),
    MotionEvent(5, "MotionEvent", MotionEventActivity.class);

    CategoryEnum(int id, String title, Class<?> target) {
        this.id = id;
        this.title = title;
        this.target = target;
    }

    private final int id;
    private final String title;
    private final Class<?> target;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Class<?> getTarget() {
        return target;
    }
}
