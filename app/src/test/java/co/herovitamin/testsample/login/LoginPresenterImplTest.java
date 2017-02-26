package co.herovitamin.testsample.login;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import co.herovitamin.testsample.R;
import co.herovitamin.testsample.network.model.User;


public class LoginPresenterImplTest {

    private LoginContract.View mView;
    private LoginPresenterImpl mLoginPresenter;

    @Before
    public void setUp() throws Exception {

        mView = Mockito.mock(LoginContract.View.class);
        mLoginPresenter = new LoginPresenterImpl(mView, null);
    }

    @Test
    public void whenUsernameIsEmptyThenShowError(){
        Mockito.when(mView.getUsername()).thenReturn("");
        Mockito.when(mView.getPassword()).thenReturn("123456789");
        mLoginPresenter.login(mView.getUsername(), mView.getPassword());
        Mockito.verify(mView).showEmptyFieldErrorMessage(R.string.error_empty_field);
    }

    @Test
    public void whenPasswordIsEmptyThenShowError(){
        Mockito.when(mView.getUsername()).thenReturn("Jhon");
        Mockito.when(mView.getPassword()).thenReturn("");
        mLoginPresenter.login(mView.getUsername(), mView.getPassword());
        Mockito.verify(mView).showEmptyFieldErrorMessage(R.string.error_empty_field);
    }

    @Test
    public void whenUsernameAndPasswordAreIncorrectThenShowError(){
        Mockito.when(mView.getUsername()).thenReturn("Jhon");
        Mockito.when(mView.getPassword()).thenReturn("supah4x0r");

        mLoginPresenter.loginResponseFailed();

        Mockito.verify(mView).showWrongCredentialsErrorMessage(R.string.error_wrong_credentials);
    }

    @Test
    public void whenUsernameAndPasswordAreCorrectThenSendRequestToServer(){

        Mockito.when(mView.getUsername()).thenReturn("Jhon");
        Mockito.when(mView.getPassword()).thenReturn("supah4x0r");

        User user = new User("Jhon", mView.getUsername(), mView.getPassword());

        mLoginPresenter.loginResponseSuccess(user);

        Mockito.verify(mView).startNewActivity(user);

    }
}