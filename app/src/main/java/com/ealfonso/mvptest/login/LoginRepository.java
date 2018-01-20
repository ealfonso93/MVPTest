package com.ealfonso.mvptest.login;

/**
 * Created by rufo on 21/01/2018.
 */

public interface LoginRepository {

    User getUser();

    void saveUser(User user);
}
