package com.example.list;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import com.appunite.list.ListView;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {

    private static final String PROJECTION_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        final ListView listView = (ListView) findViewById(android.R.id.list);
        List<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
        final List<String> strings = Arrays.asList("dog", "cut", "cow", "elephant");
        for (String string : strings) {
            final HashMap<String,String> map = Maps.newHashMap();
            map.put(PROJECTION_NAME, string);
            data.add(map);
        }
        ListAdapter adapter = new SimpleAdapter(this,
                data,
                android.R.layout.simple_list_item_1,
                new String[] {PROJECTION_NAME},
                new int[] {android.R.id.text1});
        listView.setAdapter(adapter);
    }
}