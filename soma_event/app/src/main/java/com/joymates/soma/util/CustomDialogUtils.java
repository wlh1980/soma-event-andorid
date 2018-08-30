package com.joymates.soma.util;

import android.content.Context;
import android.support.annotation.StringRes;
import android.view.View;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.joymates.soma.R;

/**
 * ProjectName：somaApp
 * PackageName：com.joymates.soma.util
 * ClassDescribe：自定义弹出框
 * CreaterBy：SongGang
 * CreateDate：2018/6/13 11:01
 * Remark：
 */
public class CustomDialogUtils {

    public interface ICustomDialogClickListener {
        void onClick();
    }

    public static void showCustomDialog(Context context, @StringRes int content, final ICustomDialogClickListener
            iConfirmListener, final ICustomDialogClickListener iCancelListener) {

        final MaterialDialog qDialog = new MaterialDialog.Builder(context)
                .customView(R.layout.dialog_common_prompt, false)
                .build();
        View view = qDialog.getCustomView();
        if (view != null) {

            TextView tvContent = view.findViewById(R.id.dialog_prompt_tv_content);
            TextView tvCancel = view.findViewById(R.id.dialog_prompt_tv_cancel);
            TextView tvConfirm = view.findViewById(R.id.dialog_prompt_tv_confirm);

            tvContent.setText(content);
            tvCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    qDialog.cancel();
                    iCancelListener.onClick();
                }
            });
            tvConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    qDialog.cancel();
                    iConfirmListener.onClick();
                }
            });


            qDialog.show();
        }
    }

    public static void showCustomDialogTip(Context context, @StringRes int tips, @StringRes int content, final
    ICustomDialogClickListener
            iConfirmListener, final ICustomDialogClickListener iCancelListener) {

        final MaterialDialog qDialog = new MaterialDialog.Builder(context)
                .customView(R.layout.dialog_common_prompt, false)
                .cancelable(false)
                .build();
        View view = qDialog.getCustomView();
        if (view != null) {
            TextView tvTip = view.findViewById(R.id.dialog_prompt_tv_tips);
            TextView tvContent = view.findViewById(R.id.dialog_prompt_tv_content);
            TextView tvCancel = view.findViewById(R.id.dialog_prompt_tv_cancel);
            TextView tvConfirm = view.findViewById(R.id.dialog_prompt_tv_confirm);

            tvTip.setText(tips);
            tvContent.setText(content);
            tvCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    qDialog.cancel();
                    iCancelListener.onClick();
                }
            });
            tvConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    qDialog.cancel();
                    iConfirmListener.onClick();
                }
            });


            qDialog.show();
        }
    }

    public static void showCustomDialogTip(Context context, @StringRes int tips, @StringRes int content, final
    ICustomDialogClickListener iConfirmListener) {

        final MaterialDialog qDialog = new MaterialDialog.Builder(context)
                .customView(R.layout.dialog_common_prompt, false)
                .build();
        View view = qDialog.getCustomView();
        if (view != null) {
            TextView tvTip = view.findViewById(R.id.dialog_prompt_tv_tips);
            TextView tvContent = view.findViewById(R.id.dialog_prompt_tv_content);
            TextView tvCancel = view.findViewById(R.id.dialog_prompt_tv_cancel);
            TextView tvConfirm = view.findViewById(R.id.dialog_prompt_tv_confirm);

            tvTip.setText(tips);
            tvContent.setText(content);
            tvCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    qDialog.cancel();
                }
            });
            tvConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    qDialog.cancel();
                    iConfirmListener.onClick();
                }
            });


            qDialog.show();
        }
    }
}
