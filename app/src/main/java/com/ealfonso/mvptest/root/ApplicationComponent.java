package com.ealfonso.mvptest.root;

import com.ealfonso.mvptest.login.LoginActivity;
import com.ealfonso.mvptest.login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by rufo on 20/01/2018.
 */

@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class})
public interface ApplicationComponent {

    void inject(LoginActivity target);
}
