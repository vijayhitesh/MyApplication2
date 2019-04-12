package com.example.myapplication.main;

import com.example.myapplication.login.presenter.MainContract;
import com.example.myapplication.login.presenter.MainPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;


/**
 * local unit test for main presenter
 */
public class MainPresenterTest {

    @Mock
    private MainContract.Mapview mapview;

    private MainPresenter mainPresenter;



    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mainPresenter = new MainPresenter(mapview);

    }


    // presenter method
    @Test
    public void handleSignInBtn() {
        mainPresenter.handleSignInBtn();
        //verify(mapview).showMapScreen;
    }

    @Test
    public void handleSignOutBtn() {
        mainPresenter.handleSignOutBtn();
        //verify(mapview).closeMapScreen;
    }
}