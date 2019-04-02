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

import com.maruf.bloodfinder.Database.DataSource;
import com.maruf.bloodfinder.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {



    CardView donorCardView, findDonorCardView;
    HomeFragmentInterface homeFragmentInterface;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        homeFragmentInterface = (HomeFragmentInterface) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        donorCardView = view.findViewById(R.id.donor_cardview);
        findDonorCardView = view.findViewById(R.id.find_donor_cardview);


        donorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeFragmentInterface.onCardClicked(0);

            }
        });

        findDonorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                homeFragmentInterface.onCardClicked(1);

            }
        });


    }

  public  interface HomeFragmentInterface{

        void onCardClicked(int cardView);
    }

}

