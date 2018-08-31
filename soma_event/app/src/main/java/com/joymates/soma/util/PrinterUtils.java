package com.joymates.soma.util;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.blankj.utilcode.util.SPUtils;
import com.joymates.soma.constant.SPConstants;
import com.joymates.soma.printHttp.PrintBusiness;
import com.joymates.soma.util.sqbprinter.SQBPrinterUtils;

/**
 * ProjectName：somaMerchantApp
 * PackageName：com.joymates.soma.util
 * ClassDescribe：打印订单小票
 * CreaterBy：SongGang
 * CreateDate：2018/8/14 14:18
 * Remark：
 */
public class PrinterUtils {

    static Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            return false;
        }
    });


    /**
     * 打印二维码和文本
     *
     * @param context
     * @param content
     */
    public static void printQRCode(Context context, String content) {
        //蓝牙打印
        BluetoothPrintUtils.printOrderQueueNo(context, content);
    }

//    public static void printOrderQueueNo(Context context, String content) {
//        if (SPConstants.VALUE_PRINT_WAY_CLOUD.equals(SPUtils.getInstance().getString(SPConstants
//                .KEY_SELECT_PRINT_WAY))) {
//            //云打印编号
//            PrintBusiness.sendMsg(context, mHandler, content,
//                    CloudPrintUtils.getPrintOrderQueueNo(context, content));
//        } else {
//            if ("N5".equals(android.os.Build.MODEL)) {
//                //N5设备打印编号
//                XGDPrinteUtils.printOrderQueueNo(context, content);
//            } else if ("A920".equals(android.os.Build.MODEL)) {
//                //A920收钱吧设备打印小票
//                SQBPrinterUtils.printOrderQueueNo(context, content);
//            } else {
//                //蓝牙打印编号
//                BluetoothPrintUtils.printOrderQueueNo(context, content);
//            }
//        }
//    }
}
