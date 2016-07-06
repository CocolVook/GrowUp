package cn.tinycube.trial.search.history;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import cn.tinycube.trial.search.history.ISearchHistory;
import cn.tinycube.trial.search.history.Keyword;

/**
 * @author: WangJianbiao
 * @time: 16/5/2-下午2:32.
 * @email: wangjianbiao@qccr.com
 * @desc: 搜索历史记录
 */
public class SearchHistoryTestImpl implements ISearchHistory {

    private List<Keyword> mHistory = new ArrayList<>();

    @Override
    public void saveKeyword(Keyword keyword) {
        if (mHistory.contains(keyword)) {
            mHistory.remove(keyword);
        }
        mHistory.add(keyword);
        Collections.sort(mHistory, new Comparator<Keyword>() {
            @Override
            public int compare(Keyword l, Keyword r) {
                return r.getTimestamp() > l.getTimestamp() ? 1 : -1;
            }
        });
    }

    @Override
    public void clearHistory() {
        mHistory.clear();
    }

    @Override
    public List<Keyword> getHistoryList() {
        return mHistory;
    }

    @Override
    public List<Keyword> getRelatedHistory(Keyword word) {
        List<Keyword> relatedHistory = new ArrayList<>();
        for (Keyword keyword : mHistory) {
            if (keyword.getType() == word.getType()) {
                if (keyword.getKeyword().contains(word.getKeyword())) {
                    relatedHistory.add(keyword);
                }
            }
        }
        Collections.sort(relatedHistory, new Comparator<Keyword>() {
            @Override
            public int compare(Keyword lhs, Keyword rhs) {
                return rhs.getTimestamp() - lhs.getTimestamp() > 0 ? 1 : -1;
            }
        });
        return relatedHistory;
    }
}
