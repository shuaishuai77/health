package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReportActivity extends AppCompatActivity {
    public TextView Report1;
    public TextView Report2;
    public TextView Report3;
    public TextView Report4;
    public TextView Report5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        Intent intent1 =getIntent();
        Report1 = findViewById(R.id.Report1);
        Report2 = findViewById(R.id.Report2);
        Report3 = findViewById(R.id.Report3);
        Report4 = findViewById(R.id.Report4);
        Report5 = findViewById(R.id.Report5);

        String report1 = intent1.getStringExtra("data19");
        Report1.setText("*"+report1);
        String report2 = intent1.getStringExtra("data20");
        Report2.setText("*"+report2);
        String report3 = intent1.getStringExtra("data21");
        Report3.setText("*"+report3);
        String report4 = intent1.getStringExtra("data22");
        Report4.setText("*"+report4);
        String report5 = intent1.getStringExtra("data23");
        Report5.setText("*"+report5);
    }
}
