package apkmarvel.retrofitrxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import apkmarvel.retrofitrxjava.rxretro.Data;
import apkmarvel.retrofitrxjava.rxretro.model.Github;
import apkmarvel.retrofitrxjava.rxretro.service.GitService;
import apkmarvel.retrofitrxjava.rxretro.service.ServiceFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void click(View v){
        GitService gitService = ServiceFactory.createRetrofitService(GitService.class, GitService.SERVICE_ENDPOINT);
        for(String login : Data.githubList) {
            gitService.getUser(login)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<Github>() {
                        @Override
                        public final void onCompleted() {
                            // do nothing
                        }

                        @Override
                        public final void onError(Throwable e) {
                            Log.e("GithubDemo", e.getMessage());
                        }

                        @Override
                        public final void onNext(Github response) {
                            Toast.makeText(MainActivity.this, response.getLogin(), Toast.LENGTH_SHORT).show();
                            Log.e(TAG,response.getLogin());
                        }
                    });
        }
    }
    public void retrofit(View v){

    }
}
