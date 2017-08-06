package com.example.riadhfarhati.footbyriadh;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by i on 06/08/2017.
 */

public class remplireScore extends ArrayAdapter<score> {
    private Context mContext;
    private ArrayList<score> mData;
    TextView t1,t2;
    public remplireScore(Context mContext, ArrayList<score> mData) {
        super(mContext,R.layout.style, mData);
        this.mContext=mContext;
        this.mData=mData;
    }
    public  int getCount(){

        return  mData.size();
    }
    public View getView(final int position, View convertView, ViewGroup parent)


    {
        final score  s = mData.get(position);
        LayoutInflater mInflater;

        if (convertView == null) {
            mInflater = (LayoutInflater)
                    mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = mInflater.inflate(R.layout.style, null);
        }
        Context context;




        t1=(TextView) convertView.findViewById(R.id.t1);
        t1.setText(mData.get(position).getTitre());

        t2=(TextView) convertView.findViewById(R.id.t2);
        t2.setText(mData.get(position).getContenu());



        return convertView;
    }



}


