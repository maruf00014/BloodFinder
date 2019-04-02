package com.maruf.bloodfinder.Fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.maruf.bloodfinder.Database.DataSource;
import com.maruf.bloodfinder.Model.Donor;
import com.maruf.bloodfinder.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DonorDetailsFragment extends Fragment {

    DataSource dataSource;
    Donor donor;

    public DonorDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donor_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        //donor = dataSource.getDonorDetailByID(getArguments().getInt("donorID"));

        //donor = new Donor(2,"nnnn","nnnn","nnnn","111","nnnn","nnnn","nnnn","nnnn");
        TextView nameTV, bgTV, genderTV, phoneTV, emailTV, addressTV, statusTV;
donor = new Donor(10,"Kamal Hasan","O+","Male",
        "123456","kamal@gmail.com","Dhaka, Tejgaon","Available","Action");


        ImageView callBtn, smsBtn, emailBtn, bloodRqstBtn;

        nameTV = view.findViewById(R.id.donor_detail_item_name);
        bgTV = view.findViewById(R.id.donor_detail_item_bg);
        genderTV = view.findViewById(R.id.donor_detail_item_gender);
        phoneTV = view.findViewById(R.id.donor_detail_item_phone);
        emailTV = view.findViewById(R.id.donor_detail_item_email);
        addressTV = view.findViewById(R.id.donor_detail_item_address);
        statusTV = view.findViewById(R.id.donor_detail_item_status);

        callBtn = view.findViewById(R.id.donor_detail_call);
        smsBtn = view.findViewById(R.id.donor_detail_sms);
        emailBtn = view.findViewById(R.id.donor_detail_email);
        bloodRqstBtn = view.findViewById(R.id.donor_detail_blood_request);

        nameTV.setText(donor.getName());
        bgTV.setText("Blood Group: " +donor.getBloodGroup());
        genderTV.setText("Gender: " +donor.getGender());
        phoneTV.setText("Phone: " +donor.getPhone());
        emailTV.setText("Email: " +donor.getEmail());
        addressTV.setText("Address: " +donor.getAddress());
        statusTV.setText("Status: " +donor.getStatus());

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+donor.getPhone()));
                getActivity().startActivity(intent);

            }
        });

        smsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+donor.getPhone()));
                getActivity().startActivity(intent);

            }
        });

        emailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"+donor.getEmail()));
                getActivity().startActivity(intent);

            }
        });

        bloodRqstBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
