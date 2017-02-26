package co.herovitamin.testsample.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.herovitamin.testsample.MainActivity;
import co.herovitamin.testsample.R;
import co.herovitamin.testsample.network.API;
import co.herovitamin.testsample.network.RetrofitClient;
import co.herovitamin.testsample.network.model.User;

public class LoginFragment extends Fragment implements LoginContract.View{

    @BindView(R.id.edt_username)
    EditText mUsername;
    @BindView(R.id.edt_password)
    EditText mPassword;
    @BindView(R.id.bt_submit)
    Button mLoginButton;
    @BindView(R.id.pg_login_loader)
    ProgressBar mLoader;

    API mAPI;
    private LoginPresenterImpl mLoginPresenter;

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAPI = RetrofitClient.getInstance();
        mLoginPresenter = new LoginPresenterImpl(this, mAPI);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mLoginButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                mLoginPresenter.login(getUsername(), getPassword());
            }
        });
    }

    @Override
    public String getUsername() {
        return mUsername.getText().toString();
    }

    public String getPassword() {
        return mPassword.getText().toString();
    }

    @Override
    public void showEmptyFieldErrorMessage(@StringRes int errorEmptyField) {
        Snackbar.make(mLoginButton, errorEmptyField, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showWrongCredentialsErrorMessage(@StringRes int error_wrong_credentials) {
        Snackbar.make(mLoginButton, error_wrong_credentials, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void startNewActivity(User user) {
        if (user == null)
            showWrongCredentialsErrorMessage(R.string.error_wrong_credentials);
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void showLoader() {
        mLoginButton.setEnabled(false);
        mLoader.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoader() {
        mLoginButton.setEnabled(true);
        mLoader.setVisibility(View.GONE);
    }
}
