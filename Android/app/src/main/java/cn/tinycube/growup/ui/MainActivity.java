package cn.tinycube.growup.ui;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.tinycube.growup.R;

/**
 * @author: WangJianbiao
 * @time: 16/7/6-下午8:38.
 * @email: wangjianbiao@qccr.com
 * @desc: 主页
 */
public class MainActivity extends SimpleBackActivity {

    private List<Map<String, String>> activities = new ArrayList<>();

    @Bind(R.id.list)
    RecyclerView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ButterKnife.bind(this);
        setTitle("主页");
        loadSolveActivity();
        Logger.t("@@@").json("{\"code\":0,\"info\":{\"result\":{\"tradeType\":\"APP\",\"timeStamp\":\"1468829842\",\"mchid\":\"1254118901\",\"prepayid\":\"wx2016071816172381494abff90476851604\",\"appid\":\"wxdcd1be88ce3924dc\",\"nonceStr\":\"8S9kc7GpJRggdAGQ\",\"sign\":\"7234AB2168BB69E66EB20AD36F6D1B01\",\"resultCode\":\"SUCCESS\",\"packageValue\":\"Sign=WXPay\"},\"success\":true},\"msg\":\"成功\"}");
        mListView.setLayoutManager(new LinearLayoutManager(this));
        mListView.setAdapter(new RecyclerView.Adapter<Holder>() {

            @Override
            public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.simple_list, parent, false);
                return new Holder(view);
            }

            @Override
            public void onBindViewHolder(Holder holder, int position) {
                final Map<String, String> map = activities.get(position);
                holder.title.setText(map.get("label"));
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setClassName(getPackageName(), map.get("name"));
                        startActivity(intent);
                    }
                });
            }

            @Override
            public int getItemCount() {
                return activities == null ? 0 : activities.size();
            }
        });
    }

    @Override
    protected int onSetStatusBarColor() {
        return R.color.alpha_20_black;
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

    class Holder extends RecyclerView.ViewHolder {

        TextView title;

        public Holder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.text1);
        }
    }
}
