package com.example.sasha.myapplication_layouts;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class MyActivity extends Activity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private EditText et_number_A;
    private EditText et_operator;
    private EditText et_number_B;
    private Button btn_Result;
    private TextView tv_Result;
    private Switch sw_SwitchLayout;
    private LinearLayout linearLayout;
    int num1 = 0;
    int num2 = 0;
    int res = 0;
    public static final String ADD = "+";
    public static final String SUBTRACT = "-";
    public static final String MULTIPLE = "*";
    public static final String DIVISION = "/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        findViews();

    }

    private void findViews() {
        et_number_A = (EditText) findViewById(R.id.et1_AM);
        et_operator = (EditText) findViewById(R.id.et2_AM);
        et_number_B = (EditText) findViewById(R.id.et3_AM);
        btn_Result = (Button) findViewById(R.id.btn_AM);
        tv_Result = (TextView) findViewById(R.id.tv_AM);
        sw_SwitchLayout = (Switch) findViewById(R.id.sw_AM);
        linearLayout = (LinearLayout) findViewById(R.id.layout_activity);

        sw_SwitchLayout.setChecked(true);
        sw_SwitchLayout.setOnCheckedChangeListener(this);
        btn_Result.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if (TextUtils.isEmpty(et_number_A.getText().toString()) || TextUtils.isEmpty(et_number_B.getText().toString())) {
            Toast.makeText(getApplication(), "Please enter number", Toast.LENGTH_SHORT).show();
        } else {
            num1 = Integer.parseInt(et_number_A.getText().toString());
            num2 = Integer.parseInt(et_number_B.getText().toString());

            try {


                String s = et_operator.getText().toString();
                if (s.equals(ADD)) {
                    res = num1 + num2;
                    tv_Result.setText(String.valueOf(res));

                } else if (s.equals(SUBTRACT)) {
                    res = num1 - num2;
                    tv_Result.setText(String.valueOf(res));

                } else if (s.equals(MULTIPLE)) {
                    res = num1 * num2;
                    tv_Result.setText(String.valueOf(res));

                } else if (s.equals(DIVISION)) {
                    res = num1 / num2;
                    tv_Result.setText(String.valueOf(res));

                }
            }
            catch (ArithmeticException e){
                Toast.makeText(this, "На нуль ділити не можна!", Toast.LENGTH_LONG).show();
            }
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


