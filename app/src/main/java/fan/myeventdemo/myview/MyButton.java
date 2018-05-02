package fan.myeventdemo.myview;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


public class MyButton extends AppCompatButton {
    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = measureWidth(widthMeasureSpec);
        int height = measureHeight(heightMeasureSpec);
        setMeasuredDimension(width,height);

    }

    private int measureHeight(int heightMeasureSpec) {
        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        int size = MeasureSpec.getSize(heightMeasureSpec);
        if(specMode == MeasureSpec.AT_MOST){//wrap_content

            size = 200;
        }else if(specMode == MeasureSpec.UNSPECIFIED){
            size = 0;
        }else if(specMode == MeasureSpec.EXACTLY){//fill_parent或精确值
            size = 400;
        }
        return size;
    }

    private int measureWidth(int widthMeasureSpec) {
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);
        if(specMode == MeasureSpec.AT_MOST){//wrap_content

            size = 200;
        }else if(specMode == MeasureSpec.UNSPECIFIED){
            size = 0;
        }else if(specMode == MeasureSpec.EXACTLY){//fill_parent或精确值
            size = 400;
        }
        return size;
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d("event", "MyButton:"+"dispatch" + event.getAction());
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("event", "MyButton:"+"touch" + event.getAction());
        return super.onTouchEvent(event);
    }

}
