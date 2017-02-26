package co.herovitamin.testsample.splash;

public interface SplashContract{

    interface View{
        void beginCountDown(int milliseconds);
        void changeActivity();
        void showLoader();
        void hideLoader();
    }

    interface Presenter{
        void startCountDown();
        void startLoginActivity();
    }
}
