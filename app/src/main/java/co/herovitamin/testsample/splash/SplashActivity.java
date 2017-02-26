package co.herovitamin.testsample.splash;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.herovitamin.testsample.R;
import co.herovitamin.testsample.login.LoginActivity;
import co.herovitamin.testsample.network.API;
import co.herovitamin.testsample.network.RetrofitClient;
import co.herovitamin.testsample.network.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity implements SplashContract.View{

    API mAPI;
    SplashContract.Presenter mPresenter;

    @BindView(R.id.pg_loader)
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ButterKnife.bind(this);

        mAPI = RetrofitClient.getInstance();
        mPresenter = new SplashPresenterImpl(this);
    }
    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.startCountDown();
    }

    @Override
    public void beginCountDown(int milliseconds) {
        new Timer(milliseconds, 1000).start();
    }

    @Override
    public void changeActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void showLoader(){
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoader(){
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    class Timer extends CountDownTimer{
        public Timer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {}

        @Override
        public void onFinish() {
            mPresenter.startLoginActivity();
        }
    }
}