package bpskenya.ke.co.bpsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class RecieveParcels extends AppCompatActivity {

    RecyclerAdapter adapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve_parcels);

        Toolbar toolbar=(Toolbar)findViewById(R.id.recieveParcelToolbar);
        toolbar.setTitle("Recieve");

        setSupportActionBar(toolbar);

        adapter=new RecyclerAdapter();
        layoutManager=new LinearLayoutManager(this);
        recyclerView=(RecyclerView)findViewById(R.id.recieveParcelRecyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recieve_parcel_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
