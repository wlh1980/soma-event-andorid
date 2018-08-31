package com.joymates.soma.setting;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.joymates.soma.R;
import com.joymates.soma.util.language.MultiLanguageUtil;

import java.util.List;

/**
 * Project name somaApp
 * Created by byd on 2018/6/13 11:05
 * Package name com.joymates.soma.my
 * Class Description 语言选择列表适配器
 */
public class LanguageSettingAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public LanguageSettingAdapter(@Nullable List<String> data) {
        super(R.layout.item_rcv_language_setting, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final String item) {
        helper.setText(R.id.language_setting_tv_name, item);
        if (MultiLanguageUtil.getInstance().getLanguageName().equals(item))
            helper.setVisible(R.id.language_setting_iv_checked, true);
        else
            helper.setVisible(R.id.language_setting_iv_checked, false);
    }
}
