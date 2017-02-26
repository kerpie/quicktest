package co.herovitamin.testsample.login;

import co.herovitamin.testsample.R;
import co.herovitamin.testsample.network.API;
import co.herovitamin.testsample.network.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenterImpl implements LoginContract.Presenter, Callback<User> {

    LoginContract.View mView;
    API mAPI;

    public LoginPresenterImpl(LoginContract.View view, API API) {
        mView = view;
        mAPI = API;
    }

    @Override
    public void login(String username, String password) {
        if (username == null || username.isEmpty()){
            mView.showEmptyFieldErrorMessage(R.string.error_empty_field);
            return;
        }

        if(password == null || password.isEmpty()){
            mView.showEmptyFieldErrorMessage(R.string.error_empty_field);
            return;
        }

        User user = new User("Jhon", username, password);

//        Call<User> call = mAPI.createUser(user);
//        call.enqueue(this);

        mView.showLoader();
    }

    public void loginResponseSuccess(User user){
        mView.startNewActivity(user);
        mView.hideLoader();
    }

    public void loginResponseFailed(){
        mView.hideLoader();
        mView.showWrongCredentialsErrorMessage(R.string.error_wrong_credentials);
    }

    @Override
    public void onResponse(Call<User> call, Response<User> response) {
        mView.hideLoader();
        if(response.isSuccessful()){
            User user = response.body();
            loginResponseSuccess(user);
        }
    }

    @Override
    public void onFailure(Call<User> call, Throwable t) {
        loginResponseFailed();
    }
}