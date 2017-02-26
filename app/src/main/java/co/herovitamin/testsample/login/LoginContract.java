package co.herovitamin.testsample.login;

import android.support.annotation.StringRes;

import co.herovitamin.testsample.network.model.User;

public interface LoginContract {

    interface View{
        String getUsername();
        String getPassword();
        void showEmptyFieldErrorMessage(@StringRes int errorEmptyField);
        void showWrongCredentialsErrorMessage(@StringRes int errorWrongCredentials);
        void startNewActivity(User user);
        void showLoader();
        void hideLoader();
    }

    interface Presenter{
        void login(String username, String password);
    }

}
