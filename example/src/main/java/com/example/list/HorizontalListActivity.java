package com.example.list;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import com.actionbarsherlock.app.SherlockActivity;
import com.appunite.list.HorizontalListView;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HorizontalListActivity extends SherlockActivity {

    private static final String PROJECTION_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horizontal_list_activity);

        final HorizontalListView listView = (HorizontalListView) findViewById(android.R.id.list);

        List<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 100; ++i) {
            final HashMap<String, String> map = Maps.newHashMap();
            map.put(PROJECTION_NAME, String.format("Item: %d", i));
            data.add(map);
        }
        ListAdapter adapter = new SimpleAdapter(this,
                data,
                R.layout.horizontal_simple_list_item,
                new String[]{PROJECTION_NAME},
                new int[]{android.R.id.text1});
        listView.setAdapter(adapter);
        // Currently not working
//        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
    }
}