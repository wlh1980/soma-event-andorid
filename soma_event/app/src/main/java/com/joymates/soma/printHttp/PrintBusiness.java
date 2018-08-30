package com.joymates.soma.printHttp;

import android.content.Context;
import android.os.Handler;

import com.joymates.common.http.HttpRequest;
import com.joymates.encryption.HashKit;
import com.joymates.soma.entity.BaseVO;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * ProjectName：somaMerchantApp
 * PackageName：com.joymates.soma.printHttp
 * ClassDescribe：
 * CreaterBy：SongGang
 * CreateDate：2018/7/23 17:21
 * Remark：
 */
public class PrintBusiness {

    private static final String PRINT_BASE_API = "http://api.poscom.cn";

    private static final String MERCHANT_MEMBER_CODE = "80a78fa1c60c431e8b83e0ad68f28ac0";//商户编码

    private static final String DEVICE_NO = "08868730037502633";//佳博网络云打印机的设备编码
//    private static final String DEVICE_NO = "08868730037519793";//佳博网络云打印机的设备编码

    private static final String API_KEY = "NH61HBYO";//apiKey

    public static void sendMsg(final Context context, Handler handler, String orderId, String msgDetail) {

        Map<String, String> map = new HashMap<>();
        String reqTime = String.valueOf(Calendar.getInstance().getTimeInMillis());
        map.put("reqTime", reqTime);

        String securityCode = MERCHANT_MEMBER_CODE + DEVICE_NO + orderId + reqTime + API_KEY;
        map.put("securityCode", HashKit.md5(securityCode));

        map.put("memberCode", MERCHANT_MEMBER_CODE);
        map.put("deviceNo", DEVICE_NO);
        map.put("mode", "3");//以16进制格式打印

        map.put("msgDetail", msgDetail);

        map.put("charset", "3");//参数 mode=1 或 mode=2 时，允许指定打印内容使用编码格式，（不填写）默认 charset=1，支持字符：
        //1:  GB18030       2: GB2312       3: GBK       4: UTF-8       5: Unicode       6: ISO8859-1       7:  BIG5
        map.put("msgNo", orderId);//订单编号
        map.put("reprint", "1");//是否重复打印1:是； 0:否。若是重新打印则系统允许 msgNo 字段重复

//        String json = JSON.toJSONString(map);

        PrintHttpRequest.upFile(context, handler, PRINT_BASE_API + PrintConstants.PRINT_SEND_MSG,
                map,
                BaseVO.class, HttpRequest.REQUEST_TYPE_CLASS,
                PrintMsgTypes.PRINTER_SEND_MSG_SUCCESS,
                PrintMsgTypes.PRINTER_SEND_MSG_FAILED, false);
    }
}
