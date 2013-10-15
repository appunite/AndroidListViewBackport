package com.example.list;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import com.appunite.list.HorizontalListView;
import com.appunite.list.ListView;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.actionbarsherlock.app.SherlockActivity;

public class MainActivity extends SherlockActivity implements View.OnClickListener {

    private static final String PROJECTION_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        findViewById(R.id.button_horizontal_list).setOnClickListener(this);
        findViewById(R.id.button_vertical_list).setOnClickListener(this);
        findViewById(R.id.button_grid_view).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        final int viewId = view.getId();
        switch (viewId) {
            case R.id.button_horizontal_list:
                startActivity(new Intent(this, HorizontalListActivity.class));
                return;
            case R.id.button_vertical_list:
                startActivity(new Intent(this, VerticalListActivity.class));
                return;
            case R.id.button_grid_view:
                startActivity(new Intent(this, GridActivity.class));
                return;
            default:
                throw new RuntimeException("Unknown button id: " + viewId);
        }
    }
}