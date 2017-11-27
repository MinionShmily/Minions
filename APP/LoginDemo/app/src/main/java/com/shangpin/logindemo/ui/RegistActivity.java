package com.shangpin.logindemo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.shangpin.logindemo.R;
import com.shangpin.logindemo.utils.SPUtils;
import com.shangpin.logindemo.utils.ToastUtil;


public class RegistActivity extends Activity implements View.OnClickListener {

    private ImageView ivBack;
    private EditText etName;
    private EditText etCode;
    private TextView tvGetCode;
    private EditText etPwd;
    private EditText etPwdConfirm;
    private Button btnRegist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        //初始化控件
        initView();

        //初始化控件
        iniClick();
    }

    private void iniClick() {
        ivBack.setOnClickListener(this);
        tvGetCode.setOnClickListener(this);
        btnRegist.setOnClickListener(this);
    }

    private void initView() {
        ivBack = (ImageView) findViewById(R.id.iv_back);
        etName = (EditText) findViewById(R.id.et_name);
        etCode = (EditText) findViewById(R.id.et_code);
        tvGetCode = (TextView) findViewById(R.id.tv_get_code);
        etPwd = (EditText) findViewById(R.id.et_pwd);
        etPwdConfirm = (EditText) findViewById(R.id.et_pwd_confirm);
        btnRegist = (Button) findViewById(R.id.btn_regist);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back://返回按钮
                finish();
                break;
            case R.id.tv_get_code://验证码

                break;
            case R.id.btn_regist://注册按钮
                String strName = etName.getText().toString().trim();
                String strCode = etCode.getText().toString().trim();
                String strPwd = etPwd.getText().toString().trim();
                String strConfirm = etPwdConfirm.getText().toString().trim();
                //非空判断
                if (isStrEmpty(strName, strCode, strPwd, strConfirm)) return;

                //判断验证码是否正确(假设验证码是110)
                if (!strCode.equals("110")) {
                    ToastUtil.showShort(RegistActivity.this, "验证码输入错误");
                    return;
                }

                //判断两次密码是否一致
                if (!strPwd.equals(strConfirm)) {
                    ToastUtil.showShort(RegistActivity.this, "两次密码不一致");
                    return;
                }

                //走到这一步,所有的验证都通通过了,保存用户信息,并关闭该页面
                SPUtils.put(RegistActivity.this, "user_name", strName);
                SPUtils.put(RegistActivity.this, "user_pwd", strConfirm);

                finish();

                break;
        }
    }

    /**
     * 非空判断
     */
    private boolean isStrEmpty(String strName, String strCode, String strPwd, String strConfirm) {
        if (TextUtils.isEmpty(strName)) {
            ToastUtil.showShort(RegistActivity.this, "账户不能为空");
            return true;
        } else if (TextUtils.isEmpty(strCode)) {
            ToastUtil.showShort(RegistActivity.this, "验证码不能为空");
            return true;
        } else if (TextUtils.isEmpty(strPwd)) {
            ToastUtil.showShort(RegistActivity.this, "密码不能为空");
            return true;
        } else if (TextUtils.isEmpty(strConfirm)) {
            ToastUtil.showShort(RegistActivity.this, "二次输入密码不能为空");
            return true;
        }
        return false;
    }
}
