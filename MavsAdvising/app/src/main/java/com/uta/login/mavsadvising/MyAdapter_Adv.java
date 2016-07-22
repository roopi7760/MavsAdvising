package com.uta.login.mavsadvising;

import android.app.Activity;
import android.content.Context;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Roopesh on 7/21/2016.
 */
public class MyAdapter_Adv extends ArrayAdapter<DataModel_Advisor> {
    DataModel_Advisor[] modelItems = null;
    static int selectedIndex = -1;
    Context context;
    List<DataModel_Advisor> modelItemList = null;
    public MyAdapter_Adv(Context context, List<DataModel_Advisor> objects)
    {
        super(context, R.layout.row,objects);
        this.context = context;
        //modelItems=objects;
        modelItemList = objects;
    }

    public void deleteObject(DataModel_Advisor data)
    {

        modelItemList.remove(data);
    }
    public void setSelectedIndex(int index){selectedIndex = index;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.row, parent, false);
        TextView dayOfTheWeek = (TextView) convertView.findViewById(R.id.WeekOfTheDay);
        TextView startTime = (TextView) convertView.findViewById(R.id.StartTime);
        TextView endTime = (TextView) convertView.findViewById(R.id.EndTime);
        RadioButton chSelect = (RadioButton) convertView.findViewById(R.id.checkbox_adv);
        //DataModel_Advisor data = modelItems[position];
        DataModel_Advisor data = modelItemList.get(position);
        dayOfTheWeek.setText(data.getDayOfTheWeek());
        startTime.setText(data.getStartTime());
        endTime.setText(data.getEndTime());
        if(selectedIndex == position)
        {
            chSelect.setChecked(true);
            //selectedIndex=-1;
        }
        else
        {
            chSelect.setChecked(false);
        }
        //xxxxxselectedIndex = -1;
        return convertView;
    }
}
