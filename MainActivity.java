package com.cookandroid.ch04_2_pet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtSelect;
    CheckBox chkStart;
    RadioButton rbDog, rbCat, rbRabbit;
    RadioGroup rg;
    Button btnOK;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진 보기");
        txtSelect=findViewById(R.id.txtSelect);
        chkStart=findViewById(R.id.chkStart);
        rbDog=findViewById(R.id.rbDog);
        rbCat=findViewById(R.id.rbCat);
        rbRabbit=findViewById(R.id.rbRabbit);
        rg=findViewById(R.id.rg);
        btnOK=findViewById(R.id.btnOK);
        img=findViewById(R.id.img);

        txtSelect.setVisibility(View.INVISIBLE);
        rg.setVisibility(View.INVISIBLE);
        btnOK.setVisibility(View.INVISIBLE);
        img.setVisibility(View.INVISIBLE);

        //이미지 비우기
        img.setImageDrawable(null);
        
        chkStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(chkStart.isChecked()){ //체크박스 체크된 경우
                    txtSelect.setVisibility(View.VISIBLE);
                    rg.setVisibility(View.VISIBLE);
                    btnOK.setVisibility(View.VISIBLE);
                    img.setVisibility(View.VISIBLE);
                }
                else{ //체크박스 체크해제 (선택 초기화까지 설정: 라디오버튼 선택 없애기, 이미지 비우기)
                    txtSelect.setVisibility(View.INVISIBLE);
                    rg.setVisibility(View.INVISIBLE);
                    btnOK.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.INVISIBLE);
                    //라디오버튼 모두 해제, 이미지도 없애기
                    img.setImageDrawable(null);
                    rg.clearCheck();
                }
            }
        });
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(rg.getCheckedRadioButtonId()){
                    case R.id.rbDog: img.setImageResource(R.drawable.dog); break;
                    case R.id.rbCat: img.setImageResource(R.drawable.cat); break;
                    case R.id.rbRabbit: img.setImageResource(R.drawable.rabbit); break;
                    default:
                        Toast.makeText(getApplicationContext(), "동물 먼저 선택하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}