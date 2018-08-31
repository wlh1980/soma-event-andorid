package com.joymates.soma.login;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.blankj.utilcode.util.CacheUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.StringUtils;
import com.joymates.common.base.BaseActivity;
import com.joymates.soma.MainActivity;
import com.joymates.soma.R;
import com.joymates.soma.constant.SPConstants;
import com.joymates.soma.entity.LoginVO;
import com.joymates.soma.entity.UserVO;
import com.joymates.soma.http.MsgTypes;
import com.joymates.soma.http.ResultCode;
import com.joymates.soma.http.business.LoginBusiness;
import com.joymates.soma.util.CustomDialogUtils;
import com.joymates.soma.util.Utils;
import com.joymates.soma.xml.TokenXML;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * ProjectName：somaMerchantApp
 * PackageName：com.joymates.soma.login
 * ClassDescribe：
 * CreaterBy：SongGang
 * CreateDate：2018/7/11 10:18
 * Remark：
 */
public class LoginActivity extends BaseActivity {


    @BindView(R.id.email)
    AutoCompleteTextView email;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.email_sign_in_button)
    Button emailSignInButton;
//    private Handler mHandler;

    @Override
    public void setLayout() {
        // 全屏
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
//        hideTitleBar();
        mIbLeft.setVisibility(View.GONE);
        setTitle(getString(R.string.login));

    }

    @Override
    public void setHandler() {
        mHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                switch (msg.what) {
                    case MsgTypes.LOGIN_SUCCESS:
                        loginSuccess(((LoginVO) msg.obj));
                        break;
                    case MsgTypes.LOGIN_FAILED:
                        toast(((String) msg.obj));
                        break;
                }
                return false;
            }
        });
    }

    private void loginSuccess(LoginVO obj) {
        if (ResultCode.CODE_SUCCESS == obj.getCode()) {
            toast(getString(R.string.login_success));
            /* 保存 Token and User Information */
            TokenXML.saveToken(obj.getToken());

//            UserVO user = obj.getUser();
//            CacheUtils.getInstance("UserData").put("User", user);

//            if (user != null) {
//                AccountXML.saveMerchantId(String.valueOf(user.getMerchantId()));
//            }

            Utils.gotoActivity(LoginActivity.this, MainActivity.class, true, null, null);


            //选择打印方式
//            selectPrintWay(obj);


        } else {
            toast(getString(R.string.account_or_password_wrong));
        }
    }

    /**
     * 选择打印方式
     */
    public void selectPrintWay(final LoginVO obj) {
        //如果登录用户是收银员选择打印方式
        CustomDialogUtils.showCustomDialogTip(this, R.string.order_print_way, R.string
                .order_print_choose_clout_print, new CustomDialogUtils.ICustomDialogClickListener() {
            @Override
            public void onClick() {
                //确认选择云打印的方式
                SPUtils.getInstance().put(SPConstants.KEY_SELECT_PRINT_WAY, SPConstants.VALUE_PRINT_WAY_CLOUD);

                Utils.gotoActivity(LoginActivity.this, MainActivity.class, true, null, null);
            }
        }, new CustomDialogUtils.ICustomDialogClickListener() {
            @Override
            public void onClick() {
                //不选择云打印的方式

                Utils.gotoActivity(LoginActivity.this, MainActivity.class, true, null, null);
            }
        });
    }

    @Override
    public void initMember() {

    }

    @Override
    public void setListener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.email_sign_in_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.email_sign_in_button:
                //登录
                login();
                break;
        }
    }

    /**
     * 商户登录
     */
    public void login() {
        String account = email.getText().toString();
        String pwd = password.getText().toString();
        if (StringUtils.isEmpty(account)) {
            toast(getString(R.string.login_edit_account));
            return;
        }
        if (StringUtils.isEmpty(pwd)) {
            toast(getString(R.string.login_edit_password));
            return;
        }

        LoginBusiness.login(this, mHandler, account, pwd);
    }


}
