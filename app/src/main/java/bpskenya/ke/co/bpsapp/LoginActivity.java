package bpskenya.ke.co.bpsapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import bpskenya.ke.co.bpsapp.apiClients.AppAPIClient;
import bpskenya.ke.co.bpsapp.apiClients.LoadParcelInterface;
import bpskenya.ke.co.bpsapp.apiClients.LoginInterface;
import bpskenya.ke.co.bpsapp.models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    EditText email;
    SharedPreferences.Editor sharedPrefrencesEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //check if user is signed in
        email=(EditText)findViewById(R.id.email);


        sharedPreferences=getSharedPreferences("bps", Context.MODE_PRIVATE);

        email.setText(sharedPreferences.getString("email",""));
       String password=sharedPreferences.getString("password","");
        int userid=sharedPreferences.getInt("id",0);
        if (userid>0){
            startActivity(new Intent(this,MainActivity.class));
        }



    }
    public void LoginBtn(View view){

        EditText emailField=(EditText)findViewById(R.id.email);
        EditText passwordField=(EditText)findViewById(R.id.password);
        String email=emailField.getText().toString();
        String password=passwordField.getText().toString();
        sharedPreferences=getSharedPreferences("bps",Context.MODE_PRIVATE);
        sharedPrefrencesEditor=sharedPreferences.edit();
        sharedPrefrencesEditor.putString("email",email).commit();

       if (email.equals("")||password.equals("")){
           TextView response=(TextView)findViewById(R.id.response);
           response.setText("Fill in all fields");
       }else{
           login(email,password);
       }

       // startActivity(new Intent(this,MainActivity.class));
    }
    public void login(String email,String password){
        LoginInterface loginInterface= AppAPIClient.getApiClient().create(LoginInterface.class);
        Call<User> userCall=loginInterface.loginUser(email,password);
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user=response.body();
                sharedPreferences=getSharedPreferences("bps",Context.MODE_PRIVATE);
                sharedPrefrencesEditor=sharedPreferences.edit();
                sharedPrefrencesEditor.putInt("id",user.id).commit();
                sharedPrefrencesEditor.putString("email",user.email).commit();

                startActivity(new Intent(getApplicationContext(),MainActivity.class));

                Toast.makeText(getApplicationContext(),"Welcome "+user.email.toString(),Toast.LENGTH_SHORT).show();

            }


            @Override
            public void onFailure(Call<User> call, Throwable t) {
              TextView response=(TextView)findViewById(R.id.response);
              response.setText("Invalid Credentials");

            }
        });

    }

}
