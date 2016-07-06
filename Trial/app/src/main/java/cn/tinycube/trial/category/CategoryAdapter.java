package cn.tinycube.trial.category;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import cn.bingoogolapple.androidcommon.adapter.BGAAdapterViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;
import cn.tinycube.trial.entity.Category;

/**
 * @author: WangJianbiao
 * @time: 16/4/29-上午10:47.
 * @email: wangjianbiao@qccr.com
 * @desc: 类别
 */
public class CategoryAdapter extends BGAAdapterViewAdapter<Category> {

    public CategoryAdapter(Context context, int itemLayoutId) {
        super(context, itemLayoutId);
    }

    @Override
    protected void fillData(BGAViewHolderHelper viewHolderHelper, int position, Category model) {
        viewHolderHelper.setText(android.R.id.text1, model.getTitle());
        viewHolderHelper.setItemChildClickListener(android.R.id.text1);
    }
}
