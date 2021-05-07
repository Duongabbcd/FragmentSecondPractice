package com.example.fragmentsecondpractice;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  void addA(View v){
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        transaction.add(R.id.frame,fragmentA,"fragA");
        transaction.addToBackStack("PopA");
        transaction.commit();
    }

    public  void addB(View v){
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        transaction.add(R.id.frame,fragmentB,"fragB");
        transaction.addToBackStack(null) ;
        transaction.commit();
    }

    public  void addC(View v){
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        FragmentC fragmentC = new FragmentC();
        transaction.add(R.id.frame,fragmentC,"fragC");
        transaction.addToBackStack(null) ;
        transaction.commit();
    }

    public void Back(View v){

        getSupportFragmentManager().popBackStack();
    }

    public void removeA(View v){
        FragmentTransaction transaction = manager.beginTransaction();
        FragmentA fragmentA =(FragmentA) getSupportFragmentManager().findFragmentByTag("fragA");
        transaction.remove(fragmentA);
        transaction.commit();

    }

    public void removeB(View v){
        FragmentTransaction transaction = manager.beginTransaction();
        FragmentB fragmentB =(FragmentB) getSupportFragmentManager().findFragmentByTag("fragB");
        transaction.remove(fragmentB);
        transaction.commit();

    }

    public void removeC(View v){
        FragmentTransaction transaction = manager.beginTransaction();
        FragmentC fragmentC =(FragmentC) getSupportFragmentManager().findFragmentByTag("fragC");
        transaction.remove(fragmentC);
        transaction.commit();

    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount()>0){
            getSupportFragmentManager().popBackStack();
        }else
            super.onBackPressed();
    }

    public void PopA (View v) {
        getSupportFragmentManager().popBackStack("PopA",0);
    }
}