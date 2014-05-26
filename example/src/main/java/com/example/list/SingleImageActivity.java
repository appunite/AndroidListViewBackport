package com.example.list;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.widget.ImageView;

public class SingleImageActivity extends ActionBarActivity {

    public static final String IMAGE_RES_ID = "image_res_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final int resId = getIntent().getIntExtra(IMAGE_RES_ID, R.drawable.a);

        setContentView(R.layout.single_image_layout);

        ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setImageResource(resId);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
