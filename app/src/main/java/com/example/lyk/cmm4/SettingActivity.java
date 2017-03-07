package com.example.lyk.cmm4;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import kankan.wheel.widget.OnWheelChangedListener;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.adapters.ArrayWheelAdapter;

public class SettingActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private int mTheme;
    private int mOrien;
    private int mSize;
    private String[] themes = {"黑色", "灰色", "白色"};
    private String[] oriens = {"竖屏", "横屏"};
    private String[] sizes;
    private ScrollView mScollView;
    private int mY;//手指按下的位置
    private boolean cancleUp = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        findViewById(R.id.tv_title).setVisibility(View.VISIBLE);
        mToolbar.setNavigationIcon(R.mipmap.back);
        mToolbar.setTitle("返回");
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.screen_setting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showWheelView(oriens, 1);
            }
        });
        final View interface_setting = findViewById(R.id.interface_setting);
        interface_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showWheelView(themes, 0);
            }
        });
        sizes = new String[50];
        for (int i = 0; i < sizes.length; i++) {
            sizes[i] = "" + (i + 1);
        }
        findViewById(R.id.textsize_setting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showWheelView(sizes, 2);
            }
        });
        mScollView = (ScrollView) findViewById(R.id.scroll);
        final Handler handler = new Handler();
        mScollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mY = (int) motionEvent.getY();
                        cancleUp = true;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int delta = (((int) motionEvent.getY() - mY) / 10);
                        mY = (int) motionEvent.getY();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) interface_setting.getLayoutParams();
                        if (delta > 0) {
                            if(layoutParams.topMargin<=Setting.dip2px(SettingActivity.this,120))
                                layoutParams.topMargin += Setting.dip2px(SettingActivity.this, delta);
                        } else if (layoutParams.topMargin - Setting.dip2px(SettingActivity.this, -delta) > 0)
                            layoutParams.topMargin -= Setting.dip2px(SettingActivity.this, -delta);
                        else
                            layoutParams.topMargin = Setting.dip2px(SettingActivity.this, 0);
                        interface_setting.setLayoutParams(layoutParams);
                        break;
                    case MotionEvent.ACTION_UP:
                        cancleUp = false;
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                final LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) interface_setting.getLayoutParams();
                                while (!cancleUp && layoutParams.topMargin >= 0) {
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            if (layoutParams.topMargin - Setting.dip2px(SettingActivity.this, 12) >= 0)
                                                layoutParams.topMargin -= Setting.dip2px(SettingActivity.this, 12);
                                            else
                                                layoutParams.topMargin = Setting.dip2px(SettingActivity.this, 0);
                                            interface_setting.setLayoutParams(layoutParams);
                                        }
                                    });
                                    try {
                                        Thread.sleep(20);
                                    } catch (Exception e) {

                                    }
                                }
                            }
                        }).start();

                }
                return false;
            }
        });
    }

    private void showWheelView(String info[], final int index) {
        View view = LayoutInflater.from(SettingActivity.this).inflate(R.layout.setting_wheelview, null);
        //   view.setBackgroundColor(getResources().getColor(R.color.darkblue));
        WheelView wheelView = (WheelView) view.findViewById(R.id.wheelview);
        wheelView.setViewAdapter(new ArrayWheelAdapter<String>(SettingActivity.this, info));
        switch (index) {
            case 0:
                mTheme = Setting.getTheme(SettingActivity.this);
                wheelView.setCurrentItem(mTheme);
                break;
            case 1:
                mOrien = Setting.getScreenOriention(SettingActivity.this);
                wheelView.setCurrentItem(mOrien);
                break;
            case 2:
                mSize = Setting.getTextSize(SettingActivity.this);
                wheelView.setCurrentItem(mSize);
                break;
        }
        wheelView.setVisibleItems(5);
        wheelView.addChangingListener(new OnWheelChangedListener() {
            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                switch (index) {
                    case 0:
                        mTheme = newValue;
                        break;
                    case 1:
                        mOrien = newValue;
                        break;
                    case 2:
                        mSize = newValue;
                        break;
                }
            }
        });
        AlertDialog.Builder builder = new AlertDialog.Builder(SettingActivity.this, R.style.CustomDialog)
                .setView(view).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (index) {
                            case 0:
                                Setting.setTheme(SettingActivity.this, mTheme);
                                break;
                            case 1:
                                Setting.setScreenOriention(SettingActivity.this, mOrien);
                                break;
                            case 2:
                                Setting.setTextSize(SettingActivity.this, mSize);
                        }
                    }
                })
                .setNegativeButton("取消", null).setCancelable(true);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
