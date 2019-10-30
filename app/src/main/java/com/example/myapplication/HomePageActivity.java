package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class HomePageActivity extends AppCompatActivity {
    public TextView BM;
    public TextView h;
    public TextView hei;
    public TextView w;
    public TextView put_fat;
    public TextView put_bone;
    public TextView put_muscle;
    public TextView put_water;
    public TextView put_circulate;
    public TextView grade;
    public TextView weig;
    public TextView bmi;
    public TextView put_fa;
    public TextView put_wate;
    public TextView put_bon;
    public TextView put_muscl;
    public TextView put_cir;
    public TextView grade1;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(HomePageActivity.this, InputActivity.class);
                startActivity(intent);
        }
        });
        Intent intent =getIntent();
        BM = findViewById(R.id.BM);
        w = findViewById(R.id.w);
        put_fat = findViewById(R.id.put_fat);
        put_muscle = findViewById(R.id.put_muscle);
        put_water = findViewById(R.id.put_water);
        put_bone = findViewById(R.id.put_bone);
        put_circulate = findViewById(R.id.put_circulate);
        grade = findViewById(R.id.grade);
        grade1 = findViewById(R.id.grade1);
        hei = findViewById(R.id.hei);
        weig=findViewById(R.id.weig);
        bmi=findViewById(R.id.bmi);
        put_fa=findViewById(R.id.put_fa);
        put_wate=findViewById(R.id.put_wate);
        put_bon=findViewById(R.id.put_bon);
        put_muscl=findViewById(R.id.put_muscl);
        put_cir=findViewById(R.id.put_cir);


        String he = intent.getStringExtra("data1");
        h=findViewById(R.id.h);
        h.setText(""+he);
        String we = intent.getStringExtra("data2");
        w.setText(""+we);
        String B = intent.getStringExtra("data3");
        BM.setText(""+B);
        String mus = intent.getStringExtra("data4");
        put_muscle.setText(""+mus);
        String wat = intent.getStringExtra("data5");
        put_water.setText(""+wat);
        String cir = intent.getStringExtra("data6");
        put_circulate.setText(""+cir);
        String bo = intent.getStringExtra("data7");
        put_bone.setText(""+bo);
        String grad = intent.getStringExtra("data8");
        grade.setText(""+grad);
        String fa = intent.getStringExtra("data9");
        put_fat.setText(""+fa);
        String h = intent.getStringExtra("data10");
        hei.setText(""+h);
        String wei = intent.getStringExtra("data11");
        weig.setText(""+wei);
        String BMI = intent.getStringExtra("data12");
        bmi.setText(""+BMI);
        String fat = intent.getStringExtra("data13");
        put_fa.setText(""+fat);
        String water = intent.getStringExtra("data14");
        put_wate.setText(""+water);
        String muscle = intent.getStringExtra("data15");
        put_muscl.setText(""+muscle);
        String bone = intent.getStringExtra("data16");
        put_bon.setText(""+bone);
        String circulate = intent.getStringExtra("data17");
        put_cir.setText(""+circulate);
        String gra = intent.getStringExtra("data18");
        grade1.setText(""+gra);






        Button report = findViewById(R.id.report);
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.setClass(HomePageActivity.this, ReportActivity.class);
                if(put_fa.equals("超重"))
                  intent2.putExtra("data19", "注意降低体脂率，饮食控油脂。");
               else if(put_fa.equals("过瘦"))
                    intent2.putExtra("data19", "注意提高体脂率，饮食增加油脂。"+"\n");
               else intent2.putExtra("data19", "体脂正常，继续保持"+"\n");
                if(put_bon.equals("风险低"))
                    intent2.putExtra("data20", "骨质良好，继续保持"+"\n");
                else intent2.putExtra("data20", "骨质有风险，建议多摄入蛋白质和钙"+"\n");
                if(put_muscl.equals("偏低"))
                    intent2.putExtra("data21", "多增加体育锻炼，增强肌肉"+"\n");
                else intent2.putExtra("data21", "肌肉良好，继续保持"+"\n");


                if(put_wate.equals("偏低"))
                    intent2.putExtra("data22", "水分摄入不足，请增加饮水量"+"\n");
                else if(put_wate.equals("偏高"))
                    intent2.putExtra("data22", "水分摄入过多，减少喝水"+"\n");
                else intent2.putExtra("data22", "水分摄入正常，请继续保持"+"\n");
                if(put_cir.equals("偏低"))
                    intent2.putExtra("data23", "代谢偏低，请加强体育锻炼"+"\n");
                else if(put_wate.equals("偏高"))
                    intent2.putExtra("data23", "代谢旺盛，减少剧烈运动"+"\n");
                else intent2.putExtra("data23", "代谢正常，请继续保持"+"\n");
                startActivity(intent2);
            }
        });
















    };
}

