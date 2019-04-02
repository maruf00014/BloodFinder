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
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.maruf.bloodfinder.Database.DataSource;
import com.maruf.bloodfinder.Model.Donor;
import com.maruf.bloodfinder.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DonorAccountEditFragment extends Fragment {
    DataSource dataSource;
    DonorAccountEditFragmentInterface donorAccountEditFragmentInterface;
    String name, bg, gender, email, phone, subDis, dis, status,password, repassword;
    int donorID;

    public DonorAccountEditFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dataSource = new DataSource(context);
        donorAccountEditFragmentInterface = (DonorAccountEditFragmentInterface) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donor_account_edit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final EditText nameET, emailET,phoneET, passwordET, rePasswordET;
        Button editSubmitBtn;
        donorID = getArguments().getInt("donorID");
        nameET = view.findViewById(R.id.reg_name_et);
        emailET = view.findViewById(R.id.reg_email_et);
        phoneET = view.findViewById(R.id.reg_phone_et);
        passwordET = view.findViewById(R.id.reg_pass_et);
        rePasswordET = view.findViewById(R.id.reg_repass_et);

        final Spinner bgSpinner = view.findViewById(R.id.reg_bg_spinner);
        final Spinner disSpinner = view.findViewById(R.id.reg_dis_spinner);
        final Spinner subDisSpinner = view.findViewById(R.id.reg_sub_dis_spinner);

        editSubmitBtn = view.findViewById(R.id.signup_btn);

        RadioGroup genRadioGroup = view.findViewById(R.id.reg_gen_radio);
        RadioGroup statusRadioGroup = view.findViewById(R.id.reg_status_radio);

        genRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton =  group.findViewById(group.getCheckedRadioButtonId());
                gender = radioButton.getText().toString();


            }
        });

        RadioButton stsradioButton =  statusRadioGroup.findViewById(statusRadioGroup.getCheckedRadioButtonId());
        status = stsradioButton.getText().toString();


        statusRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton =  group.findViewById(group.getCheckedRadioButtonId());
                status = radioButton.getText().toString();


            }
        });


        final ArrayAdapter<String> bgSpinnerAdapter = new ArrayAdapter<>(getContext(),
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

        editSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameET.getText().toString();
                email = emailET.getText().toString();
                phone = phoneET.getText().toString();
                password = passwordET.getText().toString();
                repassword = rePasswordET.getText().toString();

                //Toast.makeText(getActivity(),email,Toast.LENGTH_SHORT).show();

                String address = subDis+", "+dis;
                long insertedRow = dataSource.updateDonor(new Donor(donorID,name,bg,gender,phone,email,address,status,password));

                if(insertedRow > 0 ){
                    Toast.makeText(getActivity(),"Edit Successfull",Toast.LENGTH_SHORT).show();
                    donorAccountEditFragmentInterface.OnEditSubmitButtonClicked(donorID);

                }
                else Toast.makeText(getActivity(),"Edit Failed",Toast.LENGTH_SHORT).show();


            }
        });

    }

    public interface DonorAccountEditFragmentInterface{
        void OnEditSubmitButtonClicked(int donorID);
    }
}
