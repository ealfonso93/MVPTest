package com.ealfonso.mvptest.login;

/**
 * Created by rufo on 21/01/2018.
 */

public class LoginModel implements LoginActivityMVP.Model{

    private LoginRepository repository;

    public LoginModel(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createUser(String firstName, String lastName) {
        repository.saveUser(new User(firstName, lastName));
    }

    @Override
    public User getUser() {
        return repository.getUser();
    }
}
