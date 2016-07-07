package cn.tinycube.growup.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.tinycube.growup.R;

/**
 * @author: WangJianbiao
 * @time: 16/7/6-下午8:38.
 * @email: wangjianbiao@qccr.com
 * @desc:
 */
public class MainActivity extends ListActivity {

    private List<Map<String, String>> activities = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityInfo();
        setListAdapter(new SimpleAdapter(this, activities, android.R.layout.simple_list_item_1, new String[]{"label"}, new int[]{android.R.id.text1}));
    }

    private void getActivityInfo() {
        PackageManager packageManager = getPackageManager();
        try {
            PackageInfo info = packageManager.getPackageInfo(getPackageName(), PackageManager.GET_ACTIVITIES);
            ActivityInfo[] activityInfos = info.activities;
            if (activityInfos != null && activityInfos.length > 0) {
                for (ActivityInfo ai : activityInfos) {
                    Map<String, String> map = new HashMap<>();
                    map.put("name", ai.name);
                    map.put("label", ai.loadLabel(packageManager).toString());
                    activities.add(map);
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
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
