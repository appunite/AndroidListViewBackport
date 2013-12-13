package com.example.list.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.appunite.list.HorizontalListView;
import com.example.list.R;

public class ImageListAdapter extends BaseAdapter {

    private static class ViewHolder {
        HorizontalListView listView;
    }

    private final Context mContext;
    private final LayoutInflater mInfalter;
    private final HorizontalImageItemAdapter.OnImageClickListener mListener;

    public ImageListAdapter(Context context, HorizontalImageItemAdapter.OnImageClickListener listener) {
        mContext = context;
        mInfalter = LayoutInflater.from(context);
        mListener = listener;
    }

    @Override
    public int getCount() {
        return 100;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mInfalter.inflate(R.layout.horizontal_image_list_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.listView = (HorizontalListView) convertView.findViewById(android.R.id.list);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.listView.setAdapter(new HorizontalImageItemAdapter(mContext, mListener));

        return convertView;
    }
}
