package com.joymates.soma.util;

import android.annotation.SuppressLint;
import android.content.Context;

import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.joymates.soma.R;
import com.joymates.soma.constant.SomaConstants;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * ProjectName：somaMerchantApp
 * PackageName：com.joymates.soma.util
 * ClassDescribe：
 * CreaterBy：SongGang
 * CreateDate：2018/7/19 10:50
 * Remark：
 */
public class BluetoothPrintUtils {


    /**
     * 打印编号
     *
     * @param context
     * @param content 文本信息
     */
    public static void printOrderQueueNo(Context context, String content) {
        if (BluetoothUtil.getBTAdapter() == null) {
            ToastUtils.showShort(R.string.toast_3);
            return;
        }
        if (!BluetoothUtil.getBTAdapter().isEnabled()) {
            ToastUtils.showShort(R.string.toast_4);
            return;
        }

        BluetoothUtil.connectBlueTooth(context);

        String title = content;
        BluetoothUtil.selectCommand(BluetoothUtil.DOUBLE_HEIGHT_WIDTH);//宽高加倍
        BluetoothUtil.selectCommand(BluetoothUtil.BOLD);//加粗
        BluetoothUtil.selectCommand(BluetoothUtil.ALIGN_CENTER);//居中
        BluetoothUtil.sendData(title + "\n\n\n\n");
    }


}
