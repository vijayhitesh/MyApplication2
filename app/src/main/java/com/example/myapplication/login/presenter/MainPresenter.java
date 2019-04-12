package com.example.myapplication.login.presenter;

import com.example.myapplication.login.presenter.MainContract;

/**
 * responsible for handling action from view and updating the ui as required
 */

public class MainPresenter implements MainContract.Presnter {

    private MainContract.Mapview mapview;

    public MainPresenter (MainContract.Mapview mapview){
        this.mapview = mapview;

    }

    @Override
    public void handleSignInBtn() {
        mapview.showMapScreen();

    }

    @Override
    public void handleSignOutBtn() {
        mapview.showSignOffScreen();

    }
}
