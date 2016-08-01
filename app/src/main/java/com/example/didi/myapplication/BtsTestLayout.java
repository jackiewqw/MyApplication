package com.example.didi.myapplication;

import android.content.Context;
import android.os.Handler;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 测试布局
 */
public class BtsTestLayout extends LinearLayout {
    Handler handler = new Handler();

    TextView tv1;
    TextView tv2;

    boolean isTextChanged = false;

    public BtsTestLayout(Context context) {
        this(context, null);
    }

    public BtsTestLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BtsTestLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        inflate(getContext(), R.layout.bts_test_xml, this);
        tv1 = (TextView) findViewById(R.id.start);
        tv2 = (TextView) findViewById(R.id.end);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        if (isTextChanged) {
            isTextChanged = false;
            updateLayout();
        }
    }

    public void setText(CharSequence start, CharSequence end) {
        LayoutParams param1 = (LayoutParams) tv1.getLayoutParams();
        param1.width = ViewGroup.LayoutParams.MATCH_PARENT;
        param1.weight = 1;
        tv1.setLayoutParams(param1);

        LayoutParams param2 = (LayoutParams) tv2.getLayoutParams();
        param2.width = ViewGroup.LayoutParams.MATCH_PARENT;
        param2.weight = 1;
        tv2.setLayoutParams(param2);

        tv1.setText(start);
        tv2.setText(end);

        isTextChanged = true;
        requestLayout();
    }

    private void updateLayout() {
        int count1 = 0, count2 = 0;
        Layout l1 = tv1.getLayout();
        if (l1 != null && l1.getLineCount() > 0) {
            count1 = l1.getEllipsisCount(0);
        }

        Layout l2 = tv2.getLayout();
        if (l2 != null && l2.getLineCount() > 0) {
            count2 = l2.getEllipsisCount(0);
        }

        if (count1 > 0 && count2 <= 0) {
            handler.post(mUpdateTv2Runnable);
        } else if (count1 <= 0 && count2 > 0) {
            handler.post(mUpdateTv1Runnable);
        }
    }

    private Runnable mUpdateTv1Runnable = new Runnable() {
        @Override
        public void run() {
            LayoutParams lp = (LayoutParams) tv1.getLayoutParams();
            lp.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            lp.weight = 0;
            tv1.setLayoutParams(lp);
        }
    };

    private Runnable mUpdateTv2Runnable = new Runnable() {
        @Override
        public void run() {
            LayoutParams lp = (LayoutParams) tv2.getLayoutParams();
            lp.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            lp.weight = 0;
            tv2.setLayoutParams(lp);
        }
    };
}
