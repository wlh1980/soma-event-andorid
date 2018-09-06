package com.joymates.soma.printHttp;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.alibaba.fastjson.JSONObject;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.LogUtils;
import com.joymates.soma.R;
import com.joymates.soma.entity.BaseVO;
import com.joymates.soma.http.ResultCode;
import com.joymates.soma.util.MaterialDialogUtils;
import com.joymates.soma.util.Utils;
import com.joymates.soma.xml.TokenXML;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.zyao89.view.zloading.ZLoadingDialog;
import com.zyao89.view.zloading.Z_TYPE;

import java.io.File;
import java.util.List;
import java.util.Map;

//import com.joymates.soma.entity.OrderEntity;
//import com.joymates.soma.entity.OrderEntity_Table;

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

                        //判断令牌是否有效
                        checkTokenSuccess(context, response.body());

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

                        //判断令牌是否有效
                        checkTokenSuccess(context, response.body());

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

    /**
     * 判断令牌是否有效
     *
     * @param context
     * @param data
     */
    public static void checkTokenSuccess(final Context context, String data) {
        //判断令牌是否有效
        BaseVO vo = JSONObject.parseObject(data, BaseVO.class);
        if (vo.getCode() == ResultCode.CODE_401) {
            //令牌无效，去重新登录

            if (materialDialog != null && materialDialog.isShowing()) {
                return;
            }

            materialDialog = MaterialDialogUtils.showNOneBtnDialogOnlyOne(context, R.string.token_failure, new
                    MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                            TokenXML.clean();
                            ActivityUtils.finishAllActivities();
                            Utils.goLogin(context);
                        }
                    });
        }
    }

}
