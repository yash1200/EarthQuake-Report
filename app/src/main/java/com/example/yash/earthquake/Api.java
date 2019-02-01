package com.example.yash.earthquake;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api
{
    String BASE_URL="https://earthquake.usgs.gov/fdsnws/event/1/";

    @GET("query?format=geojson&orderby=time&minmag=6&limit=10")
    Call<List<EarthQuake>> getEarthQuake();
}
