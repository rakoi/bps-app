package bpskenya.ke.co.bpsapp;


import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import bpskenya.ke.co.bpsapp.apiClients.AppAPIClient;
import bpskenya.ke.co.bpsapp.apiClients.FetchParcelInterface;
import bpskenya.ke.co.bpsapp.apiClients.LoadParcelInterface;
import bpskenya.ke.co.bpsapp.models.Parcel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoadParcelActivity extends AppCompatActivity {

    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<Parcel> parcelArrayList=new ArrayList<>();
    FetchParcelInterface fetchParcelInterface;
    Call<Parcel> call;
    EditText parcelInput;
    ProgressDialog progressDialog;
    int tripId;
    LoadParcelInterface loadParcelInterface;
    ProgressDialog loadProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_parcel);
        loadProgressDialog=new ProgressDialog(this);
        Toolbar toolbar=(Toolbar)findViewById(R.id.loadParcelToolbar);
        toolbar.setTitle("Load Parcels");

        setSupportActionBar(toolbar);
        Bundle bundle=getIntent().getExtras();
        tripId=bundle.getInt("tripId");

        recyclerView=(RecyclerView)findViewById(R.id.loadParcelRecyclerView);
        layoutManager=new LinearLayoutManager(this);
        adapter=new RecyclerAdapter(parcelArrayList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        parcelInput=(EditText)findViewById(R.id.loadParcelInpput);

        parcelInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length()>2) {
                    fetchParcel(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.load_parcels_menu,menu);
        return true;
    }



    public void fetchParcel(String parcelId) {
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading");
        progressDialog.show();

        fetchParcelInterface = AppAPIClient.getApiClient().create(FetchParcelInterface.class);
        call = fetchParcelInterface.fetchParcel(parcelId);
        call.enqueue(new Callback<Parcel>() {
            @Override
            public void onResponse(Call<Parcel> call, Response<Parcel> response) {
                Parcel parcel = response.body();
                    parcelArrayList.add(parcel);

                parcelInput = (EditText) findViewById(R.id.loadParcelInpput);
                parcelInput.setText("");
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<Parcel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_SHORT).show();
                EditText editText = (EditText) findViewById(R.id.loadParcelInpput);
                editText.setText("");
                progressDialog.dismiss();

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.loadItems){
            if(parcelArrayList.isEmpty()){
                Toast.makeText(getApplicationContext(),"Scan Items",Toast.LENGTH_SHORT).show();
            }else{

                loadProgressDialog.setMessage("Loading Parcels");
                loadProgressDialog.show();
                for (Parcel parcel:parcelArrayList){
                    loadParcel(parcel.getEncodedId());
                }
                loadProgressDialog.setCancelable(false);

               parcelArrayList.clear();
                 adapter.notifyDataSetChanged();
            }

        }

        return super.onOptionsItemSelected(item);
    }
    public void loadParcel(String id){
            loadParcelInterface=AppAPIClient.getApiClient().create(LoadParcelInterface.class);
            Call<Parcel> loadParcelCall=loadParcelInterface.loadParcel(tripId,id);
        loadParcelCall.enqueue(new Callback<Parcel>() {
                @Override
                public void onResponse(Call<Parcel> call, Response<Parcel> response) {
                    loadProgressDialog.dismiss();
                    Toast.makeText(getApplicationContext(),"Parcels Have been Updated",Toast.LENGTH_LONG).show();
                    Log.d("data",response.body().toString());
                }

                @Override
                public void onFailure(Call<Parcel> call, Throwable t) {
                    Log.d("error",t.toString());
                    Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_LONG).show();

                }
            });

    }
}
