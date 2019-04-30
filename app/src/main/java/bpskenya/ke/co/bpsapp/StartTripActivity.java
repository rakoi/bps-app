package bpskenya.ke.co.bpsapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import bpskenya.ke.co.bpsapp.apiClients.AppAPIClient;
import bpskenya.ke.co.bpsapp.apiClients.StartTripApiInterface;
import bpskenya.ke.co.bpsapp.models.Trip;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StartTripActivity extends AppCompatActivity {

    public StartTripApiInterface startTripApiInterface;

    public Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_trip);
        spinner=(Spinner)findViewById(R.id.spinner);

         ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this, R.array.trip_type, android.R.layout.simple_spinner_dropdown_item);

         arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         spinner.setAdapter(arrayAdapter);
    }
    public void startTripBtn(View view){

        SharedPreferences sharedPreferences=getSharedPreferences("bps",Context.MODE_PRIVATE);
        int userId=sharedPreferences.getInt("id",0);
        EditText to=(EditText)findViewById(R.id.to);
        TextView warning=(TextView)findViewById(R.id.warningtext);
        EditText from=(EditText)findViewById(R.id.from);
        String start=to.getText().toString();
        spinner=(Spinner)findViewById(R.id.spinner);
        String type=spinner.getSelectedItem().toString();
        String destination=to.getText().toString();
        if (start.equals("")||destination.equals("")){
            warning.setText("Fill in all fields");
        }else{
            startTrip(1,start,destination,type);
        }
    }
    public void startTrip(int id,String start,String destination,String type){
            startTripApiInterface= AppAPIClient.getApiClient().create(StartTripApiInterface.class);
        Call<Trip> startTripCall= startTripApiInterface.fetchParcel(id,start,destination,type);
        startTripCall.enqueue(new Callback<Trip>() {
            @Override
            public void onResponse(Call<Trip> call, Response<Trip> response) {
                Toast.makeText(getApplicationContext(),"Trip has been Started",Toast.LENGTH_LONG).show();
                finish();
            }

            @Override
            public void onFailure(Call<Trip> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();

            }
        });

    }
}
