package bpskenya.ke.co.bpsapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import bpskenya.ke.co.bpsapp.models.Parcels;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    ArrayList<Parcels> parcels=new ArrayList<>();

    public RecyclerAdapter() {
        for (int i=0;i<=10;i++){
            parcels.add(new Parcels(i,"Nairobi","Meru","+254702164611","+25439898180","Random",10));
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.parcel_ticket,parent,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.to.setText("To: "+parcels.get(position).to);
        holder.from.setText("From :"+parcels.get(position).from);
        holder.sender.setText("Sender :"+parcels.get(position).sender);
        holder.reciever.setText("Consignee :"+parcels.get(position).reciever);
        holder.weight.setText(String.valueOf(parcels.get(position).weight));
        }

    @Override
    public int getItemCount() {
        return parcels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView to;
        public TextView from;
        public TextView weight;
        public TextView sender;
        public TextView reciever;

        public ViewHolder(View itemView) {
            super(itemView);
            to=(TextView)itemView.findViewById(R.id.parcelDestination);
            from=(TextView)itemView.findViewById(R.id.parcelTown);
            weight=(TextView)itemView.findViewById(R.id.ParcelWeight);
            sender=(TextView)itemView.findViewById(R.id.parcelSender);
            reciever=(TextView)itemView.findViewById(R.id.ParcelReciever);


        }


    }
}
