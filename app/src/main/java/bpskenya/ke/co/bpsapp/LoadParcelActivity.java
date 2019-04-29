package bpskenya.ke.co.bpsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import java.util.ArrayList;

public class LoadParcelActivity extends AppCompatActivity {

    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapter adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_parcel);

        Toolbar toolbar=(Toolbar)findViewById(R.id.loadParcelToolbar);
        toolbar.setTitle("Load Parcels");

        setSupportActionBar(toolbar);


        recyclerView=(RecyclerView)findViewById(R.id.loadParcelRecyclerView);
        layoutManager=new LinearLayoutManager(this);
        adapter=new RecyclerAdapter();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.load_parcels_menu,menu);
        return true;
    }


}
