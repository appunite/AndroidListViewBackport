package com.example.list.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.list.R;

import java.util.Random;

public class HorizontalImageItemAdapter extends BaseAdapter implements View.OnClickListener {

    public interface OnImageClickListener {
        public void onImageClick(int resId);
    }

    private static class ViewHolder {
        ImageView image;
        Integer position;
    }

    private static final int[] THUMB_IMAGES = new int[] {
            R.drawable.thumb_a, R.drawable.thumb_b, R.drawable.thumb_c, R.drawable.thumb_d,
            R.drawable.thumb_e, R.drawable.thumb_f, R.drawable.thumb_g, R.drawable.thumb_h,
            R.drawable.thumb_i, R.drawable.thumb_j, R.drawable.thumb_k, R.drawable.thumb_l,
            R.drawable.thumb_m
    };

    private static final int[] IMAGES = new int[] {
            R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e,
            R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j,
            R.drawable.k, R.drawable.l, R.drawable.m
    };

    private LayoutInflater mInflater;
    private Random mRandom;
    private OnImageClickListener mListener;

    public HorizontalImageItemAdapter(Context context, OnImageClickListener listener) {
        mInflater = LayoutInflater.from(context);
        mListener = listener;
        mRandom = new Random();
    }

    @Override
    public int getCount() {
        return 150;
    }

    @Override
    public Object getItem(int position) {
        int imagePos = mRandom.nextInt(THUMB_IMAGES.length);
        return imagePos;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.image_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.image = (ImageView) convertView.findViewById(R.id.image);
            viewHolder.position = (Integer) getItem(position);
            convertView.setTag(viewHolder);
            convertView.setOnClickListener(this);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        int pos = viewHolder.position;
        viewHolder.image.setImageResource(THUMB_IMAGES[pos]);

        return convertView;
    }

    @Override
    public void onClick(View v) {
        if (mListener != null) {
            ViewHolder holder = (ViewHolder) v.getTag();
            mListener.onImageClick(IMAGES[holder.position]);
        }
    }
}
