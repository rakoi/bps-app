package bpskenya.ke.co.bpsapp.apiClients;

import bpskenya.ke.co.bpsapp.models.Parcel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RecieveParcelInterface {

    @GET("recieveParcel/{parcelId}")
    Call<Parcel> recieveParcel(@Path("parcelId")String id);
}
