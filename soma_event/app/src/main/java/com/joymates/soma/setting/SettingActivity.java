package com.joymates.soma.setting;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.SPUtils;
import com.joymates.common.base.BaseActivity;
import com.joymates.soma.R;
import com.joymates.soma.constant.SPConstants;
import com.joymates.soma.util.Utils;
import com.joymates.soma.xml.TokenXML;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * ProjectName：somaMerchantApp
 * PackageName：com.joymates.soma.setting
 * ClassDescribe：
 * CreaterBy：SongGang
 * CreateDate：2018/7/13 15:50
 * Remark：
 */
public class SettingActivity extends BaseActivity {
    LinearLayout settingsLlUpdateVersion;

    @Override
    public void setLayout() {
        setContentView(R.layout.activity_setting);
        setTitle(R.string.main_menu_setting);
    }

    @Override
    public void setHandler() {

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

    @OnClick({R.id.settings_tv_language, R.id.settings_tv_exit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.settings_tv_language:
                Utils.gotoActivity(this, LanguageSettingActivity.class, false, null, null);
                break;
            case R.id.settings_tv_exit:
                //退出登录
                exit();
                break;
        }
    }


    private void exit() {
        TokenXML.clean();
        SPUtils.getInstance().remove(SPConstants.KEY_SELECT_PRINT_WAY);
        ActivityUtils.finishAllActivities();
        Utils.goLogin(this);
    }
}
