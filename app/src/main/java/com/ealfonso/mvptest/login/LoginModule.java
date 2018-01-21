package com.ealfonso.mvptest.login;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rufo on 21/01/2018.
 */

@Module
public class LoginModule{

    @Provides
    public LoginActivityMVP.Presenter provideLoginActivityPresenter(LoginActivityMVP.Model model){
        return new LoginActivityPresenter(model);
    }

    @Provides
    public LoginActivityMVP.Model  provideLoginActivityModel(LoginRepository repository){
        return new LoginModel(repository);
    }

    @Provides
    public LoginRepository provideLoginRepository(){
        return new MemoryRepository();
    }
}
