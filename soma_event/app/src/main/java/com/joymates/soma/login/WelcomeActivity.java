package com.joymates.soma.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;

import com.blankj.utilcode.util.StringUtils;
import com.joymates.common.base.BaseActivity;
import com.joymates.soma.MainActivity;
import com.joymates.soma.R;
import com.joymates.soma.util.Utils;
import com.joymates.soma.xml.TokenXML;


public class WelcomeActivity extends BaseActivity {
    private static final int WELCOME_DISPLAY_LENGTH = 2000;


    private Handler mHandler;

    private boolean isFinish;//是否删除

    @Override
    public void setLayout() {

        updateDB();

        // 避免从桌面启动程序后，会重新实例化入口类的activity
        if (!this.isTaskRoot()) {
            Intent intent = getIntent();
            if (intent != null) {
                String action = intent.getAction();
                if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) && Intent.ACTION_MAIN.equals(action)) {
                    finish();
                    isFinish = true;
                    return;
                }
            }
        }

        // 全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_welcome);
//        StatusBarUtil.setTransparent(this);

        hideTitleBar();
    }

    public void updateDB() {
    }

    @SuppressLint("HandlerLeak")
    @Override
    public void setHandler() {

        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
            }
        };
    }

    private void gotoNext() {

        if (isFinish) {
            isFinish = false;
            return;
        }


        if (StringUtils.isEmpty(TokenXML.getToken())) {
            Utils.gotoActivity(this, LoginActivity.class, true, null, null);
        } else {
            //其他角色
            Utils.gotoActivity(this, MainActivity.class, true, null, null);
        }
    }

    @Override
    public void initMember() {
//        BluetoothUtil.connectBlueTooth(this);//连接蓝牙

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                gotoNext();
            }
        }, WELCOME_DISPLAY_LENGTH);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                setPending();
//            }
//        }).start();
    }


    @Override
    public void setListener() {

    }
}
