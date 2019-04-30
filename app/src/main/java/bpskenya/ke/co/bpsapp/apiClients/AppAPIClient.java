package bpskenya.ke.co.bpsapp.apiClients;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppAPIClient {

    public static final String url="http://192.168.43.168:8080/api/";

    public static Retrofit retrofit;

    public static Retrofit getApiClient(){
        if (retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit;
    }



}
