package bpskenya.ke.co.bpsapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import bpskenya.ke.co.bpsapp.apiClients.AppAPIClient;
import bpskenya.ke.co.bpsapp.apiClients.CheckTripApiInterface;
import bpskenya.ke.co.bpsapp.models.Trip;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public CheckTripApiInterface checkTripApiInterface;
    public Call<Trip> tripCall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(" ");
        setSupportActionBar(toolbar);




    }


    public void LoadBtn(View view){

        SharedPreferences sharedPreferences=getSharedPreferences("bps",Context.MODE_PRIVATE);
        int userId=sharedPreferences.getInt("id",0);
        checkTripApiInterface= AppAPIClient.getApiClient().create(CheckTripApiInterface.class);
        tripCall=checkTripApiInterface.checkTrip(userId);
        tripCall.enqueue(new Callback<Trip>() {
            @Override
            public void onResponse(Call<Trip> call, Response<Trip> response) {
                Trip trip=response.body();
                Intent loadParcelsIntent=new Intent(getApplicationContext(),LoadParcelActivity.class);
                loadParcelsIntent.putExtra("tripId",trip.getId());
                startActivity(loadParcelsIntent);

            }

            @Override
            public void onFailure(Call<Trip> call, Throwable t) {

                startActivity(new Intent(getApplicationContext(),StartTripActivity.class));
               // startActivity(new Intent(startTr));
            }
        });


        //startActivity(new Intent(this,LoadParcelActivity.class));

    }
    public void RecieveBtn(View view){
            startActivity(new Intent(this,RecieveParcels.class));
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem usernamelabel=menu.findItem(R.id.usernamelabel);
        SharedPreferences sharedPreferences=getSharedPreferences("bps", Context.MODE_PRIVATE);
        String username=sharedPreferences.getString("email","");
        usernamelabel.setTitle(username);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public void onBackPressed() {
    moveTaskToBack(true);
    android.os.Process.killProcess(android.os.Process.myPid());
    System.exit(1);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id==R.id.logoutbtn){

            SharedPreferences sharedPreferences=getSharedPreferences("bps", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("password","");
            editor.putString("email","");
            editor.putInt("id",0);
            editor.commit();
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        }

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }
}
