package co.herovitamin.testsample.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import co.herovitamin.testsample.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    @Override
    protected void onResume() {
        super.onResume();
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_login, LoginFragment.newInstance()).commit();
    }
}