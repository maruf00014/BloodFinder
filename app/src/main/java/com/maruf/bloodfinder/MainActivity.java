package com.maruf.bloodfinder;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.maruf.bloodfinder.Adapter.DonorAdapter;
import com.maruf.bloodfinder.Fragments.BloodRequestFragment;
import com.maruf.bloodfinder.Fragments.DonorAccountEditFragment;
import com.maruf.bloodfinder.Fragments.DonorAccountFragment;
import com.maruf.bloodfinder.Fragments.DonorDetailsFragment;
import com.maruf.bloodfinder.Fragments.DonorHomeFragment;
import com.maruf.bloodfinder.Fragments.DonorListFragment;
import com.maruf.bloodfinder.Fragments.DonorSearchFragment;
import com.maruf.bloodfinder.Fragments.HomeFragment;
import com.maruf.bloodfinder.Fragments.LoginFragment;
import com.maruf.bloodfinder.Fragments.RegistrationFragment;
import com.maruf.bloodfinder.Model.Donor;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements HomeFragment.HomeFragmentInterface
    , DonorSearchFragment.DonorSearchFragmentInterface
        , DonorListFragment.DonorListFragmentInterface
, LoginFragment.LoginFragmentInterface
, RegistrationFragment.RegistrationFragmentInterface
, DonorHomeFragment.DonorHomeFragmentInterface
,DonorAccountFragment.DonorAccountFragmentInterface
,DonorAccountEditFragment.DonorAccountEditFragmentInterface{

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       fragmentManager = getSupportFragmentManager();

        FragmentTransaction ft = fragmentManager.beginTransaction();

        HomeFragment homeFragment = new HomeFragment();

        ft.add(R.id.fragmentContainer, homeFragment);
        ft.commit();
    }

    @Override
    public void onCardClicked(int cardView) {

        switch (cardView){

            case 0:

                FragmentTransaction ft1 = fragmentManager.beginTransaction();

                LoginFragment loginFragment = new LoginFragment();

                ft1.replace(R.id.fragmentContainer, loginFragment);
                ft1.addToBackStack(null);
                ft1.commit();

                break;

            case 1:

                FragmentTransaction ft2 = fragmentManager.beginTransaction();

                DonorSearchFragment donorSearchFragment = new DonorSearchFragment();

                ft2.replace(R.id.fragmentContainer, donorSearchFragment);
                ft2.addToBackStack(null);
                ft2.commit();

                break;


        }

    }

    @Override
    public void onSearchButtonClicked(ArrayList<String> searchItems) {

        FragmentTransaction ft = fragmentManager.beginTransaction();

        DonorListFragment donorListFragment = new DonorListFragment();
        Bundle searchItemsBundle = new Bundle();
        searchItemsBundle.putStringArrayList("searchItems",searchItems);
        donorListFragment.setArguments(searchItemsBundle);
        ft.replace(R.id.fragmentContainer, donorListFragment);
        ft.addToBackStack(null);
        ft.commit();

    }


    @Override
    public void onDonorIdGet(int donorID) {

        FragmentTransaction ft = fragmentManager.beginTransaction();

        DonorDetailsFragment donorDetailsFragment = new DonorDetailsFragment();
        Bundle searchItemsBundle = new Bundle();
        searchItemsBundle.putInt("donorID",donorID);
        donorDetailsFragment.setArguments(searchItemsBundle);
        ft.replace(R.id.fragmentContainer, donorDetailsFragment);
        ft.addToBackStack(null);
        ft.commit();

    }

    @Override
    public void onSignUpNowTextClicked() {

        FragmentTransaction ft = fragmentManager.beginTransaction();
        RegistrationFragment registrationFragment = new RegistrationFragment();
        ft.replace(R.id.fragmentContainer, registrationFragment);
        ft.addToBackStack(null);
        ft.commit();


    }

    @Override
    public void onSignINButtonClickd(int donorID) {

        FragmentTransaction ft = fragmentManager.beginTransaction();

        DonorHomeFragment donorHomeFragment = new DonorHomeFragment();
        Bundle searchItemsBundle = new Bundle();
        searchItemsBundle.putInt("donorID",donorID);
        donorHomeFragment.setArguments(searchItemsBundle);
        ft.replace(R.id.fragmentContainer, donorHomeFragment);
        ft.addToBackStack(null);
        ft.commit();

    }


    @Override
    public void onLogInNowTextClicked() {

        FragmentTransaction ft = fragmentManager.beginTransaction();
        LoginFragment loginFragment = new LoginFragment();
        ft.replace(R.id.fragmentContainer, loginFragment);
        ft.addToBackStack(null);
        ft.commit();


    }

    @Override
    public void onSignUpButtonClicked(int donorID) {

        FragmentTransaction ft = fragmentManager.beginTransaction();

        DonorHomeFragment donorHomeFragment = new DonorHomeFragment();
        Bundle searchItemsBundle = new Bundle();
        searchItemsBundle.putInt("donorID",donorID);
        donorHomeFragment.setArguments(searchItemsBundle);
        ft.replace(R.id.fragmentContainer, donorHomeFragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onDonorHomeCardClicked(int card, int donorID) {

        switch (card){

            case 0:

                FragmentTransaction ft1 = fragmentManager.beginTransaction();

                DonorAccountFragment donorAccountFragment = new DonorAccountFragment();
                Bundle bundle1 = new Bundle();
                bundle1.putInt("donorID",donorID);
                donorAccountFragment.setArguments(bundle1);
                ft1.replace(R.id.fragmentContainer, donorAccountFragment);
                ft1.addToBackStack(null);
                ft1.commit();

                break;

            case 1:

                FragmentTransaction ft2 = fragmentManager.beginTransaction();

                BloodRequestFragment bloodRequestFragment = new BloodRequestFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("donorID",donorID);
                bloodRequestFragment.setArguments(bundle2);
                ft2.replace(R.id.fragmentContainer, bloodRequestFragment);
                ft2.addToBackStack(null);
                ft2.commit();

                break;


        }

    }

    @Override
    public void onEditAccountButtonClicked(int donorID) {
        FragmentTransaction ft2 = fragmentManager.beginTransaction();

        DonorAccountEditFragment donorAccountEditFragment = new DonorAccountEditFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("donorID",donorID);
        donorAccountEditFragment.setArguments(bundle);
        ft2.replace(R.id.fragmentContainer, donorAccountEditFragment);
        ft2.addToBackStack(null);
        ft2.commit();


    }

    @Override
    public void onDeleteAccountButtonClicked() {
        FragmentTransaction ft2 = fragmentManager.beginTransaction();

        HomeFragment homeFragment = new HomeFragment();
        ft2.replace(R.id.fragmentContainer, homeFragment);
        ft2.addToBackStack(null);
        ft2.commit();

    }

    @Override
    public void OnEditSubmitButtonClicked(int donorID) {
        FragmentTransaction ft1 = fragmentManager.beginTransaction();

        DonorAccountFragment donorAccountFragment = new DonorAccountFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putInt("donorID",donorID);
        donorAccountFragment.setArguments(bundle1);
        ft1.replace(R.id.fragmentContainer, donorAccountFragment);
        ft1.addToBackStack(null);
        ft1.commit();
    }
}
