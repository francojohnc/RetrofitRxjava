package apkmarvel.retrofitrxjava.retrofit;

import retrofit.http.GET;
import retrofit.http.Path;

public interface GitHubService {
  @GET("users/{user}/repos")
  Call<List<Repo>> listRepos(@Path("user") String user);
}