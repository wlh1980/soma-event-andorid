package com.joymates.soma.util.sqbprinter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.joymates.soma.R;

import java.nio.charset.Charset;

/**
 * ProjectName：somaMerchantApp
 * PackageName：com.joymates.soma.util
 * ClassDescribe：
 * CreaterBy：SongGang
 * CreateDate：2018/8/15 10:11
 * Remark：
 */
public class SQBPrinterUtils {


    /**
     * 打印订单编号
     *
     * @param context
     * @param content
     */
    public static void printOrderQueueNo(Context context, String content) {
        PrinterTester.getInstance(context).init();

        PrinterTester.getInstance(context).setDoubleWidth(false, false);
        PrinterTester.getInstance(context).setDoubleHeight(false, false);


        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
        PrinterTester.getInstance(context).printBitmap(bitmap);

        String title = content;

        PrinterTester.getInstance(context).printStr(printCenter(title) + "\n", null);


        PrinterTester.getInstance(context).printStr("\n\n\n", null);

        final String status = PrinterTester.getInstance(context).start();
    }


    /**
     * 打印纸一行最大的字节
     */
    private static final int LINE_BYTE_SIZE = 28;

    /**
     * 打印三列时，中间一列的中心线距离打印纸左侧的距离
     */
    private static final int LEFT_LENGTH = 14;

    /**
     * 打印三列时，中间一列的中心线距离打印纸右侧的距离
     */
    private static final int RIGHT_LENGTH = 14;

    /**
     * 打印三列时，第一列汉字最多显示几个文字
     */
    private static final int LEFT_TEXT_MAX_LENGTH = 5;

    /**
     * 获取数据长度
     *
     * @param msg
     * @return
     */
    @SuppressLint("NewApi")
    private static int getBytesLength(String msg) {
        return msg.getBytes(Charset.forName("GB2312")).length;
    }

    public static String printCenter(String centerText) {
        StringBuilder sb = new StringBuilder();
        int leftTextLength = getBytesLength(centerText);
        int marginBetweenMiddleAndRight = (LINE_BYTE_SIZE - leftTextLength) / 2;

        for (int i = 0; i < marginBetweenMiddleAndRight; i++) {
            sb.append(" ");
        }
        sb.append(centerText);
        return sb.toString();
    }

    /**
     * 打印两列
     *
     * @param leftText  左侧文字
     * @param rightText 右侧文字
     * @return
     */
    @SuppressLint("NewApi")
    public static String printTwoData(String leftText, String rightText) {
        StringBuilder sb = new StringBuilder();
        int leftTextLength = getBytesLength(leftText);
        int rightTextLength = getBytesLength(rightText);
        sb.append(leftText);

        // 计算两侧文字中间的空格
        int marginBetweenMiddleAndRight = LINE_BYTE_SIZE - leftTextLength - rightTextLength;

        for (int i = 0; i < marginBetweenMiddleAndRight; i++) {
            sb.append(" ");
        }
        sb.append(rightText);
        return sb.toString();
    }


    /**
     * 打印三列
     *
     * @param leftText   左侧文字
     * @param middleText 中间文字
     * @param rightText  右侧文字
     * @return
     */
    @SuppressLint("NewApi")
    public static String printThreeData(String leftText, String middleText, String rightText) {
        StringBuilder sb = new StringBuilder();
        // 左边最多显示 LEFT_TEXT_MAX_LENGTH 个汉字 + 两个点
//        if (leftText.length() > LEFT_TEXT_MAX_LENGTH) {
//            leftText = leftText.substring(0, LEFT_TEXT_MAX_LENGTH) + "..";
//        }
        int leftTextLength = getBytesLength(leftText);
        int middleTextLength = getBytesLength(middleText);
        int rightTextLength = getBytesLength(rightText);

        sb.append(leftText);
        // 计算左侧文字和中间文字的空格长度
        int marginBetweenLeftAndMiddle = LEFT_LENGTH - leftTextLength - middleTextLength / 2;

        for (int i = 0; i < marginBetweenLeftAndMiddle; i++) {
            sb.append(" ");
        }
        sb.append(middleText);

        // 计算右侧文字和中间文字的空格长度
        int marginBetweenMiddleAndRight = RIGHT_LENGTH - middleTextLength / 2 - rightTextLength;

        for (int i = 0; i < marginBetweenMiddleAndRight; i++) {
            sb.append(" ");
        }

        // 打印的时候发现，最右边的文字总是偏右一个字符，所以需要删除一个空格
        sb.delete(sb.length() - 2, sb.length()).append(rightText);
        return sb.toString();
    }
}
