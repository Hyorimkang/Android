package com.cookandroid.ch04_ex1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edX, edY;
    Button btnPlus, btnMinus, btnMul, btnDiv;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edX = findViewById(R.id.edX);
        edY = findViewById(R.id.edY);
        btnPlus = findViewById(R.id.btnPlus);
        txtResult = findViewById(R.id.txtResult);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strX = edX.getText().toString(); //문자열
                int x = Integer.parseInt(strX); //정수변환
                String strY = edY.getText().toString(); //문자열
                int y = Integer.parseInt(strY); //정수변환
                int result = x + y;
                txtResult.setText("계산결과:" + result);
            }
        });
    }

    public void btnClick(View view) {
        String strX = edX.getText().toString(); //문자열
        int x = Integer.parseInt(strX); //정수변환
        String strY = edY.getText().toString(); //문자열
        int y = Integer.parseInt(strY); //정수변환
        switch(view.getId()){
            case R.id.btnMinus:txtResult.setText("계산결과:" + (x-y)); break;
            case R.id.btnMul: txtResult.setText("계산결과:" + (x*y)); break;
            case R.id.btnDiv:txtResult.setText("계산결과:" + (x/y)); break;
        }
    }
}