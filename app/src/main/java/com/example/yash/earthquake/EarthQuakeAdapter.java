package com.example.yash.earthquake;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EarthQuakeAdapter extends ArrayAdapter<EarthQuake> {
    public EarthQuakeAdapter(Context context, int resource, ArrayList<EarthQuake> earth) {
        super(context, resource, earth);
    }

    @Override
    public View getView(int position,View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View v = inflater.inflate(R.layout.custom_list, parent, false);

        EarthQuake current = getItem(position);
        String magnitude=Double.toString(current.getMagnitude());
        TextView mag=v.findViewById(R.id.magnitude);
        mag.setText(magnitude);

        String location=current.getMlocation();
        TextView place=v.findViewById(R.id.place);
        place.setText(location);

        long t=current.getMtime();
        TextView time=v.findViewById(R.id.time);
        time.setText(String.valueOf(t));
        return v;
    }
}
