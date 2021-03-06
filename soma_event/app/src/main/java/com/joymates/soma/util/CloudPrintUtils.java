package com.joymates.soma.util;

import android.annotation.SuppressLint;
import android.content.Context;

import java.nio.charset.Charset;

/**
 * ProjectName：somaMerchantApp
 * PackageName：com.joymates.soma.util
 * ClassDescribe：云打印
 * CreaterBy：SongGang
 * CreateDate：2018/7/26 10:48
 * Remark：
 */
public class CloudPrintUtils {

    /**
     * 佳博云打印时十六进制的格式
     */
    private static String CENTER = "1B6101";//居中
    private static String LEFT = "1B6100";//居左
    private static String RIGHT = "1B6102";//居右

    private static String DOUBLE_HEIGHT_WIDTH = "1D2111";//宽高放大
    private static String NORMAL_HEIGHT_WIDTH = "1D2100";//宽高不放大
    private static String DOUBLE_HEIGHT = "1D2101";//高放大

    private static String BOLD = "1B4501";//加粗
    private static String BOLD_CANCEL = "1B4500";//取消加粗

    private static String NEW_LINE = "0A";//换行



    /**
     * 打印编号
     *
     * @param context
     * @param content 订单信息
     */
    public static String getPrintOrderQueueNo(Context context, String content) {

        String qrCode="<gpQRCode>"+content+"</gpQRCode>";

        return qrCode+CENTER + DOUBLE_HEIGHT_WIDTH + BOLD + stringTo16(content);
    }



    public static String stringTo16(String str) {
        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        Charset charset = Charset.forName("gb2312");
        byte[] bs = str.getBytes(charset);
        int bit;

        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
//            sb.append(' ');
        }
        return sb.toString().trim();
    }





    /**
     * 打印纸一行最大的字节
     */
    private static final int LINE_BYTE_SIZE = 44;

    /**
     * 打印三列时，中间一列的中心线距离打印纸左侧的距离
     */
    private static final int LEFT_LENGTH = 22;

    /**
     * 打印三列时，中间一列的中心线距离打印纸右侧的距离
     */
    private static final int RIGHT_LENGTH = 22;

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

    /**
     * 打印两列
     *
     * @param leftText  左侧文字
     * @param rightText 右侧文字
     * @return
     */
    @SuppressLint("NewApi")
    private static String printTwoData(String leftText, String rightText) {
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
    private static String printThreeData(String leftText, String middleText, String rightText) {
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
