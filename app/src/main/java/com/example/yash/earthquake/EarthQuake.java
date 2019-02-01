package com.example.yash.earthquake;

public class EarthQuake
{
   private String mplace,murl;
   private double mmagnitude;
   private long mtime;

    public EarthQuake(double magnitude, String place, long time, String url) {
        this.mplace = place;
        this.murl = url;
        this.mmagnitude = magnitude;
        this.mtime = time;
    }

    public String getMlocation() {
        return mplace;
    }

    public String getMurl() {
        return murl;
    }

    public double getMagnitude() {
        return mmagnitude;
    }

    public long getMtime() {
        return mtime;
    }

    @Override
    public String toString(){
        String res=this.getMurl();
        return  res;
    }
}
