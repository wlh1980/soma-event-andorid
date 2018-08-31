package com.joymates.soma;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.joymates.common.ResultCode;
import com.joymates.common.base.BaseActivity;
import com.joymates.soma.entity.SaveDiscount;
import com.joymates.soma.http.MsgTypes;
import com.joymates.soma.http.business.LoginBusiness;
import com.joymates.soma.setting.SettingActivity;
import com.joymates.soma.util.PrinterUtils;
import com.joymates.soma.util.Utils;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_tv_num)
    TextView mainTvNum;
    @BindView(R.id.main_tv_print)
    TextView mainTvPrint;

    @Override
    public void setLayout() {
        mIbLeft.setVisibility(View.GONE);
        setContentView(R.layout.activity_main);

        setTitle(R.string.main_print);
        mTvRight.setText(R.string.main_menu_setting);
        mTvRight.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.main_tv_print)
    public void onViewClicked() {
        //打印
        getNetData();
    }


    @Override
    public void setHandler() {
        mHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case MsgTypes.DISCOUNT_SAVE_SUCCESS://调用发放优惠券接口成功
                        SaveDiscount saveDiscount = (SaveDiscount) message.obj;
                        doDiscountSaveSuccess(saveDiscount);
                        break;
                    case MsgTypes.DISCOUNT_SAVE_FAILED://调用发放优惠券接口失败
                        toast(String.valueOf(message.obj));
                        break;
                }
                return false;
            }
        });
    }

    private void doDiscountSaveSuccess(SaveDiscount saveDiscount) {
        if (saveDiscount.getCode() == ResultCode.CODE_SUCCESS) {
            String data = saveDiscount.getData();
            PrinterUtils.printQRCode(this, data);
        }
    }

    @Override
    public void initMember() {

    }

    private void getNetData() {
        LoginBusiness.saveDiscount(this, mHandler);
    }

    @Override
    public void setListener() {
        mTvRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //进入设置页面
                ActivityUtils.startActivity(SettingActivity.class);
            }
        });
    }
}
