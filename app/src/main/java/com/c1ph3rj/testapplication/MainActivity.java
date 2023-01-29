package com.c1ph3rj.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.card.MaterialCardView;


public class MainActivity extends AppCompatActivity {
    // Declaring the required variables.
    ShimmerFrameLayout loadingCardView;
    MaterialCardView layoutForCardView;

    // onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(MainActivity.this, mainActivityLottie.class));

        // Method for initialization.
        init();
    }// End Of OnCreate().

    // Method to initialize the layout fields and functionalities.
    void init(){
        try {
            // Layout for the data
            layoutForCardView = findViewById(R.id.layoutForCardView);
            // Layout for loading animation (Shimmer effect)
            loadingCardView = findViewById(R.id.shimmer_loading);

            // hiding the default layout until the data has been fetched.
            layoutForCardView.setVisibility(View.GONE);

            // Method to start the loading animation.
            loadingAnimFunc();
        }catch (Exception e){
            e.printStackTrace();
        }
    }// End of Init().

    // Method to start the loading animation and simulate the loading time.
    private void loadingAnimFunc() {
        try{
            // To start the loading animation.
            loadingCardView.startShimmer();

            // To Simulate the delay of data fetching time,
            // I have used an Handler with post delay of 2 seconds
            new Handler().postDelayed(() -> runOnUiThread(() -> {
                // After the data has been fetched we need to stop the loading animation.
                loadingCardView.stopShimmer();
                // We need to hide the loading animation for the better UI.
                loadingCardView.setVisibility(View.GONE);
                // After the details fetched we need to make visible the real layout
                // where the data is going to be bind.
                layoutForCardView.setVisibility(View.VISIBLE);
            }),3000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }// End Of loadingAnimFunc().

    @Override
    protected void onRestart() {
        super.onRestart();
        loadingAnimFunc();
    }
}// End Of MainActivity Class