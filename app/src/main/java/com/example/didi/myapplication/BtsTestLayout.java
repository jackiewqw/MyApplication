package com.example.didi.myapplication;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by didi on 16/7/30.
 */
public class BtsTestLayout extends LinearLayout {
    TextView tv1;
    TextView tv2;

    public BtsTestLayout(Context context) {
        super(context);
        initView();
    }

    public BtsTestLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
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

    boolean isTextChanged = false;

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if( isTextChanged){
            int count1 = 0, count2 = 0;
            Layout l1 = tv1.getLayout();
            if (l1 != null && l1.getLineCount() > 0) {
                count1 = l1.getEllipsisCount(0);
            }
            Layout l2 = tv2.getLayout();
            if (l2 != null && l2.getLineCount() > 0) {
                count2 = l2.getEllipsisCount(0);
            }

            Log.e("wqw", "count1="+count1+"; count2="+count2);
            if (count1 > 0 && count2 <= 0) {

                LayoutParams lp = (LayoutParams) tv2.getLayoutParams();
                lp.width = ViewGroup.LayoutParams.WRAP_CONTENT;
                lp.weight = 0;
                tv2.setLayoutParams(lp);
                invalidate();

            } else if (count1 <= 0 && count2 > 0) {
                LayoutParams lp = (LayoutParams) tv1.getLayoutParams();
                lp.width = ViewGroup.LayoutParams.WRAP_CONTENT;
                lp.weight = 0;
                tv1.setLayoutParams(lp);
                invalidate();
            }

            isTextChanged= false;
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
        invalidate();
    }
}
