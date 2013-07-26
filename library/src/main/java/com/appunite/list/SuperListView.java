package com.appunite.list;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListAdapter;

public abstract class SuperListView extends AdapterView<ListAdapter> {
    /**
     * Track if we are currently attached to a window.
     */
    boolean mIsAttached;

    public SuperListView(Context context) {
        super(context);
    }

    public SuperListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SuperListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        mIsAttached = true;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        mIsAttached = false;
    }

    abstract void reportScrollStateChange(int newState);
}
