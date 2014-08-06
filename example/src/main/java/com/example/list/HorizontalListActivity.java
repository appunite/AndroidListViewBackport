package com.example.list;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import com.appunite.list.AbsHorizontalListView;
import com.appunite.list.AbsListView;
import com.appunite.list.HorizontalListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HorizontalListActivity extends ActionBarActivity {

    private static final String PROJECTION_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horizontal_list_activity);

        final HorizontalListView listView = (HorizontalListView) findViewById(android.R.id.list);

        List<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 100; ++i) {
            final HashMap<String, String> map = new HashMap<String, String>();
            map.put(PROJECTION_NAME, String.format("Item: %d", i));
            data.add(map);
        }
        ListAdapter adapter = new SimpleAdapter(this,
                data,
                R.layout.horizontal_simple_list_item,
                new String[]{PROJECTION_NAME},
                new int[]{android.R.id.text1});
        listView.setAdapter(adapter);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);

        listView.setMultiChoiceModeListener(new AbsHorizontalListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

            }

            @Override
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                getMenuInflater().inflate(R.menu.action_mode, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                Toast.makeText(HorizontalListActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode actionMode) {
            }
        });
    }
}
