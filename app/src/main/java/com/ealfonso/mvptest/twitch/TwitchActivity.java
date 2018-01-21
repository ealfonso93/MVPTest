package com.ealfonso.mvptest.twitch;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ealfonso.mvptest.R;
import com.ealfonso.mvptest.http.TwitchAPI;
import com.ealfonso.mvptest.http.apimodel.Datum;
import com.ealfonso.mvptest.http.apimodel.Twitch;
import com.ealfonso.mvptest.root.BasicApp;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TwitchActivity extends AppCompatActivity {

    @Inject
    TwitchAPI twitchAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitch);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ((BasicApp) getApplication()).getComponent().inject(this);

        Call<Twitch> call = twitchAPI.getTopGames(getString(R.string.twitch_client_id));

        call.enqueue(new Callback<Twitch>() {
            @Override
            public void onResponse(Call<Twitch> call, Response<Twitch> response) {
                if (response.body() != null){
                    List<Datum> gameList = response.body().getData();

                    for (Datum datum : gameList){
                        System.out.println(datum.getName());
                    }
                }
            }

            @Override
            public void onFailure(Call<Twitch> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}
