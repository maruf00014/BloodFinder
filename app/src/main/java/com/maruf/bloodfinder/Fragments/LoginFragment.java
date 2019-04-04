package com.maruf.bloodfinder.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.maruf.bloodfinder.Database.DataSource;
import com.maruf.bloodfinder.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    LoginFragmentInterface loginFragmentInterface;

    String email, password;

    EditText emailET, passwordET;
    Button loginBtn;
    TextView signUpNowTV;

    DataSource dataSource;



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        loginFragmentInterface = (LoginFragmentInterface) context;

        dataSource = new DataSource(context);
    }


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        emailET = view.findViewById(R.id.login_email_et);
        passwordET = view.findViewById(R.id.login_pass_et);
        loginBtn = view.findViewById(R.id.login_btn);
        signUpNowTV = view.findViewById(R.id.sign_up_now_tv);

        signUpNowTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginFragmentInterface.onSignUpNowTextClicked();
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = emailET.getText().toString();
                password = passwordET.getText().toString();




                int donorID = dataSource.getDonorIDByEmailPass(email,password);

                if(donorID > 0 ){

                    loginFragmentInterface.onSignINButtonClickd(donorID);

                }else Toast.makeText(getActivity(),"Failed to login",Toast.LENGTH_SHORT).show();

            }

        });





    }

    public interface LoginFragmentInterface{
        void onSignUpNowTextClicked();
        void onSignINButtonClickd(int donorID);
    }
}
