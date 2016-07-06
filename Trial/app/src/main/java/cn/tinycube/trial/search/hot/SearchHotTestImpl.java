package cn.tinycube.trial.search.hot;

import java.util.ArrayList;
import java.util.List;

import cn.tinycube.trial.search.history.Keyword;
import cn.tinycube.trial.utils.http.Response;
import cn.tinycube.trial.utils.http.SimpleCallback;

/**
 * @author: WangJianbiao
 * @time: 16/5/2-下午9:53.
 * @email: wangjianbiao@qccr.com
 * @desc: 测试热门搜索
 */
public class SearchHotTestImpl implements ISearchHot {
    @Override
    public void asyncGetHotList(SimpleCallback<List<Keyword>> callback) {
        List<Keyword> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Keyword("米其林轮胎" + i, 0));
        }
        Response<List<Keyword>> response = new Response<>();
        response.setData(list);
        response.setCode(0);
        response.setMsg("成功");
        callback.onSuccess(response);
    }
}
