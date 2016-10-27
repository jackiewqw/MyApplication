package com.example.didi.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Selection;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String postfix = "[猜你要去]";
    String[] strArray = new String[]{"你好",
            "你噶事垫嘎达搜嘎速度的噶啥速度噶",
            "你噶事大嘎达搜嘎速度的等噶速度噶啥",
            "你噶事大嘎达搜嘎速度的等噶速度噶啥收",
            "你噶事大嘎达搜嘎速啥等噶速度噶啥等噶收",
            "你噶事大嘎达搜度噶啥等噶速度噶啥等的噶收",
            "你噶事大嘎嘎速度噶啥等噶速度噶啥等噶的的收",
            "你噶事达搜嘎速度噶啥等噶速度噶啥等的的的噶收",
            "你大嘎达搜嘎速度噶啥等噶速度噶啥等噶的是是是收",
            "你大嘎达搜嘎速度噶啥等噶速度噶啥等的的的的的噶收",
            "你大嘎达搜大大噶啥等噶嘎速度噶啥等噶速度噶啥等噶收到嘎大概大噶啥等噶"};
    int i = 1;

    int j = 0;

    String sStr1 = "前门";
    String lStr1 = "北京首都机场第三航站楼";

    String sStr2 = "得实大厦";
    String lStr2 = "中关村广场太平洋美食城5档口中国兰州拉面";

    BtsTestLayout btl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv = (TextView) findViewById(R.id.test_tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ObjectAnimator oa = ObjectAnimator.ofObject(tv, "textColor", new ArgbEvaluator(), 0x00000000, 0xff000000);
//                oa.setDuration(5000);
//                oa.start();
                updateView(tv);

//                Uri uri = Uri.parse("btsscheme:dgasdgads");
//                Intent intent = new Intent();
//                intent.setData(uri);
//                startActivity(intent);

                Intent intent = new Intent(MainActivity.this, ImageScaleActivity.class);
                startActivity(intent);
            }
        });
        updateView(tv);
        //tv.performClick();

        btl = (BtsTestLayout) findViewById(R.id.operation_container);
        btl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateOperation();
            }
        });


        final Handler h = new Handler();
        final Runnable r = new Runnable() {
            @Override
            public void run() {
                updateOperation();
                h.postDelayed(this, 5000);
            }
        };
        h.postDelayed(r, 5000);

        TestEnum te = TestEnum.ERROR;
        te.toString();

        Toast.makeText(this, "gadg", Toast.LENGTH_SHORT);

        Toast.makeText(this, "ggadgadg", Toast.LENGTH_LONG);

        show();

        BtsTraceLog
                .add("key1")
                .report();
    }

    private void show() {
    }

    public void updateOperation() {
        BtsTraceLog
                .add("key1")
                .put("param1", "value1")
                .report();
        switch (j) {
            case 0:
                btl.setText(sStr1, sStr2);
                break;
            case 1:
                btl.setText(lStr1, lStr2);
                break;
            case 2:
                btl.setText(sStr1, lStr2);
                break;
            case 3:
                btl.setText(lStr1, sStr2);
                break;
        }
        if (++j > 3) {
            j = 0;
        }
    }

    public void updateView(final TextView tv) {
        if (i >= strArray.length) {
            i = 0;
        }
        BtsTraceLog
                .add("key1")
                .put("param1", "value1");

        final String content = strArray[i++];
        if (tv.getWidth() == 0) {
            Log.i("TextMesure", "updateView width=0");
            tv.post(new Runnable() {
                @Override
                public void run() {
                    setEndAddressRecommendTextImpl(tv, content, postfix);
                    //update(tv);
                }
            });
        } else {
            setEndAddressRecommendTextImpl(tv, content, postfix);
            Log.i("TextMesure", "updateView width!=0");
            //update(tv);
        }

    }

    private void setEndAddressRecommendTextImpl(TextView tv, String address, String postfix) {
        float contentWidth = tv.getPaint().measureText(address + postfix);
        float tvWidthWithoutPadding = tv.getWidth() - tv.getPaddingLeft() - tv.getPaddingRight();
        float postfixWidth = tv.getPaint().measureText(postfix);
        float widthExceptFirstLine = contentWidth - tvWidthWithoutPadding;
        boolean isAutoNewLine = widthExceptFirstLine > 0 && widthExceptFirstLine < postfixWidth;

        StringBuilder sb = new StringBuilder();
        sb.append(address);
        if (isAutoNewLine) {
            sb.append("<br>");
        }
        sb.append("<font color=\"#adadad\">");
        sb.append(postfix);
        sb.append("</font>");


        tv.setText(Html.fromHtml(sb.toString()));

        BtsTraceLog
                .add("key2");

    }

    public void update(TextView tv) {
        BtsTraceLog
                .add("key1")
                .put("param1", "value1")
                .put("param2", "value3")
                .report();

        if (i >= strArray.length) {
            i = 0;
        }
        String temp = strArray[i++];
        Log.i("TextMesure", "width=" + tv.getWidth());
        Log.i("TextMesure", "2 width=" + findViewById(R.id.test_tv_2).getWidth());
        Log.i("TextMesure", "3 width=" + findViewById(R.id.test_tv_3).getWidth());

        // tv.setText(temp);
        float currentSize = tv.getTextSize();
        float size = tv.getPaint().measureText(temp);
        Log.e("TextMesure", "text size = " + currentSize);
        Log.e("TextMesure", "total size = " + size);
        float tempSize = tv.getPaint().measureText(postfix);

        float secondSize = size - (tv.getWidth() - tv.getPaddingLeft() - tv.getPaddingRight());
        Log.e("TextMesure", "second line size = " + secondSize);
        Log.e("TextMesure", "postfix  size = " + tempSize);
//        if( secondSize >0 && secondSize < tempSize){
//            temp = temp.substring(0, temp.length()-postfix.length());
//            temp += "\n";
//            temp += postfix;
//            tv.setText(temp);
//        }else{
        tv.setText(temp);
//        }
    }

    private void dagasdg() {
        BtsTraceLog
                .add("key1")
                .put("param1", "value1")
                .put("param2", "value3")
                .report();

        Log.e("tag", "value");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("wqw", "MainActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("wqw", "MainActivity onDestroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("wqw", "MainActivity onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("wqw", "MainActivity onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("wqw", "MainActivity onPause");
    }
}
