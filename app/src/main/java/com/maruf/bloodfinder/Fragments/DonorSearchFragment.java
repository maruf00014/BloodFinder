package com.maruf.bloodfinder.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.maruf.bloodfinder.Database.DataSource;
import com.maruf.bloodfinder.Model.Donor;
import com.maruf.bloodfinder.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DonorSearchFragment extends Fragment {

    String bg, gender, dis, subDis;
    DonorSearchFragmentInterface donorSearchFragmentInterface;

    public DonorSearchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        donorSearchFragmentInterface = (DonorSearchFragmentInterface) context;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donor_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final Spinner bgSpinner = view.findViewById(R.id.search_bg_spinner);
        final Spinner disSpinner = view.findViewById(R.id.search_dis_spinner);
        final Spinner subDisSpinner = view.findViewById(R.id.search_sub_dis_spinner);

        final RadioGroup genRadioGroup = view.findViewById(R.id.search_gen_radio);

        Button searchButton = view.findViewById(R.id.search_btn);


        ArrayAdapter<String> bgSpinnerAdapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.blood_group));

        ArrayAdapter<String> disSpinnerAdapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.district));


        bgSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        disSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



        bgSpinner.setAdapter(bgSpinnerAdapter);
        disSpinner.setAdapter(disSpinnerAdapter);


        bgSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bg = bgSpinner.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        disSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dis = disSpinner.getSelectedItem().toString();


                ArrayAdapter<String> subDisSpinnerAdapter;

                String[] subDistrictArray = null;

                switch (position){

                    case 1:
                        subDistrictArray = getResources().getStringArray(R.array.sub_district_dhaka);
                        break;

                    case 2:
                        subDistrictArray = getResources().getStringArray(R.array.sub_district_narayanganj);
                        break;

                    case 3:
                        subDistrictArray = getResources().getStringArray(R.array.sub_district_comilla);
                        break;

                    case 4:
                        subDistrictArray = getResources().getStringArray(R.array.sub_district_gazipur);
                        break;

                    default:
                        subDistrictArray = getResources().getStringArray(R.array.sub_district_empty);
                        break;


                }
                if(subDisSpinner != null) {
                    subDisSpinnerAdapter = new ArrayAdapter<>(getContext(),
                            android.R.layout.simple_spinner_item,
                            subDistrictArray);

                    subDisSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subDisSpinner.setAdapter(subDisSpinnerAdapter);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        subDisSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                subDis = subDisSpinner.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        RadioButton radioButton =  genRadioGroup.findViewById(genRadioGroup.getCheckedRadioButtonId());
        gender = radioButton.getText().toString();


        genRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton =  genRadioGroup.findViewById(genRadioGroup.getCheckedRadioButtonId());
                gender = radioButton.getText().toString();


            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String address = subDis+", "+dis;

            ArrayList<String> searchItem = new ArrayList<>();
            searchItem.add(bg);
            searchItem.add(gender);
            searchItem.add(address);
            donorSearchFragmentInterface.onSearchButtonClicked(searchItem);

            }
        });

    }

    public interface DonorSearchFragmentInterface{

        void onSearchButtonClicked(ArrayList<String> searchItem);
    }
}
