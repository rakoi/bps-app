package bpskenya.ke.co.bpsapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import bpskenya.ke.co.bpsapp.models.Parcel;



public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    ArrayList<Parcel> parcels;
    public RecyclerAdapter(ArrayList<Parcel> parcels) {

      this.parcels=parcels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.parcel_ticket,parent,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        try {
            String town="To :" +parcels.get(position).getReciever().getTown();
            String weight=String.valueOf(parcels.get(position).getWeight());
            holder.to.setText(town);
            holder.from.setText("From :"+parcels.get(position).getSender().getTown());
            holder.sender.setText("Sender :"+parcels.get(position).getSender().getPhone());
            holder.reciever.setText("Consignee :"+parcels.get(position).getReciever().getPhone());
            holder.weight.setText(weight);
            holder.price.setText(String.valueOf(parcels.get(position).getPrice()));
        }catch (Exception e){

        }

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
        public TextView price;

        public ViewHolder(View itemView) {
            super(itemView);
            to=(TextView)itemView.findViewById(R.id.parcelDestination);
            from=(TextView)itemView.findViewById(R.id.parcelTown);
            weight=(TextView)itemView.findViewById(R.id.ParcelWeight);
            sender=(TextView)itemView.findViewById(R.id.parcelSender);
            reciever=(TextView)itemView.findViewById(R.id.ParcelReciever);
            price=(TextView)itemView.findViewById(R.id.parcelPrice);

        }


    }
}
