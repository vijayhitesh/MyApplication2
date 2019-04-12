package com.example.myapplication.login.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.myapplication.R;
import com.example.myapplication.login.presenter.BaseActivity;
import com.example.myapplication.login.presenter.MainContract;
import com.example.myapplication.login.presenter.MainPresenter;


/**
 * displays the main screen , represents view in MVP design pattern
 */
public class MainActivity extends AppCompatActivity implements MainContract.Mapview {


    private Context context;
    private Button btn_signIn, btn_signUp;
    private android.support.v7.widget.Toolbar mToolbar;


    private MainPresenter mainPresenter;
    private BaseActivity mBaseActivity;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //txtLat = (TextView) findViewById(R.id.tv);




        mainPresenter = new MainPresenter(this);

        btn_signIn = (Button) findViewById(R.id.sign_in_btn);
        btn_signUp = (Button) findViewById(R.id.sign_out_btn);


        btn_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMapScreen();
            }
        });

btn_signUp.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        showSignOffScreen();
    }
});
    }





    @Override
    public void showMapScreen() {
        Toast.makeText(this,"click on show Map in button",Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, RestaurantListActivity.class);
        startActivity(intent);
    }

    @Override
    public void showSignOffScreen() {
        Toast.makeText(this,"click on show up in button",Toast.LENGTH_LONG).show();
        finish();

    }
}
