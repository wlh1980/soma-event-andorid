package com.joymates.soma;

import android.widget.TextView;

import com.joymates.common.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_tv_num)
    TextView mainTvNum;
    @BindView(R.id.main_tv_print)
    TextView mainTvPrint;

    @Override
    public void setLayout() {
        setContentView(R.layout.activity_main);
    }

    @OnClick(R.id.main_tv_print)
    public void onViewClicked() {
        //打印
        toast("打印");
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
}
