package com.example.list;

import android.content.Intent;
import android.os.Bundle;

import com.actionbarsherlock.app.SherlockActivity;
import com.appunite.list.ListView;
import com.example.list.adapter.HorizontalImageItemAdapter;
import com.example.list.adapter.ImageListAdapter;

public class HorizontalImageListActivity extends SherlockActivity implements
        HorizontalImageItemAdapter.OnImageClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.horizontal_image_list_layout);

        ListView listView = (ListView) findViewById(android.R.id.list);
        ImageListAdapter adapter = new ImageListAdapter(this, this);
        listView.setAdapter(adapter);
    }

    @Override
    public void onImageClick(int resId) {
        Intent intent = new Intent(this, SingleImageActivity.class);
        intent.putExtra(SingleImageActivity.IMAGE_RES_ID, resId);
        startActivity(intent);
    }
}
