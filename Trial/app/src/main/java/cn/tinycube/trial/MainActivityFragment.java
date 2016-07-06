package cn.tinycube.trial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.androidcommon.adapter.BGAOnItemChildClickListener;
import cn.tinycube.trial.category.CategoryAdapter;
import cn.tinycube.trial.entity.Category;
import cn.tinycube.trial.entity.CategoryEnum;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends ListFragment implements View.OnClickListener, BGAOnItemChildClickListener {

    CategoryAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new CategoryAdapter(getContext(), android.R.layout.simple_list_item_1);
        adapter.setOnItemChildClickListener(this);
        adapter.setDatas(getData());
        setListAdapter(adapter);
    }

    private List<Category> getData() {
        List<Category> data = new ArrayList<>();
        data.add(new Category(CategoryEnum.SearchView));
        data.add(new Category(CategoryEnum.RecycleView));
        data.add(new Category(CategoryEnum.WebViewJS));
        data.add(new Category(CategoryEnum.Login));
        data.add(new Category(CategoryEnum.Retrofit));
        data.add(new Category(CategoryEnum.MotionEvent));
        return data;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemChildClick(ViewGroup parent, View childView, int position) {
        switch (childView.getId()) {
            case android.R.id.text1:
                Category category = adapter.getItem(position);
                startActivity(new Intent(getContext(), category.getTarget()));
                break;
        }
    }
}
