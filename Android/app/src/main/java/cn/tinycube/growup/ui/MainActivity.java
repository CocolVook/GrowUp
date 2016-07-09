package cn.tinycube.growup.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: WangJianbiao
 * @time: 16/7/6-下午8:38.
 * @email: wangjianbiao@qccr.com
 * @desc: 主页
 */
public class MainActivity extends ListActivity {

    private List<Map<String, String>> activities = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadSolveActivity();
        setListAdapter(new SimpleAdapter(this, activities, android.R.layout.simple_list_item_1, new String[]{"label"}, new int[]{android.R.id.text1}));
    }

    /**
     * 加载列表项
     */
    private void loadSolveActivity() {
        PackageManager manager = getPackageManager();
        try {
            Intent intent = new Intent();
            intent.setAction("cn.tinycube.activity.list");
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            List<ResolveInfo> resolveInfo = manager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
            if (resolveInfo != null && !resolveInfo.isEmpty()) {
                for (ResolveInfo resolve : resolveInfo) {
                    Map<String, String> map = new HashMap<>();
                    map.put("name", resolve.activityInfo.name);
                    map.put("label", resolve.activityInfo.loadLabel(manager).toString());
                    activities.add(map);
                }
            }
        } catch (Exception ignore) {
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Map<String, String> activity = activities.get(position);
        Intent intent = new Intent();
        intent.setClassName(getPackageName(), activity.get("name"));
        startActivity(intent);
    }
}
