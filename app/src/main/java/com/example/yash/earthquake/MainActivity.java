package com.example.yash.earthquake;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    String BASE_URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=6&limit=10";
    private ProgressDialog pDialog;
    ArrayList<EarthQuake> earthquake = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new GetContributors().execute();
    }

    private class GetContributors extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Loading...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            String USGS_REQUEST_URL = new HttpDude().makeServiceCall(BASE_URL);
            earthquake = (ArrayList<EarthQuake>) QueryUtils.extractFeatureFromJson(USGS_REQUEST_URL);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            if (pDialog.isShowing())
                pDialog.dismiss();

            EarthQuakeAdapter adapter = new EarthQuakeAdapter(MainActivity.this, R.layout.custom_list, earthquake);

            ListView earthquakeListView = findViewById(R.id.list);

            earthquakeListView.setAdapter(adapter);

        }
    }
}
