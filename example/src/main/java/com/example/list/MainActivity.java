package com.example.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        findViewById(R.id.button_horizontal_list).setOnClickListener(this);
        findViewById(R.id.button_horizontal_image_list).setOnClickListener(this);
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
            case R.id.button_horizontal_image_list:
                startActivity(new Intent(this, HorizontalImageListActivity.class));
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