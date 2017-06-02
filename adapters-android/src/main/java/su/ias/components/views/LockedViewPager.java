package su.ias.components.views;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * ViewPager with possibility to disable swipes to left / to right
 */

public class LockedViewPager extends ViewPager {

    private boolean isSwipeDisabled = false;

    public LockedViewPager(Context context) {
        super(context);
    }

    public LockedViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean isSwipeDisabled() {
        return isSwipeDisabled;
    }

    public void setSwipeDisabled(boolean swipeDisabled) {
        isSwipeDisabled = swipeDisabled;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        // Disable swipe
        return !isSwipeDisabled && super.onInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Disable swipe
        return !isSwipeDisabled && super.onTouchEvent(event);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (heightMeasureSpec == 0) {

            int height = 0;
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                child.measure(child.getMeasuredWidth(),
                              MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
                int h = child.getMeasuredHeight();
                if (h > height) {
                    height = h;
                }
            }
            height += getPaddingBottom() + getPaddingTop();
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);

            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
