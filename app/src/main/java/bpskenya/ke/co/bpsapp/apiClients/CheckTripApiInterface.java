package bpskenya.ke.co.bpsapp.apiClients;

import bpskenya.ke.co.bpsapp.models.Parcel;
import bpskenya.ke.co.bpsapp.models.Trip;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CheckTripApiInterface {
    @GET("userTrip/{userId}")
    Call<Trip> checkTrip(@Path("userId")int id);

}
