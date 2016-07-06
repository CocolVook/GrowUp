package cn.tinycube.trial.search.hot;

import java.util.List;
import java.util.Map;

import cn.tinycube.trial.search.history.Keyword;
import cn.tinycube.trial.utils.http.AbstractHttp;
import cn.tinycube.trial.utils.http.SimpleCallback;

/**
 * @author: WangJianbiao
 * @time: 16/5/2-下午9:53.
 * @email: wangjianbiao@qccr.com
 * @desc: 热门搜索
 */
public class SearchHot extends AbstractHttp implements ISearchHot {
    @Override
    public void asyncGetHotList(SimpleCallback<List<Keyword>> callback) {
        getRequest("", getHeader(), "", callback);
    }

    private Map<String, Object> getHeader() {
        return null;
    }
}
