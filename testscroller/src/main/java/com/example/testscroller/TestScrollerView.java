package com.example.testscroller;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.Toast;

public class TestScrollerView extends RelativeLayout{
    private static final String TAG = "TestScrollerView";
    private Button child;
    private Scroller mScroller = new Scroller(getContext());

    public TestScrollerView(Context context) {
        this(context,null);
    }

    public TestScrollerView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TestScrollerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        initView();
    }

    private void initView(){
        child = (Button) getChildAt(0);
        child.setOnTouchListener(mOnTouchListener);
    }

    private float mLastRawY;
    private int mStartRawY = 0;

    private OnTouchListener mOnTouchListener = new OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch(event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    mLastRawY =  event.getRawY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    int dy = (int) (mLastRawY - event.getRawY());
                    smoothScrollBy(mStartRawY,  dy,100);
                    mStartRawY = mScroller.getFinalY();
                    mLastRawY = event.getRawY();
                    break;
                case MotionEvent.ACTION_UP:

                    break;
                default:
            }
            return false;
        }
    };

    public void smoothScrollBy(int startY, int dy,int duration) {

        mScroller.startScroll(0, startY, 0, dy, duration);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }
}