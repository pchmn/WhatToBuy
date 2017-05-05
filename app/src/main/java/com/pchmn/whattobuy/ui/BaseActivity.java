package com.pchmn.whattobuy.ui;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    /**
     * Go to an activity by using an intent
     *
     * @param intent the intent
     * @param addToBackStack the boolean to add current activity to the stack or not
     */
    public void goToActivity(Intent intent, boolean addToBackStack) {
        startActivity(intent);
        if(!addToBackStack)
            finish();
    }

    /**
     * Go to an activity by using an intent and clear the stack
     *
     * @param intent the intent
     */
    public void goToActivityAndClearStack(Intent intent) {
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    /**
     * Delete all fragments of back stack
     */
    public void deleteBackStack() {
        FragmentManager fm = getSupportFragmentManager();
        for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }
    }

    /**
     * Delete last fragment of back stack
     */
    public void popBackStack() {
        FragmentManager fm = getSupportFragmentManager();
        fm.popBackStack();
    }

    /**
     * Test if location permission is granted
     *
     * @return true if it is granted, false if it is not
     */
    public boolean isLocationPermissionGranted() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return false;
        }
        return true;
    }

    /**
     * Check if user has internet connection
     *
     * @return true if he has, false either
     */
    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnected();
    }
}
