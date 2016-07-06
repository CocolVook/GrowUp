package cn.tinycube.trial.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import cn.tinycube.trial.search.history.ISearchHistory;
import cn.tinycube.trial.search.history.Keyword;
import cn.tinycube.trial.search.history.SearchHistoryTestImpl;

import static org.junit.Assert.*;

/**
 * @author: WangJianbiao
 * @time: 16/5/2-下午3:47.
 * @email: wangjianbiao@qccr.com
 * @desc:
 */
public class SearchHistoryTest {


    private Comparator<Keyword> comparator = new Comparator<Keyword>() {
        @Override
        public int compare(Keyword lhs, Keyword rhs) {
            return rhs.getTimestamp() - lhs.getTimestamp() > 0 ? 1 : -1;
        }
    };

    private ISearchHistory mSearchHistory;
    private List<Keyword> list = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        mSearchHistory = new SearchHistoryTestImpl();
        Keyword _keyword;
        mSearchHistory.saveKeyword(_keyword = new Keyword("汽车超人", 0));
        list.add(0, _keyword);
        mSearchHistory.saveKeyword(_keyword = new Keyword("典典养车", 0));
        list.add(0, _keyword);
        mSearchHistory.saveKeyword(_keyword = new Keyword("狗粮", 0));
        list.add(0, _keyword);
        mSearchHistory.saveKeyword(_keyword = new Keyword("T-shirt", 0));
        list.add(0, _keyword);
        mSearchHistory.saveKeyword(_keyword = new Keyword("adidas", 0));
        list.add(0, _keyword);
        mSearchHistory.saveKeyword(_keyword = new Keyword("MacBook", 0));
        list.add(0, _keyword);
        mSearchHistory.saveKeyword(_keyword = new Keyword("shoe", 0));
        list.add(0, _keyword);
        mSearchHistory.saveKeyword(_keyword = new Keyword("汽车超人1", 1));
        list.add(0, _keyword);
        mSearchHistory.saveKeyword(_keyword = new Keyword("汽车超人2", 2));
        list.add(0, _keyword);
        Collections.sort(list, comparator);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSaveKeyword() throws Exception {
        String keyword = "米其林轮胎";
        int size = mSearchHistory.getRelatedHistory(new Keyword(keyword, 0)).size();
        mSearchHistory.saveKeyword(new Keyword(keyword, 0));
        assertEquals(keyword, mSearchHistory.getHistoryList().get(0).getKeyword());
    }

    @Test
    public void testClearHistory() throws Exception {
        mSearchHistory.clearHistory();
        assertEquals(0, mSearchHistory.getHistoryList().size());
    }

    @Test
    public void testGetHistoryList() throws Exception {
        int size = mSearchHistory.getHistoryList().size();
        Keyword keyword = new Keyword("三叶草", 0);
        mSearchHistory.saveKeyword(keyword);
        List<Keyword> history = mSearchHistory.getHistoryList();
        assertEquals(keyword, history.get(0));
    }

    @Test
    public void testGetRelatedHistory() throws Exception {
        List<Keyword> l = new ArrayList<>();
        l.add(new Keyword("汽车超人", 0));
        l.add(new Keyword("典典养车", 0));
        Collections.sort(l, comparator);
        assertEquals(l, mSearchHistory.getRelatedHistory(new Keyword("车", 0)));
    }
}