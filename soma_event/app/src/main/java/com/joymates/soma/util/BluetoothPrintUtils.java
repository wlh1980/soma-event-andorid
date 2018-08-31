package com.joymates.soma.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

import com.blankj.utilcode.util.ToastUtils;
import com.joymates.soma.R;
import com.joymates.soma.util.bluetoothprinter.ESCUtil;

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

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inTargetDensity = 160;
        options.inDensity = 160;
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.soma_qrcode, options);
        bitmap = scaleImage(bitmap);

        BluetoothUtil.sendData(ESCUtil.printBitmap(bitmap, 0));

        BluetoothUtil.sendData("\n\n");
        String title = content;
        BluetoothUtil.selectCommand(BluetoothUtil.ALIGN_CENTER);//居中
        BluetoothUtil.sendData(title + "\n\n\n\n");
    }


    private static Bitmap scaleImage(Bitmap bitmap1) {
        int width = bitmap1.getWidth();
        int height = bitmap1.getHeight();
        // 设置想要的大小
        int newWidth = (width / 8 + 1) * 8;
        // 计算缩放比例
        float scaleWidth = ((float) newWidth) / width;
        // 取得想要缩放的matrix参数
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, 1);
        // 得到新的图片
        return Bitmap.createBitmap(bitmap1, 0, 0, width, height, matrix, true);
    }
}
