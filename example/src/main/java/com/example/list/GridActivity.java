package com.example.list;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.appunite.list.GridView;

import static com.google.common.base.Preconditions.checkNotNull;

public class GridActivity extends ActionBarActivity implements LoaderManager.LoaderCallbacks<Object> {

    private static final int LOADER_MAIN = 0;

    private MyAdapter mAdapter;

    public static class MyAdapter extends BaseAdapter {

        private LayoutInflater mInflater;
        private int mCount = 0;

        public MyAdapter(Context context) {
            mInflater = LayoutInflater.from(context);
        }

        public void swapData(int count) {
            mCount = count;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return mCount;
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = checkNotNull(mInflater.inflate(R.layout.grid_item, viewGroup, false));
            }
            final TextView textView = (TextView) view.findViewById(android.R.id.text1);
            textView.setText(String.format("Item: %d", i));
            return view;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_activity);

        final GridView listView = (GridView) findViewById(android.R.id.list);

        mAdapter = new MyAdapter(this);
        listView.setAdapter(mAdapter);

        getSupportLoaderManager().initLoader(LOADER_MAIN, null, this);
    }

    @Override
    public Loader<Object> onCreateLoader(int i, Bundle bundle) {
        return new AsyncTaskLoader<Object>(this) {
            @Override
            public Object loadInBackground() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                }
                return null;
            }

            @Override
            protected void onStartLoading() {
                forceLoad();
            }
        };
    }

    @Override
    public void onLoadFinished(Loader<Object> objectLoader, Object o) {
        mAdapter.swapData(100);
    }

    @Override
    public void onLoaderReset(Loader<Object> objectLoader) {
        mAdapter.swapData(0);
    }

}
