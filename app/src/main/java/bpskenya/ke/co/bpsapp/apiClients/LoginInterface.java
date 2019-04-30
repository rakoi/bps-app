package bpskenya.ke.co.bpsapp.apiClients;

import bpskenya.ke.co.bpsapp.models.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LoginInterface {

    @GET("login/{email}/{password}")
    Call<User> loginUser(@Path("email")String email,@Path("password")String password);
}
