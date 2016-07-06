package cn.tinycube.trial.api;

import java.util.List;

import cn.tinycube.trial.entity.Repo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author: WangJianbiao
 * @time: 16/6/2-下午6:41.
 * @email: wangjianbiao@qccr.com
 * @desc:
 */
public interface GitHubService {
    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);
}
