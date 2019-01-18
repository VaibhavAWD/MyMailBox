package com.vaibhavdhunde.android.mymailbox.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

    private OnClickListener mOnClickListener;
    private GestureDetector mGestureDetector;

    public RecyclerTouchListener(Context context, RecyclerView recyclerView,
                                 OnClickListener onClickListener) {
        mOnClickListener = onClickListener;

        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView,
                                         @NonNull MotionEvent motionEvent) {
        View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        if (child != null && mOnClickListener != null &&
                mGestureDetector.onTouchEvent(motionEvent)) {
            int position = recyclerView.getChildAdapterPosition(child);
            mOnClickListener.OnClick(position);
        }
        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean b) {

    }

    public interface OnClickListener {
        void OnClick(int position);
    }
}
