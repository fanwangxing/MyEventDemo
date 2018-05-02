package fan.myeventdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private View windowView,rootView,layView,bt,bt2;
    boolean viewHanded;
    boolean handed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         windowView = (ViewGroup)getWindow().getDecorView().findViewById(android.R.id.content);
         rootView = ((ViewGroup)windowView).getChildAt(0);
         layView = ((ViewGroup)rootView).getChildAt(0);
         bt = ((ViewGroup)layView).getChildAt(0);
         bt2 = ((ViewGroup)layView).getChildAt(1);
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("MainActivity", "点击的根视图");
            }
        });
        layView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("MainActivity", "点击的布局视图");
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "点击的按钮");
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "点击的按钮2");
            }
        });

        rootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("MainActivity", "触摸了跟布局");
                return false;
            }
        });
        layView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("MainActivity", "触摸了layView");
                return false;
            }
        });
        bt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("MainActivity", "触摸了bt");
                ((ViewGroup) layView).onInterceptTouchEvent(event);
                layView.dispatchTouchEvent(event);
                return false;

            }
        });
        bt2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("MainActivity", "触摸了bt2");

                return false;
            }
        });
    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent event) {
////                Log.d("MainActivity", "rootView:"+rootView.dispatchTouchEvent(event));
////        Log.d("MainActivity", "layView:"+layView.dispatchTouchEvent(event));
////        Log.d("MainActivity", "bt:"+bt.dispatchTouchEvent(event));
////        Log.d("MainActivity", "bt2:"+bt2.dispatchTouchEvent(event));
//        Log.d("MainActivity", "dispatchTouchEvent==" + event.getAction());
//        viewHanded = rootView.dispatchTouchEvent(event);
//        if(!viewHanded){
//            handed = onTouchEvent(event);
//        }
//        return handed||viewHanded;
//    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//
//        return false;
//    }
}
