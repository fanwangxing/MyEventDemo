package fan.myeventdemo.myview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class MyRelative extends RelativeLayout {
    public MyRelative(Context context) {
        super(context);

    }


    public MyRelative(Context context, AttributeSet attrs) {
        super(context, attrs);

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = measureWidth(widthMeasureSpec);
        int height = measureHeight(heightMeasureSpec);
        setMeasuredDimension(width,height);
        Log.d("onMeasure", "------onMeasure");

    }

    private int measureHeight(int heightMeasureSpec) {
        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        int size = MeasureSpec.getSize(heightMeasureSpec);
        if(specMode == MeasureSpec.AT_MOST){//wrap_content

            size = 500;
        }else if(specMode == MeasureSpec.UNSPECIFIED){
            size = 0;
        }else if(specMode == MeasureSpec.EXACTLY){//fill_parent或精确值
            size = 800;
        }
        return size;
    }

    private int measureWidth(int widthMeasureSpec) {
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);
        if(specMode == MeasureSpec.AT_MOST){//wrap_content

            size = 500;
        }else if(specMode == MeasureSpec.UNSPECIFIED){
            size = 0;
        }else if(specMode == MeasureSpec.EXACTLY){//fill_parent或精确值
            size = 500;
        }
        return size;
    }

    public MyRelative(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyRelative(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d("event", "MyRelative:"+"intercept"+ev.getAction());
        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("event", "MyRelative:"+"dispatch" + ev.getAction());
        boolean dispatch = false;
        boolean intercept = false;
        boolean touch = false;
        if(!intercept){
            intercept = onInterceptTouchEvent(ev);
        }
        if(intercept){
            touch = onTouchEvent(ev);
        }else{
            dispatch = getChildAt(0).dispatchTouchEvent(ev);
        }
        return touch||dispatch;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("event", "MyRelative:"+"touch" + event.getAction());
        return false;
    }

}
