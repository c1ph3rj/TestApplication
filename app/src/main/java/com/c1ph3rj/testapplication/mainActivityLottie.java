package com.c1ph3rj.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.card.MaterialCardView;

public class mainActivityLottie extends AppCompatActivity {
    LottieAnimationView loadingAnim;
    MaterialCardView layoutForCardView;

    // OnCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitity_lottie);

        // To initialize the variables and layouts.
        init();
    }// End of OnCreate().

    // Method to initialize the layouts and animations.
    void init(){
        try{
            // Variable - lottie animations.
            loadingAnim = findViewById(R.id.lottieAnimCardView);
            // Variable - cardView holds the real data.
            layoutForCardView = findViewById(R.id.layoutForCardView);

            // To start the animation and simulate the data fetch.
            startLoadingAnim();
        }catch(Exception e){
            e.printStackTrace();
        }
    }// End of Init().

    // Method to simulate the loading effect.
    private void startLoadingAnim() {
        try{
            // Hide the real layout until the data is fetched.
            layoutForCardView.setVisibility(View.GONE);

            // Starting the lottie animation.
            loadingAnim.playAnimation();

            // Handler to simulate the fetching time of the data,
            new Handler().postDelayed(() -> runOnUiThread(() -> {
                // After the data fetched change the visibility for the real layout.
                layoutForCardView.setVisibility(View.VISIBLE);
                // Stop the lottie animations.
                loadingAnim.cancelAnimation();
                // Hide the lottie animations.
                loadingAnim.setVisibility(View.GONE);
            }), 4000);
        }catch(Exception e){
            e.printStackTrace();
        }
    }// End of the startLoadingAnim().
}// End of the mainActivityLottie Class