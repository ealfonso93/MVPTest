package com.ealfonso.mvptest.root;

import android.app.Application;

import com.ealfonso.mvptest.http.ApiModule;
import com.ealfonso.mvptest.login.LoginModule;

/**
 * Created by rufo on 20/01/2018.
 */

public class BasicApp extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .loginModule(new LoginModule())
                .apiModule(new ApiModule())
                .build();
    }

    public ApplicationComponent getComponent(){
        return component;
    }
}
