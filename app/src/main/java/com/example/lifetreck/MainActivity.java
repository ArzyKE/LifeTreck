package com.example.lifetreck;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

public class MainActivity extends AppCompatActivity {
    NavController navController;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
        }
        preferences = getSharedPreferences("board_file", Context.MODE_PRIVATE);
        boolean isShow = preferences.getBoolean("isShow", false);
        preferences = getSharedPreferences("registration", Context.MODE_PRIVATE);
        boolean isShowRegistration = preferences.getBoolean("isShowRegistr", false);
        if (!isShow && !isShowRegistration) {
            navController.navigate(R.id.onBoardFragment);
        } else {
            navController.navigate(R.id.taskFragment);
        }
    }
}
