package com.example.yash.earthquake;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api=retrofit.create(Api.class);
        Call<List<EarthQuake>> call=api.getEarthQuake();
        call.enqueue(new Callback<List<EarthQuake>>() {
            @Override
            public void onResponse(Call<List<EarthQuake>> call, Response<List<EarthQuake>> response) {

                ArrayList<EarthQuake> earthquake=new ArrayList<>();

                List<EarthQuake> earthquakes= response.body();
                for(int i=0;i<earthquakes.size();i++)
                {
                    Double mag=(earthquakes.get(i).getMagnitude());
                    String loc=earthquakes.get(i).getMlocation();
                    long time=earthquakes.get(i).getMtime();
                    String url=earthquakes.get(i).getMurl();
                    EarthQuake earthQuake=new EarthQuake(mag,loc,time,url);
                    earthquake.add(earthQuake);

                }

                final EarthQuakeAdapter adapter=new EarthQuakeAdapter(MainActivity.this,R.layout.custom_list,earthquake);

                ListView earthquakeListView=(ListView) findViewById(R.id.list);

                earthquakeListView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<EarthQuake>> call, Throwable t)
            {
                Toast.makeText(getApplicationContext(),"Some Problem Occured",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
