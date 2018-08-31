package com.joymates.soma.printHttp;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.afollestad.materialdialogs.MaterialDialog;
import com.alibaba.fastjson.JSONObject;
import com.blankj.utilcode.util.LogUtils;
import com.joymates.soma.R;
import com.joymates.soma.entity.BaseVO;
//import com.joymates.soma.entity.OrderEntity;
//import com.joymates.soma.entity.OrderEntity_Table;
import com.joymates.soma.http.ResultCode;
import com.joymates.soma.util.Utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.zyao89.view.zloading.ZLoadingDialog;
import com.zyao89.view.zloading.Z_TYPE;

import java.io.File;
import java.util.List;
import java.util.Map;

//import org.json.JSONObject;


/**
 * ProjectName：TuanLeApp
 * PackageName：com.joymates.tuanle.http
 * ClassDescribe：
 * CreaterBy：SongGang
 * CreateDate：2017/12/18 9:29
 * Remark：
 */
public class PrintHttpRequest {

    public static int REQUEST_TYPE_CLASS = 0;
    public static int REQUEST_TYPE_LIST = 1;
    public static int REQUEST_TYPE_JSON = 2;

    // 加载动画
    private static ZLoadingDialog loadingDialog;

    private static MaterialDialog materialDialog;


    private static void showLoading(Context context) {
        if (context instanceof Activity) {
            if (((Activity) context).isFinishing() || ((Activity) context).isDestroyed()) {
                return;
            }
        }
        /*显示加载动画*/
        loadingDialog = new ZLoadingDialog(context);
        loadingDialog.setLoadingBuilder(Z_TYPE.STAR_LOADING)
                .setLoadingColor(context.getResources().getColor(R.color.colorPrimary))
                .setHintText("Loading...")
                .setHintTextSize(16)
                .setHintTextColor(context.getResources().getColor(R.color.colorPrimary))
                .setCanceledOnTouchOutside(false)
                .setCancelable(true)
                .show();
    }


    public static boolean activityIsFinish(Context context) {
        if (context == null) {
            return true;
        }
        if (context instanceof Activity) {
            if (((Activity) context).isFinishing() || ((Activity) context).isDestroyed()) {
                return true;
            }
        }
        return false;
    }


    /**
     * 发送打印数据
     *
     * @param context
     * @param handler
     * @param url           上传地址
     * @param param         type
     * @param clazz         返回结果
     * @param type          返回类型
     * @param successState  成功码
     * @param errorState    失败码
     * @param isShowLoading 是否loading
     */
    public static void upFile(final Context context, final Handler handler, final String url, final Map<String,
            String> param,
                              final Class<?> clazz, final int type, final int successState, final int errorState,
                              boolean isShowLoading) {

        if (!Utils.isInternetAvailable(context)) {
            Message message = new Message();
            message.what = errorState;
            message.obj = "网络不给力";
            if (null != handler)
                handler.sendMessage(message);
            return;
        }

        if (isShowLoading)
            showLoading(context);

        final String orderId = param.get("msgNo");//订单号

        LogUtils.e(url + "参数：" + param);
        OkGo.<String>post(url)//
                .tag(context)//
                .params(param)
//                .params("file", file)
                .isMultipart(true)         //强制使用 multipart/form-data 表单上传（只是演示，不需要的话不要设置。默认就是false）
                .execute(new StringCallback() {

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        String orderId = request.getParams().urlParamsMap.get("msgNo").get(0);
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        if (null != loadingDialog) {
                            loadingDialog.dismiss();
                            loadingDialog = null;
                        }
                        LogUtils.e(response.body());
                        Message message = new Message();
                        message.what = successState;
                        if (REQUEST_TYPE_CLASS == type) {
                            message.obj = JSONObject.parseObject(response.body(), clazz);
                        } else if (REQUEST_TYPE_LIST == type) {
                            message.obj = JSONObject.parseArray(response.body(), clazz);
                        }


                        LogUtils.e("orderId=" + orderId);
//                        checkStatussuccess(context, orderId, response.body());
//                        BaseVO vo = JSONObject.parseObject(response.body(), BaseVO.class);
                        if (null != handler)
                            handler.sendMessage(message);
                    }


                    @Override
                    public void onError(Response<String> response) {
                        if (null != loadingDialog) {
                            loadingDialog.dismiss();
                            loadingDialog = null;
                        }
//                        response.getException().getMessage();
                        LogUtils.e(response.getException().getMessage());
                        Message message = new Message();
                        message.what = errorState;
                        message.obj = "网络不给力";
                        if (null != handler)
                            handler.sendMessage(message);
                    }
                });
    }


//    public static void checkStatussuccess(final Context context, final String orderId, String data) {
//
//        BaseVO vo = JSONObject.parseObject(data, BaseVO.class);
//
//        //获取订单数据
//        OrderEntity orderEntity = SQLite.select().from(OrderEntity.class).where(OrderEntity_Table.sn.eq(orderId))
//                .querySingle();
//        if (orderEntity == null) {
//            return;
//        }
//
//        if (vo.getCode() == ResultCode.CODE_SUCCESS) {
//            //发送打印数据成功
//            orderEntity.setIsSendMsg(OrderEntity.SEND_MSG_SUCCESS);
//        } else {
//            orderEntity.setIsSendMsg(OrderEntity.SEND_MSG_FAILED);
//        }
//        orderEntity.update();//更新数据库
//    }

    /**
     * 文件批量上传
     *
     * @param context
     * @param handler
     * @param url           上传地址
     * @param param         type
     * @param file          文件集合
     * @param clazz         返回结果
     * @param type          返回类型
     * @param successState  成功码
     * @param errorState    失败码
     * @param isShowLoading 是否loading
     */
    public static void batchUpFile(final Context context, final Handler handler, final String url, final Map<String,
            String> param, final List<File> file,
                                   final Class<?> clazz, final int type, final int successState, final int
                                           errorState, boolean isShowLoading) {

        if (!Utils.isInternetAvailable(context)) {
            Message message = new Message();
            message.what = errorState;
            message.obj = "网络不给力";
            if (null != handler)
                handler.sendMessage(message);
            return;
        }

        if (isShowLoading)
            showLoading(context);

        LogUtils.e(url + "参数：" + param);
        OkGo.<String>post(url)//
                .tag(context)//
                .params(param)
                .addFileParams("file", file)
                .isMultipart(true)         //强制使用 multipart/form-data 表单上传（只是演示，不需要的话不要设置。默认就是false）
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (null != loadingDialog) {
                            loadingDialog.dismiss();
                            loadingDialog = null;
                        }
                        LogUtils.e(response.body());
                        Message message = new Message();
                        message.what = successState;
                        if (REQUEST_TYPE_CLASS == type) {
                            message.obj = JSONObject.parseObject(response.body(), clazz);
                        } else if (REQUEST_TYPE_LIST == type) {
                            message.obj = JSONObject.parseArray(response.body(), clazz);
                        }

                        handler.sendMessage(message);
                    }


                    @Override
                    public void onError(Response<String> response) {
                        if (null != loadingDialog) {
                            loadingDialog.dismiss();
                            loadingDialog = null;
                        }
//                        response.getException().getMessage();
                        LogUtils.e(response.getException().getMessage());
                        Message message = new Message();
                        message.what = errorState;
                        message.obj = "网络不给力";
                        if (null != handler)
                            handler.sendMessage(message);
                    }
                });
    }


}
