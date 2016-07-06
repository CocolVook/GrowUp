package cn.tinycube.trial.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * @author: WangJianbiao
 * @time: 16/7/5-上午11:03.
 * @email: wangjianbiao@qccr.com
 * @desc:
 */
public class MotionEventViewGroup extends RelativeLayout {
    private String tag = "#";
    private boolean printed;

    public MotionEventViewGroup(Context context) {
        this(context, null);
    }

    public MotionEventViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MotionEventViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MotionEventViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        tag = getContentDescription().toString();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (action != MotionEvent.ACTION_MOVE) {
            printed = false;
            Log.i("@@@@", tag + ": onTouchEvent=>" + "; " + actionToString(action));
        } else if (!printed) {
            printed = true;
            Log.i("@@@@", tag + ": onTouchEvent=>" + "; " + actionToString(action));
        }
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        boolean ret = super.onInterceptTouchEvent(ev);
        if (TextUtils.equals(tag, "F"))
            ret |= action == MotionEvent.ACTION_MOVE;
        if (action != MotionEvent.ACTION_MOVE) {
            printed = false;
            Log.i("@@@@", tag + ": onInterceptTouchEvent=>" + ret + "; " + actionToString(action));
        } else if (!printed) {
            printed = true;
            Log.i("@@@@", tag + ": onInterceptTouchEvent=>" + ret + "; " + actionToString(action));
        }
        return ret;
    }

    public static String actionToString(int action) {
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                return "ACTION_DOWN";
            case MotionEvent.ACTION_UP:
                return "ACTION_UP";
            case MotionEvent.ACTION_CANCEL:
                return "ACTION_CANCEL";
            case MotionEvent.ACTION_OUTSIDE:
                return "ACTION_OUTSIDE";
            case MotionEvent.ACTION_MOVE:
                return "ACTION_MOVE";
            case MotionEvent.ACTION_HOVER_MOVE:
                return "ACTION_HOVER_MOVE";
            case MotionEvent.ACTION_SCROLL:
                return "ACTION_SCROLL";
            case MotionEvent.ACTION_HOVER_ENTER:
                return "ACTION_HOVER_ENTER";
            case MotionEvent.ACTION_HOVER_EXIT:
                return "ACTION_HOVER_EXIT";
            case MotionEvent.ACTION_BUTTON_PRESS:
                return "ACTION_BUTTON_PRESS";
            case MotionEvent.ACTION_BUTTON_RELEASE:
                return "ACTION_BUTTON_RELEASE";
        }
        int index = (action & MotionEvent.ACTION_POINTER_INDEX_MASK) >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
        switch (action & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_POINTER_DOWN:
                return "ACTION_POINTER_DOWN(" + index + ")";
            case MotionEvent.ACTION_POINTER_UP:
                return "ACTION_POINTER_UP(" + index + ")";
            default:
                return Integer.toString(action);
        }
    }

}
