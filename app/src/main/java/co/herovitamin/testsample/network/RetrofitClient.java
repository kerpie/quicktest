package co.herovitamin.testsample.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static final String BASE_URL = "http://192.168.43.163:3000";

    static Retrofit mRetrofit = null;
    static API mAPI = null;

    public static API getInstance(){
        if(mAPI == null){
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mAPI = mRetrofit.create(API.class);
        }
        return mAPI;
    }

}
