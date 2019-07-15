package com.route.islamiappgfri;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.MenuItem;

import com.route.islamiappgfri.API.APIManager;
import com.route.islamiappgfri.API.Model.RadioChannelsResponse;
import com.route.islamiappgfri.Base.BaseActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends BaseActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment=null;
            switch (item.getItemId()) {
                case R.id.navigation_quran:{
                    fragment= new QuranFragment();
                    break;
                }
                case R.id.navigation_sebha:{
                    fragment=new SebhaFragment();
                    break;
                }
                case R.id.navigation_hadeth:{
                    fragment=new HadethFragment();
                    break;
                } case R.id.navigation_radio:{
                    fragment=new RadioFragment();
                    break;
                }
            }

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();




            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_quran);

        }

}
