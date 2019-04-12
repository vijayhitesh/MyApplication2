package com.example.myapplication.login.presenter;


import com.example.myapplication.login.view.activity.MainActivity;

/**
 * defines the contract between the view {@link MainActivity} and the presenter {@link MainPresenter}
 */
public interface MainContract {

    interface Mapview{

        void showMapScreen();

        void showSignOffScreen();

    }

    interface Presnter{
        void handleSignInBtn();

        void handleSignOutBtn();
    }
}
