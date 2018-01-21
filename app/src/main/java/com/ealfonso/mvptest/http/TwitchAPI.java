package com.ealfonso.mvptest.http;

import com.ealfonso.mvptest.http.apimodel.Twitch;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by rufo on 21/01/2018.
 */

public interface TwitchAPI {
    @GET("games/top")
    Call<Twitch> getTopGames(@Header("Client-Id") String clientId);
}
