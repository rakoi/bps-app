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
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import bpskenya.ke.co.bpsapp.apiClients.AppAPIClient;
import bpskenya.ke.co.bpsapp.apiClients.FetchParcelInterface;
import bpskenya.ke.co.bpsapp.apiClients.RecieveParcelInterface;
import bpskenya.ke.co.bpsapp.models.Parcel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecieveParcels extends AppCompatActivity {

    RecyclerAdapter adapter;
    RecyclerView recyclerView;

    FetchParcelInterface fetchParcelInterface;
    RecieveParcelInterface recieveParcelInterface;
    Call<Parcel> recieveParcelCall;
    Call<Parcel> call;
    EditText parcelInput;
    RecyclerView.LayoutManager layoutManager;
    ProgressDialog  progressDialog;
    ArrayList<Parcel> parcelArrayList=new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve_parcels);

        Toolbar toolbar=(Toolbar)findViewById(R.id.recieveParcelToolbar);
        toolbar.setTitle("Recieve");

        setSupportActionBar(toolbar);

          parcelInput=(EditText)findViewById(R.id.rParcelInput);
          progressDialog=new ProgressDialog(this);

        parcelInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length()>2) {
                    fetchParcel(s.toString());
                }



               // Toast.makeText(getApplicationContext(),s.toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        adapter=new RecyclerAdapter(parcelArrayList);
        layoutManager=new LinearLayoutManager(this);
        recyclerView=(RecyclerView)findViewById(R.id.recieveParcelRecyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

    }


    public void fetchParcel(String parcelId){
        fetchParcelInterface= AppAPIClient.getApiClient().create(FetchParcelInterface.class);
        call=fetchParcelInterface.fetchParcel(parcelId);
        call.enqueue(new Callback<Parcel>() {
            @Override
            public void onResponse(Call<Parcel> call, Response<Parcel> response) {

                Parcel parcel=response.body();
                parcelArrayList.add(parcel);
                parcelInput=(EditText)findViewById(R.id.rParcelInput);
                parcelInput.setText("");
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<Parcel> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Invalid",Toast.LENGTH_SHORT).show();
                EditText editText=(EditText)findViewById(R.id.rParcelInput);
                editText.setText("");

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recieve_parcel_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.recieveItems){
            if (parcelArrayList.isEmpty()){
                Toast.makeText(getApplicationContext(),"Scan Items",Toast.LENGTH_SHORT).show();
            }else{

                
                progressDialog.setCancelable(false);
                for (Parcel parcel:parcelArrayList){
                    recieveParcel(parcel.getEncodedId());
                    progressDialog.setMessage("Please Wait");
                    progressDialog.show();


                }


                parcelArrayList.clear();
                adapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_SHORT).show();
            }
        }
        return super.onOptionsItemSelected(item);
    }
    public void recieveParcel(String encodedId){
        recieveParcelInterface= AppAPIClient.getApiClient().create(RecieveParcelInterface.class);
           recieveParcelCall=recieveParcelInterface.recieveParcel(encodedId);
            recieveParcelCall.enqueue(new Callback<Parcel>() {
                @Override
                public void onResponse(Call<Parcel> call, Response<Parcel> response) {

                    progressDialog.dismiss();
                }

                @Override
                public void onFailure(Call<Parcel> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),"Unable to Proccess",Toast.LENGTH_SHORT).show();

                }
           });
    }
}
