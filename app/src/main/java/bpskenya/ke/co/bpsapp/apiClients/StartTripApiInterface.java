package bpskenya.ke.co.bpsapp.apiClients;

import bpskenya.ke.co.bpsapp.models.Trip;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StartTripApiInterface {
    @GET("startTrip/{userId}/{start}/{destination}/{type}")
    Call<Trip> fetchParcel(@Path("userId")int id,@Path("start")String start,@Path("destination")String destination,@Path("type")String type);
}
