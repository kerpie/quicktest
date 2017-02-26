package co.herovitamin.testsample.splash;

public class SplashPresenterImpl implements SplashContract.Presenter{

    SplashContract.View mView;

    public SplashPresenterImpl(SplashContract.View view) {
        mView = view;
    }

    @Override
    public void startCountDown() {
        mView.beginCountDown(3000);
        mView.showLoader();
    }

    @Override
    public void startLoginActivity() {
        mView.changeActivity();
    }
}
