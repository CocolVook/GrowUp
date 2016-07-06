package cn.tinycube.trial.search.history;

import java.util.List;

/**
 * @author: WangJianbiao
 * @time: 16/5/2-下午2:38.
 * @email: wangjianbiao@qccr.com
 * @desc: 搜索的历史记录
 */
public interface ISearchHistory {

    /**
     * 保存某个类型关键词
     */
    void saveKeyword(Keyword keyword);

    /**
     * 清空历史记录
     */
    void clearHistory();

    /**
     * 获取全部历史记录
     */
    List<Keyword> getHistoryList();

    /**
     * 获取某个关键词相关的历史记录
     */
    List<Keyword> getRelatedHistory(Keyword word);
}
