package com.example.ccp_dupl1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MonthlyEventAdapter extends BaseAdapter {

    private ArrayList<MonthlyEventItem> items = new ArrayList<MonthlyEventItem>();
    Context context;

    public void addItem(MonthlyEventItem item){
        items.add(item);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        context = viewGroup.getContext();
        MonthlyEventItem monthlyEventItem = items.get(i);

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.monthly_event_item, viewGroup, false);
        }

        TextView eventTitle = view.findViewById(R.id.item_event_title);
        TextView eventHashtag = view.findViewById(R.id.item_event_hashtag);
        Log.d("wow", "List item added");

        eventTitle.setText(monthlyEventItem.getEventName());
        eventHashtag.setText(monthlyEventItem.getHashtags());

        return view;
    }
}
