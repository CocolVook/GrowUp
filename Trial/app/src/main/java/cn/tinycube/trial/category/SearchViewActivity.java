package cn.tinycube.trial.category;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import cn.tinycube.trial.R;

/**
 * @author: WangJianbiao
 * @time: 16/4/29-上午10:42.
 * @email: wangjianbiao@qccr.com
 * @desc: 搜索
 */
public class SearchViewActivity extends AppCompatActivity {

    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);

        title = (TextView) findViewById(R.id.title);
        title.setText("搜索框");

    }
}
