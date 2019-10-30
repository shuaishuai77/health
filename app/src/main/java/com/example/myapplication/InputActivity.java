package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;


public class InputActivity extends AppCompatActivity {

    public Button button1;
    public EditText weight;
    public EditText height;
    public EditText age;
    public EditText gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        button1 = findViewById(R.id.button1);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        age = findViewById(R.id.age);
        gender = findViewById(R.id.gender);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText1 = weight.getText().toString();
                String inputText2 = height.getText().toString();
                String inputText3 = gender.getText().toString();
                String inputText4 = age.getText().toString();




                Intent intent = new Intent();
                intent.setClass(InputActivity.this, HomePageActivity.class);


                if (inputText1 != null && !"".equals(inputText1) && !"null".equals(inputText1)
                        && inputText2 != null && !"".equals(inputText2) && !"null".equals(inputText2)
                        && inputText3 != null && !"".equals(inputText3) && !"null".equals(inputText3)
                        && inputText4 != null && !"".equals(inputText4) && !"null".equals(inputText4)
                ) {
                    if(!inputText3.equals("男")&&!inputText3.equals("女"))
                        Toast.makeText(InputActivity.this,"输入有误",Toast.LENGTH_SHORT).show();
                    else{
                        if (inputText3.equals("女"))
                            inputText3 = "0";
                        if (inputText3.equals("男"))
                            inputText3 = "1";
                    Double wei = Double.parseDouble(weight.getText().toString());
                    Double hei = Double.parseDouble(height.getText().toString());
                    Double put_age = Double.parseDouble(age.getText().toString());
                    double gen = Integer.parseInt(inputText3);
                    double BMI;
                   if(wei<0||wei>200)
                       Toast.makeText(InputActivity.this,"输入有误",Toast.LENGTH_SHORT).show();
                  else{
                      if(hei>250||hei<0)
                          Toast.makeText(InputActivity.this,"输入有误",Toast.LENGTH_SHORT).show();
                      else {
                          if(put_age<0||put_age>120)
                              Toast.makeText(InputActivity.this,"输入有误",Toast.LENGTH_SHORT).show();
                          else {
                      BMI = wei / (hei * hei) * 10000;
                    DecimalFormat BMI0 = new DecimalFormat("#.0");
                    String BMI1 = BMI0.format(BMI);
                    DecimalFormat wei0 = new DecimalFormat("#");
                    String wei1 = wei0.format(wei);
                    DecimalFormat hei0 = new DecimalFormat("#");
                    String hei1 = hei0.format(hei);


                    double fat;
                    fat = 1.2 * BMI + 0.23 * put_age - 5.4 - 10.8 * gen;


                    double bone ,bone2=0;
                    bone = (wei - put_age) * 0.2;
                    if(bone<-4){
                        bone2=50;
                        intent.putExtra("data16", "风险高");
                    }
                    if(bone<=-1&&bone>=-4){
                        bone2=70;
                        intent.putExtra("data16", "中度风险");
                    }
                    if(bone>-1){
                        bone2=100;
                        intent.putExtra("data16", "风险低");
                    }



                    double muscle = 1;   double muscle2=0;
                    if (gen == 0)
                    { muscle = 56 / wei * 0.5 * 100;
                    if(muscle<=55)
                    { muscle2=60;
                        intent.putExtra("data15", "偏低");}
                        if(muscle<=60&&muscle>55)
                    { muscle2=80;
                        intent.putExtra("data15", "正常");}
                        if(muscle>60)
                        { muscle2=100;
                            intent.putExtra("data15", "优秀");}

                    }

                    if (gen == 1)
                    { muscle = 78 / wei * 0.5 * 100;
                        if(muscle<=60)
                        { muscle2=60;
                            intent.putExtra("data15", "偏低");}
                        if(muscle>65)
                        { muscle2=100;
                            intent.putExtra("data15", "优秀");}
                        if(muscle>60&&muscle<=65)
                        { muscle2=80;
                            intent.putExtra("data15", "正常");}

                    }

                    double water = 0;
                    if (gen == 0)
                    water = muscle * 1.3;
                    if (gen == 1)
                        water = muscle * 1.2;
                   double water2=0;
                   if(water<70)
                   {
                       water2=70;
                       intent.putExtra("data14", "偏低");
                   }
                    if(water<=80&&water>=70)
                    {
                        water2=100;
                        intent.putExtra("data14", "正常");
                    }
                    if(water>80)
                    {
                        water2=70;
                        intent.putExtra("data14", "偏高");
                    }



                    double circulate = 0,circulate1=0;
                    if (gen == 0) {
                        circulate = wei * 9.6 + 1.8 * hei - 4.7 * put_age + 655;
                        if(circulate<1100)
                        { circulate1=70;
                            intent.putExtra("data17", "偏低");}
                        if(circulate<=1500&&circulate>=1100)
                        { circulate1=100;
                            intent.putExtra("data17", "正常");}

                        if(circulate>1500)
                        { circulate1=70;
                            intent.putExtra("data17", "偏高");}
                        if (hei <= 150)
                            intent.putExtra("data10", "偏低");
                        else intent.putExtra("data10", "标准");
                        double module0 = (hei - 70) * 0.6;
                        if (wei <= module0 * 1.1 && wei >= module0 * 0.9)
                            intent.putExtra("data11", "正常");
                        else if (wei < module0 * 1.2 && wei > module0 * 1.1)
                            intent.putExtra("data11", "偏重");
                        else if (wei < module0 * 0.9 && wei >= module0 * 0.8)
                            intent.putExtra("data11", "偏轻");
                        else if (wei < module0 * 0.8)
                            intent.putExtra("data11", "营养不良");
                        else if (wei >= module0 * 1.2)
                            intent.putExtra("data11", "肥胖");


                    }
                    if (gen == 1) {
                        circulate = wei * 13.7 + hei * 5 - 6.8 * put_age + 66;
                        if(circulate<1300)
                        { circulate1=70;
                            intent.putExtra("data17", "偏低");}
                        if(circulate<=1900&&circulate>=1300)
                        { circulate1=100;
                            intent.putExtra("data17", "正常");}

                        if(circulate>1900)
                        { circulate1=70;
                            intent.putExtra("data17", "偏高");}
                        if (hei <= 160)
                            intent.putExtra("data10", "偏低");
                        else intent.putExtra("data10", "标准");
                        double module1 = (hei - 80) * 0.7;
                        if (wei <= module1 * 1.1 && wei >= module1 * 0.9)
                            intent.putExtra("data11", "正常");
                        else if (wei < module1 * 1.2 && wei > module1 * 1.1)
                            intent.putExtra("data11", "偏重");
                        else if (wei < module1 * 0.9 && wei >= module1 * 0.8)
                            intent.putExtra("data11", "偏轻");
                        else if (wei < module1 * 0.8)
                            intent.putExtra("data11", "营养不良");
                        else if (wei >= module1 * 1.2)
                            intent.putExtra("data11", "肥胖");


                    }

                    double bmi1 = 0;
                    if (BMI >= 10 && BMI <= 18.5) {
                        bmi1 = 75;
                        intent.putExtra("data12", "过轻");
                    }
                    if (BMI > 18.5 && BMI <= 24) {
                        bmi1 = 100;
                        intent.putExtra("data12", "正常");
                    }
                    if (BMI > 24 && BMI <= 28) {
                        bmi1 = 80;
                        intent.putExtra("data12", "超重");
                    }
                    if (BMI > 28 && BMI <= 35) {
                        bmi1 = 60;
                        intent.putExtra("data12", "肥胖");
                    }
                    double fat3 = 0;
                    if (gen == 0) {

                        if (fat > 10 && fat <= 20)
                        { fat3 = 70;
                        intent.putExtra("data13", "过瘦");}
                        if (fat > 20 && fat <= 30)
                        { fat3 = 100;
                        intent.putExtra("data13", "正常");}
                        if (fat > 30 && fat <= 45)
                        { fat3 = 70;
                        intent.putExtra("data13", "超重");
                        }
                    }
                    if (gen == 1) {
                        if (fat > 8 && fat <= 15)
                        { fat3 = 70;
                        intent.putExtra("data13", "过瘦");}
                        if (fat > 15 && fat <= 25)
                        { fat3 = 100;
                        intent.putExtra("data13", "正常");}
                        if (fat > 25 && fat <= 35)
                        {fat3 = 70;
                        intent.putExtra("data13", "超重");
                        }



                    }



                    double grade = 0;
                    grade = bmi1 * 0.5 + fat3 * 0.1 + water2* 0.1 + muscle2 * 0.1 + bone2 * 0.1 + circulate1 * 0.1;
                    if(grade>=85&&grade<=100){
                        intent.putExtra("data18", "优秀");}
                    if(grade>=70&&grade<=85){
                        intent.putExtra("data18", "良好");}
                    if(grade<70){
                        intent.putExtra("data18", "较差");}
                    DecimalFormat grade0 = new DecimalFormat("#");
                    String grade1 = grade0.format(grade);
                    intent.putExtra("data8", grade1);
                    DecimalFormat water0 = new DecimalFormat("#.0");
                    String water1 = water0.format(water);
                    DecimalFormat muscle0 = new DecimalFormat("#.0");
                    String muscle1 = muscle0.format(muscle);
                    DecimalFormat bone0 = new DecimalFormat("#.0");
                    String bone1 = bone0.format(bone);
                    DecimalFormat fat0 = new DecimalFormat("#.0");
                    String fat1 = fat0.format(fat);
                          DecimalFormat circulate0 = new DecimalFormat("#.0");
                          String circulate2 = circulate0.format(circulate);

                    intent.putExtra("data1", hei1);
                    intent.putExtra("data2", wei1);
                    intent.putExtra("data3", BMI1);
                    intent.putExtra("data4", muscle1 + "%");
                    intent.putExtra("data5", water1 + "%");
                    intent.putExtra("data6", circulate2);
                    intent.putExtra("data7", bone1);
                    intent.putExtra("data9", fat1 + "%");
                              startActivity(intent);


                      }}}}



                }
                else
                    Toast.makeText(InputActivity.this,"输入有误",Toast.LENGTH_SHORT).show();



            }

        });
    }
}
