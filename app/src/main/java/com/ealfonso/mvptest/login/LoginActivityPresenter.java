package com.ealfonso.mvptest.login;

import android.support.annotation.Nullable;

/**
 * Created by rufo on 21/01/2018.
 */

public class LoginActivityPresenter implements LoginActivityMVP.Presenter{

    @Nullable
    private LoginActivityMVP.View view;
    private LoginActivityMVP.Model model;

    public LoginActivityPresenter(LoginActivityMVP.Model model) {
        this.model = model;
    }

    public void setView(LoginActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void loginButtonClicked() {
        if(view != null){
            if(isStringEmpty(view.getFirstName()) || isStringEmpty(view.getLastName())){
                view.showInputError();
            }else{
                model.createUser(view.getFirstName(),view.getLastName());
                view.showUserSaved();
            }
        }
    }

    @Override
    public void getCurrentUser() {

        User user = model.getUser();


        if(user != null){
            if(view != null){
                view.setFirstName(user.getFirstName());
                view.setLastName(user.getSecondName());
            }
        }else{
            view.showUserNotAvailable();
        }

        /*if(user == null){
            if(view != null){
                view.showUserNotAvailable();
            }
        }else{
            if(view != null){
                view.setFirstName(user.getFirstName());
                view.setLastName(user.getSecondName());
            }
        }*/
    }

    @Override
    public void saveUser() {
        if (view != null) {
            if (view.getFirstName().trim().equals("") || view.getLastName().trim().equals("")) {
                view.showInputError();
            } else {

                model.createUser(view.getFirstName(), view.getLastName());
                view.showUserSavedMessage();

            }
        }
    }

    private boolean isStringEmpty(String emptyString){
        return emptyString.trim().equals("");
    }
}
