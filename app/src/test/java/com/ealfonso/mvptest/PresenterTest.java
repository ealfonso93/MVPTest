package com.ealfonso.mvptest;

import com.ealfonso.mvptest.login.LoginActivity;
import com.ealfonso.mvptest.login.LoginActivityMVP;
import com.ealfonso.mvptest.login.LoginActivityPresenter;
import com.ealfonso.mvptest.login.User;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by rufo on 21/01/2018.
 */

public class PresenterTest {

    LoginActivityMVP.Model mockLoginModel;
    LoginActivityMVP.View mockView;
    LoginActivityPresenter presenter;

    User user;

    @Before
    public void setUp(){
        mockLoginModel = mock(LoginActivityMVP.Model.class);

        user = new User("John","Doe");

        when(mockLoginModel.getUser()).thenReturn(user);

        mockView = mock(LoginActivityMVP.View.class);

        presenter = new LoginActivityPresenter(mockLoginModel);

        presenter.setView(mockView);
    }

    @Test
    public void loadTheUserFromRepositoryWhenValidUserIsPresent(){
        when(mockLoginModel.getUser()).thenReturn(user);

        presenter.getCurrentUser();

        verify(mockLoginModel, times(1)).getUser();

        verify(mockView, times(1)).setFirstName("John");
        verify(mockView, times(1)).setLastName("Doe");
        verify(mockView, never()).showUserNotAvailable();
    }

    @Test
    public void shouldShowErrorMessageWhenUserIsNull() {
        when(mockLoginModel.getUser()).thenReturn(null);

        presenter.getCurrentUser();

        verify(mockLoginModel,times(1)).getUser();

        verify(mockView, never()).setFirstName("John");
        verify(mockView, never()).setLastName("Doe");
        verify(mockView, times(1)).showUserNotAvailable();
    }

    @Test
    public void shouldCreateErrorMessageIfFieldAreEmpty() {
        when(mockView.getFirstName()).thenReturn("");

        presenter.saveUser();

        verify(mockView, times(1)).getFirstName();
        verify(mockView, never()).getLastName();
        verify(mockView, times(1)).showInputError();

        when(mockView.getFirstName()).thenReturn("Doe");
        when(mockView.getLastName()).thenReturn("");

        presenter.saveUser();

        verify(mockView, times(2)).getFirstName();
        verify(mockView, times(1)).getLastName();
        verify(mockView, times(2)).showInputError();
    }

    @Test
    public void shouldBeAbleToSaveValidUser(){

        when(mockView.getFirstName()).thenReturn("Doe");
        when(mockView.getLastName()).thenReturn("John");

        presenter.saveUser();

        verify(mockView,times(2)).getFirstName();
        verify(mockView,times(2)).getLastName();

        verify(mockLoginModel, times(1)).createUser("Doe", "John");

        verify(mockView, times(1)).showUserSavedMessage();
    }
}
