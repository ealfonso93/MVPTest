package com.ealfonso.mvptest.root;

import android.app.Application;

import com.ealfonso.mvptest.DaggerApplicationComponent;
import com.ealfonso.mvptest.login.LoginModule;
import com.ealfonso.mvptest.root.ApplicationComponent;
import com.ealfonso.mvptest.root.ApplicationModule;

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
                //.loginModule(new LoginModule())
                .build();
    }

    public ApplicationComponent getComponent(){
        return component;
    }
}
