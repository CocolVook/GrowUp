package cn.tinycube.trial.category;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import cn.tinycube.trial.R;
import cn.tinycube.trial.api.GitHubService;
import cn.tinycube.trial.entity.Repo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * @author: WangJianbiao
 * @time: 16/6/2-下午6:38.
 * @email: wangjianbiao@qccr.com
 * @desc:
 */
public class RetrofitActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
    }

    public void request(View view) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com").build();
        GitHubService service = retrofit.create(GitHubService.class);
        Call<List<Repo>> repos = service.listRepos("octocat");
        repos.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                List<Repo> data = response.body();
//                Toast.makeText(RetrofitActivity.this, data., Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });
    }
}
