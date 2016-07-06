package cn.tinycube.trial.category;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.zhy.view.flowlayout.TagFlowLayout;

import cn.tinycube.trial.R;

/**
 * @author: WangJianbiao
 * @time: 16/4/29-下午5:33.
 * @email: wangjianbiao@qccr.com
 * @desc:
 */
public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView recycler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recycler_view);

        recycler = (RecyclerView) findViewById(R.id.recycler);

        init();

    }

    private void init() {
        recycler.setAdapter(new RecyclerView.Adapter() {



            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return null;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return 10;
            }
        });
    }
}
