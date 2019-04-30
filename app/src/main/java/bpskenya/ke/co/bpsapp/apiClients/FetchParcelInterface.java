package bpskenya.ke.co.bpsapp.apiClients;

import bpskenya.ke.co.bpsapp.models.Parcel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FetchParcelInterface {

    @GET("parcel/{parcelId}")
    Call<Parcel>fetchParcel(@Path("parcelId")String id);
}
