package com.joymates.soma.setting;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.ActivityUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.joymates.common.base.BaseActivity;
import com.joymates.soma.MainActivity;
import com.joymates.soma.R;
import com.joymates.soma.util.Utils;
import com.joymates.soma.util.language.LanguageType;
import com.joymates.soma.util.language.MultiLanguageUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

/**
 * Project name somaApp
 * Created by byd on 2018/6/13 11:03
 * Package name com.joymates.soma.my
 * Class Description 语言选择
 */
public class LanguageSettingActivity extends BaseActivity {


    @BindView(R.id.language_setting_recycler_view)
    RecyclerView recyclerView;

    private LanguageSettingAdapter mAdapter;

    @Override
    public void setLayout() {
        setContentView(R.layout.activity_language_setting);
        setTitle(getString(R.string.common_language_settings));

    }

    @Override
    public void setHandler() {

    }

    @Override
    public void initMember() {
        initRecyclerView();
    }

    private void initRecyclerView() {

        List<String> stringList = Arrays.asList(getString(R.string
                .setting_language_english), getString(R.string.setting_simplified_chinese));
//        List<String> stringList = Arrays.asList(getString(R.string.setting_language_auto), getString(R.string
//                .setting_language_english), getString(R.string.setting_simplified_chinese));
        mAdapter = new LanguageSettingAdapter(new ArrayList<String>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);
        Utils.showNoData(mAdapter, recyclerView);
        mAdapter.setNewData(stringList);
    }

    @Override
    public void setListener() {

        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                int selectedLanguage = 0;
//                String language = (String) adapter.getData().get(position);
                switch (position) {
//                    case 0:
//                        selectedLanguage = LanguageType.LANGUAGE_FOLLOW_SYSTEM;
//                        break;
                    case 0:
                        selectedLanguage = LanguageType.LANGUAGE_EN;
                        break;
                    case 1:
                        selectedLanguage = LanguageType.LANGUAGE_CHINESE_SIMPLIFIED;
                        break;

                }

                MultiLanguageUtil.getInstance().updateLanguage(selectedLanguage);

                setLanguage();
//                Intent intent = new Intent(view.getContext(), OCBCActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(intent);
            }
        });

    }

    public void setLanguage() {
        ActivityUtils.finishAllActivities();
        Utils.gotoActivity(this, MainActivity.class, true, null, null);
    }
}
