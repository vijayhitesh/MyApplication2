package com.example.myapplication.login.presenter;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.myapplication.R;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class BaseActivity extends AppCompatActivity implements BaseInterface {

    //protected boolean checkInternetConnection;
    private ProgressBar mProgressBar;
    public RelativeLayout rl_layout;
    private static final int MY_PERMISION_CODE = 10;

    private BaseInterface mBaseInterface;

    BaseActivity(BaseInterface view){
        mBaseInterface = view;
    }





    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        rl_layout  = (RelativeLayout) findViewById(R.id.rl_layout);
    }

    public BaseActivity(Context context) {
    }

    public boolean checkInternetConnection(Boolean connectionState){

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected()){

            Log.d("Network State", "Network Connected to the internet");
            return true;
        }else {
            Log.d("Network State", "Network Connected to the internet");
            return false;
        }
    }

    public void showToastMessage (Context context,String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();

    }


    public void showAlert() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Enable Location")
                .setMessage("Your Locations Settings are OFF \nPlease Enable Location")
                .setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {


                        ActivityCompat.requestPermissions(BaseActivity.this,
                                new String[]{ACCESS_COARSE_LOCATION,ACCESS_FINE_LOCATION},
                                MY_PERMISION_CODE);


                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {

                    }
                });
        dialog.show();
    }


    public void showSnack(boolean isConnected)
    {
        String message;
        int color;
        if (isConnected) {
            message = "Good! Connected to Internet";
            color = Color.WHITE;
            getUserLocation();
        } else {
            message = "Sorry! Not connected to internet";
            color = Color.RED;
        }

        Snackbar snackbar = Snackbar
                .make(rl_layout, message, Snackbar.LENGTH_LONG);

        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(color);
        snackbar.show();

    }

    private void getUserLocation() {
    }




    @Override
    public void showProgressBar() {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            mProgressBar.setProgress(0,true);
        }
        else mProgressBar.setProgress(0);

    }

    @Override
    public void hideProgressBar() {
        if (mProgressBar.getVisibility() == View.VISIBLE) {
            mProgressBar.setVisibility(View.GONE);


        }

    }
}
