package com.joymates.soma.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.joymates.soma.R;
import com.nexgo.oaf.apiv3.APIProxy;
import com.nexgo.oaf.apiv3.DeviceEngine;
import com.nexgo.oaf.apiv3.device.printer.AlignEnum;
import com.nexgo.oaf.apiv3.device.printer.DotMatrixFontEnum;
import com.nexgo.oaf.apiv3.device.printer.FontEntity;
import com.nexgo.oaf.apiv3.device.printer.OnPrintListener;
import com.nexgo.oaf.apiv3.device.printer.Printer;

/**
 * ProjectName：somaMerchantApp
 * PackageName：com.joymates.soma.util
 * ClassDescribe：新国都智能pos机打印小票
 * CreaterBy：SongGang
 * CreateDate：2018/8/14 11:56
 * Remark：
 */
public class XGDPrinteUtils {

    private static Printer printer;
    private static FontEntity fontNormal = new FontEntity(DotMatrixFontEnum.CH_SONG_24X24, DotMatrixFontEnum
            .ASC_SONG_12X24);
    private static FontEntity fontBold = new FontEntity(DotMatrixFontEnum.CH_SONG_24X24, DotMatrixFontEnum
            .ASC_SONG_BOLD_16X24);
    private static FontEntity fontBig = new FontEntity(DotMatrixFontEnum.CH_SONG_24X24, DotMatrixFontEnum
            .ASC_SONG_12X24, false, true);


    /**
     * 打印订单编号
     *
     * @param context
     * @param content
     */
    public static void printOrderQueueNo(Context context, String content) {
        if (printer == null) {
            DeviceEngine deviceEngine = APIProxy.getDeviceEngine();
            printer = deviceEngine.getPrinter();
        }
        printer.initPrinter();

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.soma_qrcode);
        printer.appendImage(bitmap, AlignEnum.CENTER);

        printer.appendPrnStr(content, fontNormal, AlignEnum.CENTER);
        printer.startPrint(true, new OnPrintListener() {
            @Override
            public void onPrintResult(final int retCode) {
            }
        });
    }


}
