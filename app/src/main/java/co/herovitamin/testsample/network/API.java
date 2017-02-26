package co.herovitamin.testsample.network;

import co.herovitamin.testsample.network.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface API {
    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @POST("users")
    public Call<User> createUser(@Body User user);
}
