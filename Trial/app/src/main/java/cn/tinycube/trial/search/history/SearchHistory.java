package cn.tinycube.trial.search.history;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import cn.tinycube.trial.utils.AbstractSharedPreference;

/**
 * @author: WangJianbiao
 * @time: 16/5/2-下午2:32.
 * @email: wangjianbiao@qccr.com
 * @desc: 搜索历史记录
 */
public class SearchHistory extends AbstractSharedPreference implements ISearchHistory {

    public SearchHistory(Context context) {
        super(context);
    }

    @Override
    protected String getPreferenceName() {
        return "searchHistory";
    }

    @Override
    public void saveKeyword(Keyword keyword) {
        List<Keyword> history = getHistoryList();
        assert history != null;
        if (history.contains(keyword)) {
            history.remove(keyword);
        }
        history.add(keyword);
        Collections.sort(history, new Comparator<Keyword>() {
            @Override
            public int compare(Keyword l, Keyword r) {
                return r.getTimestamp() > l.getTimestamp() ? 1 : -1;
            }
        });
        String historyList = new Gson().toJson(history);
        putString("historyList", historyList);
    }

    @Override
    public void clearHistory() {
        clear();
    }

    @Override
    public List<Keyword> getHistoryList() {
        List<Keyword> history;
        try {
            history = new Gson().fromJson(getString("historyList"), new TypeToken<List<Keyword>>() {
            }.getType());
        } catch (Exception ignored) {
            history = new ArrayList<>();
        }
        return history;
    }

    @Override
    public List<Keyword> getRelatedHistory(Keyword word) {
        List<Keyword> history = getHistoryList();
        List<Keyword> relatedHistory = new ArrayList<>();
        for (Keyword keyword : history) {
            if (keyword.getType() == word.getType()) {
                if (keyword.getKeyword().contains(word.getKeyword())) {
                    relatedHistory.add(keyword);
                }
            }
        }
        return relatedHistory;
    }
}
