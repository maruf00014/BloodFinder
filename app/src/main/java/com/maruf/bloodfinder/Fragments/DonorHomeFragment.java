package com.maruf.bloodfinder.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maruf.bloodfinder.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DonorHomeFragment extends Fragment {
    int donorID;

    DonorHomeFragmentInterface donorHomeFragmentInterface;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        donorHomeFragmentInterface = (DonorHomeFragmentInterface) context;
    }

    public DonorHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donor_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        donorID = getArguments().getInt("donorID");

        CardView myAccountCV, bloodrequestCV;
        myAccountCV = view.findViewById(R.id.my_account_cv);
        bloodrequestCV = view.findViewById(R.id.blood_request_cv);

        myAccountCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                donorHomeFragmentInterface.onDonorHomeCardClicked(0,donorID);

            }
        });

        bloodrequestCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                donorHomeFragmentInterface.onDonorHomeCardClicked(1,donorID);

            }
        });


    }

    public  interface DonorHomeFragmentInterface{

        void onDonorHomeCardClicked(int card, int donorID);

    }
}
