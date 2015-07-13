package com.example.sasha.myapplication_layouts;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class MyActivity extends Activity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private EditText m_eText_A;
    private EditText m_eText_Op;
    private EditText m_eText_B;
    private Button m_btn_Res;
    private TextView m_tView_Res;
    private Switch sw_btn;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        findViews();

    }

    private void findViews(){
        m_eText_A   = (EditText) findViewById(R.id.et1_AM);
        m_eText_Op  = (EditText) findViewById(R.id.et2_AM);
        m_eText_B   = (EditText) findViewById(R.id.et3_AM);
        m_btn_Res   = (Button) findViewById(R.id.btn_AM);
        m_tView_Res = (TextView) findViewById(R.id.tv_AM);
        sw_btn      = (Switch) findViewById(R.id.sw_AM);
        linearLayout = (LinearLayout) findViewById(R.id.layout_activity);

        sw_btn.setChecked(true);
        sw_btn.setOnCheckedChangeListener(this);
        m_btn_Res.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
      int num1 = 0;
      int num2 = 0;
      int res  = 0;
      if (TextUtils.isEmpty(m_eText_A.getText().toString()) || TextUtils.isEmpty(m_eText_B.getText().toString())) {
      return;
       }
        num1 = Integer.parseInt(m_eText_A.getText().toString());
        num2 = Integer.parseInt(m_eText_A.getText().toString());

        switch (v.getId()){
            case R.id.btn_AM:
                        if (m_eText_Op.getText().toString().equals("+")){
                            res = num1 + num2;
                            m_tView_Res.setText(" " +res);

                        }
                else
                        if (m_eText_Op.getText().toString().equals("-")) {
                            res = num1 - num2;
                            m_tView_Res.setText(" " + res);
                        }
                else
                        if (m_eText_Op.getText().toString().equals("*")) {
                            res = num1 * num2;
                            m_tView_Res.setText(" " + res);
                        }
                else
                        if (m_eText_Op.getText().toString().equals("/")) {
                            res = num1 / num2;
                            m_tView_Res.setText(" " + res);
                        }

            break;

        }



    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked)
            linearLayout.setBackgroundColor(Color.parseColor("#00ff00"));
        else
            linearLayout.setBackgroundColor(Color.parseColor("#ff0000"));


    }
}



