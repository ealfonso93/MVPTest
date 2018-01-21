package com.ealfonso.mvptest.login;

/**
 * Created by rufo on 21/01/2018.
 */

public class MemoryRepository implements LoginRepository{

    private User user;

    @Override
    public User getUser() {
        if(user == null){
            User user = new User("John", "Doe");
            user.setId(0);
            return user;
        }else{
            return user;
        }
    }

    @Override
    public void saveUser(User user) {
        if(user == null){
            user = getUser();
        }

        this.user = user;
    }
}
