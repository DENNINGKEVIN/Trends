package com.mulama.beersuperior;

import android.content.Context;
import android.widget.ArrayAdapter;

public class MyBeerArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mBeers;
    private Integer[] mRatings;

    public MyBeerArrayAdapter (Context mContext,int resource,String[] mBeers,Integer[] mRatings){
        super(mContext,resource);
        this.mContext=mContext;
        this.mBeers=mBeers;
        this.mRatings=mRatings;
    }

    @Override
    public Object getItem(int position){
        String beer = mBeers[position];
        Integer rating = mRatings[position];
        return String.format("%s \n Rated: %s", beer, rating);
    }

    @Override
    public int getCount(){
        return mBeers.length;
    }
}
