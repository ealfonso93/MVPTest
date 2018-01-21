package com.ealfonso.mvptest.root;

import com.ealfonso.mvptest.http.ApiModule;
import com.ealfonso.mvptest.login.LoginActivity;
import com.ealfonso.mvptest.login.LoginModule;
import com.ealfonso.mvptest.twitch.TwitchActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by rufo on 20/01/2018.
 */

@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class, ApiModule.class})
public interface ApplicationComponent {

    void inject(LoginActivity target);
    void inject(TwitchActivity target);
}
