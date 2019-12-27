package com.example.gaslon;

import com.example.gaslon.Remote.IGoogleApi;
import com.example.gaslon.Remote.RetrofitClient;

public class Common {
    public static final String baseURL = "https://googleapis.com";

    public static IGoogleApi getGoogleApi(){
        return RetrofitClient.getClient(baseURL).create(IGoogleApi.class);
    }
}
