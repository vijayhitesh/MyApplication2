package com.example.myapplication.main;

/**
 * responsible for handling action from view and updating the ui as required
 */

public class MainPresenter implements MainContract.Presnter {

    private MainContract.Mapview mapview;

    MainPresenter (MainContract.Mapview mapview){
        this.mapview = mapview;

    }
}
