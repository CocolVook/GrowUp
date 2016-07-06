package cn.tinycube.trial.search.hot;

import java.util.List;

import cn.tinycube.trial.search.history.Keyword;
import cn.tinycube.trial.utils.http.Callback;
import cn.tinycube.trial.utils.http.SimpleCallback;

/**
 * @author: WangJianbiao
 * @time: 16/5/2-下午9:50.
 * @email: wangjianbiao@qccr.com
 * @desc: 热门搜索
 */
public interface ISearchHot {

    /**
     * 获取热门搜索
     */
    void asyncGetHotList(SimpleCallback<List<Keyword>> callback);
}
