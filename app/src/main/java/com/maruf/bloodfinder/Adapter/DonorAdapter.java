package com.maruf.bloodfinder.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.maruf.bloodfinder.Model.Donor;
import com.maruf.bloodfinder.R;

import java.util.List;

public class DonorAdapter extends RecyclerView.Adapter<DonorAdapter.DonorViewHolder> {

    private OnDonorItemClickedListener onDonorItemClickedListener;

    private List<Donor> donorList;
    private Context context;



    public DonorAdapter(Context context, List<Donor> donorList,
                        OnDonorItemClickedListener onDonorItemClickedListener) {
        this.donorList = donorList;
        this.context = context;
        this.onDonorItemClickedListener = onDonorItemClickedListener;

    }

    @NonNull
    @Override
    public DonorViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View donorView = LayoutInflater.from(context).inflate(R.layout.donor_item, viewGroup, false);

        return new DonorViewHolder(donorView, onDonorItemClickedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull DonorViewHolder holder, int i) {


        holder.nameTV.setText(donorList.get(i).getName());
        holder.bgTV.setText("Blood Group: " +donorList.get(i).getBloodGroup());
        holder.genderTV.setText("Gender: " +donorList.get(i).getGender());
        holder.addressTV.setText("Address: "+donorList.get(i).getAddress());
        holder.statusTV.setText("Status: " +donorList.get(i).getStatus());



    }

    @Override
    public int getItemCount() {
        return donorList.size();
    }

    class DonorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        OnDonorItemClickedListener onDonorItemClickedListener;

        TextView nameTV, bgTV, genderTV, addressTV, statusTV;

        public DonorViewHolder(@NonNull View itemView,
                               OnDonorItemClickedListener onDonorItemClickedListener) {
            super(itemView);

            nameTV = itemView.findViewById(R.id.donor_item_name);
            bgTV = itemView.findViewById(R.id.donor_item_bg);
            genderTV = itemView.findViewById(R.id.donor_item_gender);
            addressTV = itemView.findViewById(R.id.donor_item_address);
            statusTV = itemView.findViewById(R.id.donor_item_status);

            this.onDonorItemClickedListener = onDonorItemClickedListener;

            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {

            onDonorItemClickedListener.onDonorItemClicked(donorList.get(getAdapterPosition()).getId());

        }
    }

    public interface OnDonorItemClickedListener{
        void onDonorItemClicked(int donorID);
    }



}


