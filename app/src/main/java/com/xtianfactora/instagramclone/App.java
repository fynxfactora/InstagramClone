package com.xtianfactora.instagramclone;

import android.app.Application;
import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("65yE9WnF9nSDVw5VcTXoa8oA14AWN5idpFDCi7Zw")
                .clientKey("0X43rrLIKRHF39jrOKuMT5oQvY5pYeKBVVoXn4PO")
                .server("https://parseapi.back4app.com/")
                .build());
    }
}
