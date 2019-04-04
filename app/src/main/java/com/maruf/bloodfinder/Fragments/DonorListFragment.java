package com.maruf.bloodfinder.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.maruf.bloodfinder.Adapter.DonorAdapter;
import com.maruf.bloodfinder.Database.DataSource;
import com.maruf.bloodfinder.Model.Donor;
import com.maruf.bloodfinder.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DonorListFragment extends Fragment implements DonorAdapter.OnDonorItemClickedListener {
    DonorListFragmentInterface donorListFragmentInterface;

    List<Donor> donorList;
    RecyclerView recyclerView;
    DonorAdapter donorAdapter;
    DataSource dataSource;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        donorListFragmentInterface = (DonorListFragmentInterface) context;
        dataSource = new DataSource(context);
    }

    public DonorListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donor_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        ArrayList<String> searchItems = getArguments().getStringArrayList("searchItems");
        donorList = new ArrayList<>();
        donorList = dataSource.searchDonor(searchItems.get(0),searchItems.get(1),searchItems.get(2));

        recyclerView = view.findViewById(R.id.donor_list_recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);



        donorAdapter = new DonorAdapter(getActivity(), donorList,this );

        recyclerView.setAdapter(donorAdapter);


    }


    @Override
    public void onDonorItemClicked(int donorID) {

        donorListFragmentInterface.onDonorIdGet(donorID);

    }

    public interface DonorListFragmentInterface{
        void onDonorIdGet(int donorID);
    }
}
