package com.example.yash.earthquake;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class EarthQuakeAdapter extends ArrayAdapter<EarthQuake>
{
    private List<EarthQuake> earth;
    private Context context;

    public EarthQuakeAdapter(Context context, int resource, List<EarthQuake> earth) {
        super(context, resource);
        this.context=context;
        this.earth = earth;
    }

    @Override
    public View getView(int position,View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.custom_list, null);

        EarthQuake current=getItem(position);
        String magnitude=Double.toString(current.getMagnitude());
        TextView mag=(TextView)v.findViewById(R.id.magnitude);
        mag.setText(magnitude);

        String location=current.getMlocation();
        TextView place=(TextView)v.findViewById(R.id.place);
        place.setText(location);

        long time=current.getMtime();
        TextView Time=(TextView)v.findViewById(R.id.time);
        Time.setText((int) time);
        return v;
    }
}
