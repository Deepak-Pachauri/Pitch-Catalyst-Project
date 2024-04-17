package com.example.comp_assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity
{

    Home home;
    Message message;
    Profile profile;
    Shop shop;


    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Home home = new Home();
        Shop shop = new Shop();
        Message message = new Message();
        Profile profile = new Profile();

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Comp_Assignment");

        bottomNavigationView = findViewById(R.id.bottombar);


        getSupportFragmentManager().beginTransaction().add(R.id.framlayout, home).commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottombar);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getTitle().equals("Home"))
                    setfragment(home);
                else if(item.getTitle().equals("Shop"))
                    setfragment(shop);
                else if(item.getTitle().equals("Profile"))
                    setfragment(profile);
                return false;
            }
        });
    }
    public void setfragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framlayout,fragment);
        fragmentTransaction.commit();
    }
    public void Calender(View view)
    {

    }
}
