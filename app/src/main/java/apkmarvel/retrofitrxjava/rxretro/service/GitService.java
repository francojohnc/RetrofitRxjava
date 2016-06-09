package apkmarvel.retrofitrxjava.rxretro.service;

import apkmarvel.retrofitrxjava.rxretro.model.Github;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by jcf on 6/9/2016.
 */
public interface GitService {
//    https://api.github.com/users/francojohnc
    String SERVICE_ENDPOINT = "https://api.github.com";
    @GET("/users/{login}")
    Observable<Github> getUser(@Path("login") String login);
}
