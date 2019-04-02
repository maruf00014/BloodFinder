package com.maruf.bloodfinder.Fragments;


import android.content.Context;
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
import android.widget.Toast;

import com.maruf.bloodfinder.Database.DataSource;
import com.maruf.bloodfinder.Model.Donor;
import com.maruf.bloodfinder.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DonorAccountFragment extends Fragment {
    DonorAccountFragmentInterface donorAccountFragmentInterface;
    DataSource dataSource;
    Donor donor;
    public DonorAccountFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        donorAccountFragmentInterface = (DonorAccountFragmentInterface) context;
        dataSource = new DataSource(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donor_account, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        donor = dataSource.getDonorDetailByID(getArguments().getInt("donorID"));

       // donor = new Donor(10,"rakib Hasan","B+","Male","100011","rakib@gmail.com","Savar, Dhaka","Available","123");
        TextView nameTV, bgTV, genderTV, phoneTV, emailTV, addressTV, statusTV;

        Button editBtn, deleteBtn;


        nameTV = view.findViewById(R.id.donor_ac_name);
        bgTV = view.findViewById(R.id.donor_ac_bd);
        genderTV = view.findViewById(R.id.donor_ac_gender);
        phoneTV = view.findViewById(R.id.donor_ac_phone);
        emailTV = view.findViewById(R.id.donor_ac_email);
        addressTV = view.findViewById(R.id.donor_ac_address);
        statusTV = view.findViewById(R.id.donor_ac_status);

        editBtn = view.findViewById(R.id.account_edit_btn);
        deleteBtn = view.findViewById(R.id.account_delete_btn);


        nameTV.setText(donor.getName());
        bgTV.setText("Blood Group: " +donor.getBloodGroup() );
        genderTV.setText("Gender: " +donor.getGender() );
        phoneTV.setText("Phone: " +donor.getPhone() );
        emailTV.setText("Email: " +donor.getEmail() );
        addressTV.setText("Address: " +donor.getAddress() );
        statusTV.setText("Status: " +donor.getStatus() );

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            donorAccountFragmentInterface.onEditAccountButtonClicked(donor.getId());

            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int deletedRow = dataSource.deleteDonor(donor.getId());

                if(deletedRow > 0){

                    Toast.makeText(getActivity(),"Successfully Deleted",Toast.LENGTH_SHORT).show();
                    donorAccountFragmentInterface.onDeleteAccountButtonClicked();

                }else Toast.makeText(getActivity(),"Failed to Delete",Toast.LENGTH_SHORT).show();


            }
        });




    }

    public interface DonorAccountFragmentInterface{
        void onEditAccountButtonClicked(int donorID);
        void onDeleteAccountButtonClicked();
    }
}
