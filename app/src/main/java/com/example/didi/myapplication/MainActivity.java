package com.example.didi.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SynthesizerListener;
import com.jakewharton.scalpel.ScalpelFrameLayout;

import java.lang.reflect.Proxy;

public class MainActivity extends AppCompatActivity{

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

    String[] ttsArray = new String[]{
            "为什么美国的零售价30块美金的衬衣就很好?",
            "我认为我找到了中国制造业最难的问题，其实是整个中国社会效率低下。",
            "因为效率低下之后，我们为了把东西卖出去，我们花在市场，花在营销，花在渠道，花在店面，花在促销上的钱实在太多了。",

            "所以我们整个制造业和品牌厂商就拼命压缩成本，原材料成本，制造过程中能不能减少工序，努力把产品成本做到最低。",
            "衬衣怎么减材料?挺简单的，你把衬衣做的短一点就可以了，把袖子做的短一点，大家别笑，我们国产的绝大部分衬衣，出去你挤地铁，手伸起来一抓手就露出来了。",
            "这样抠成本就导致产品和设计都有问题。",
            "美国为什么三四十块钱的衬衣就没有问题?是因为美国这个社会的效率比我们高很多。",
            "基于这一点我认为我找到了让中国制造业转型升级的秘诀，就是全方位的改善效率，能不能把钱，把绝大部分的钱花在产品本身上，而不是找一百万人像卖保险一样卖产品，或者卖保健品一样卖产品，这不是常态。",
    };

    int ttsIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toast = Toast.makeText(this, "确定退出？", Toast.LENGTH_SHORT);
        new Abc().funcA();

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

                Intent intent = new Intent(MainActivity.this, MapUriSchemeTestActivity.class);
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


//        final Handler h = new Handler();
//        final Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                updateOperation();
//                h.postDelayed(this, 5000);
//            }
//        };
//        h.postDelayed(r, 5000);

        //Log.e("HandlerTest", "post delay execute");
//        for (int i = 0; i < 100; ++i) {
//            final int tag = i;
//            final Runnable r1 = new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    Log.i("HandlerTest", "post x " + tag);
//                }
//            };
//            h.post(r1);
//        }
//
//        h.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Log.e("HandlerTest", "post delay");
//            }
//        }, 1000);


//        for (int i = 0; i < 100; ++i) {
//            final int tag = i;
//            final Runnable r1 = new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    Log.i("HandlerTest", "post y " + tag);
//                }
//            };
//            h.post(r1);
//        }

        TestEnum te = TestEnum.ERROR;
        te.toString();

        Toast.makeText(this, "gadg", Toast.LENGTH_SHORT);

        Toast.makeText(this, "ggadgadg", Toast.LENGTH_LONG);

        show();

        BtsTraceLog
                .add("key1")
                .report();

        startPlayTts();

        ScalpelFrameLayout layout = (ScalpelFrameLayout) findViewById(R.id.scalpel_layout);
        layout.setLayerInteractionEnabled(false);

        startActivity(new Intent(this, AActivity.class));
    }

    private void startPlayTts() {
        BtsTtsPlayer.setTtsListener(new SynthesizerListener() {
            @Override
            public void onSpeakBegin() {

            }

            @Override
            public void onBufferProgress(int i, int i1, int i2, String s) {

            }

            @Override
            public void onSpeakPaused() {

            }

            @Override
            public void onSpeakResumed() {

            }

            @Override
            public void onSpeakProgress(int i, int i1, int i2) {

            }

            @Override
            public void onCompleted(SpeechError speechError) {
                if (ttsIndex >= ttsArray.length) {
                    return;
                }
                playTts();
                //BtsTtsPlayer.playTts(MainActivity.this, ttsArray[ttsIndex++]);
            }

            @Override
            public void onEvent(int i, int i1, int i2, Bundle bundle) {

            }
        });
        playTts();
    }

    private void playTts() {
        //BtsTtsPlayer.playTts(this, ttsArray[ttsIndex++]);

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
        System.exit(0);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("wqw", "MainActivity onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("wqw", "MainActivity onResume");
        System.gc();

        MyDialogFragment df = new MyDialogFragment();
        df.setCancelable(true);
        df.show(getSupportFragmentManager(), "dgdad");
    }

    public static class MyDialogFragment extends DialogFragment {
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            LinearLayout ll = new LinearLayout(inflater.getContext());
            TextView tv = new TextView(inflater.getContext());
            tv.setText("测试对话框");
            ll.addView(tv);
            getDialog().setCanceledOnTouchOutside(false);
            return ll;
        }

        @Override
        public void onCancel(DialogInterface dialog) {
            super.onCancel(dialog);
            Toast.makeText(getContext(), "取消被回掉了", Toast.LENGTH_SHORT).show();
        }
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

    private Toast toast;

    @Override
    public void onBackPressed() {
        ///super.onBackPressed();
        if (null == toast.getView().getParent()) {
            toast.show();
        } else {
            System.exit(0);
        }
    }
}
