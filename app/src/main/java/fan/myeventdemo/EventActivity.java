package fan.myeventdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ScrollView;

public class EventActivity extends AppCompatActivity {
    ViewGroup myRelative,root,window;
    View myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_event);
        window = getWindow().getDecorView().findViewById(android.R.id.content);
        root = (ViewGroup) window.getChildAt(0);
        myRelative = (ViewGroup) root.getChildAt(0);
        myButton = myRelative.getChildAt(0);
//        window.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("event", "点击了window");
//            }
//        });
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("event", "点击了root");
            }
        });
        myRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("event", "点击了myRelative");
            }
        });
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("event", "点击了myButton");
            }
        });


    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("event", "EventActivity:"+"dispatch" + ev.getAction());
        boolean dispatch = window.dispatchTouchEvent(ev);
        boolean touch = false;
        if(!dispatch){
            touch = onTouchEvent(ev);
        }
        return touch||dispatch;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("event", "EventActivity:"+"touch" + event.getAction());
        return true;
    }

}
