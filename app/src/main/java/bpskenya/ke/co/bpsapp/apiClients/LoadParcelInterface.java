package bpskenya.ke.co.bpsapp.apiClients;

import bpskenya.ke.co.bpsapp.models.Parcel;
import bpskenya.ke.co.bpsapp.models.Trip;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LoadParcelInterface {

    @GET("loadParcel/{tripId}/{parcelId}")
    Call<Parcel> loadParcel(@Path("tripId")int id, @Path("parcelId")String parcelId);

}
