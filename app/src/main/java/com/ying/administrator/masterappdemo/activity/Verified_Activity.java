package com.ying.administrator.masterappdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ying.administrator.masterappdemo.R;
import com.ying.administrator.masterappdemo.activity.BaseActivity.BaseActivity;
import com.ying.administrator.masterappdemo.common.DefineView;

public class Verified_Activity extends BaseActivity implements DefineView {

    private LinearLayout ll_return;
    private TextView tv_actionbar_title;
    private ImageView img_actionbar_message;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_verified);
        initView();
        initValidata();
        initListener();
        bindData();
    }

    @Override
    public void initView() {
        ll_return=findViewById(R.id.ll_return);
        tv_actionbar_title=findViewById(R.id.tv_actionbar_title);
        img_actionbar_message=findViewById(R.id.img_actionbar_message);
    }

    @Override
    public void initValidata() {
        tv_actionbar_title.setText("实名认证");
        img_actionbar_message.setVisibility(View.INVISIBLE);
    }

    @Override
    public void initListener() {
        ll_return.setOnClickListener(new CustomListner());
    }

    @Override
    public void bindData() {

    }
    public class CustomListner implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.ll_return:
                    Verified_Activity.this.finish();
                    break;
            }
        }
    }
}