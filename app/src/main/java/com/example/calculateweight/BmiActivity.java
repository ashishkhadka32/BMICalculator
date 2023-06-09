package com.example.calculateweight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BmiActivity extends AppCompatActivity {
    android.widget.Button mrecalculateBmi;

    TextView mbmidisplay, mbmicategory, mgender;
    Intent intent;
    ImageView mimageview;
    String mbmi;
    float intbmi;
    String height;
    String weight;
    float intheight, intweight;
    RelativeLayout mbackground;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);


        intent = getIntent();

        mbmidisplay = findViewById(R.id.bmiDisplay);
        mbmicategory = findViewById(R.id.bmiCategory);
        mgender = findViewById(R.id.genderDisplay);
        mbackground = findViewById(R.id.contentLayout);
        mimageview = findViewById(R.id.imageView);
        mrecalculateBmi = findViewById(R.id.recalculateBmi);
        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");
        intheight = Float.parseFloat(height);
        intweight = Float.parseFloat(weight);
        intheight = intheight/100;
        intbmi = intweight/(intheight*intheight);
        mbmi = Float.toString(intbmi);

        if(intbmi<16)
        {
            mbmicategory.setText("Severe Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);
        }

        else if(intbmi<16.9 && intbmi>16)
        {
            mbmicategory.setText("Moderate Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }

        else if(intbmi<18.4 && intbmi>17)
        {
            mbmicategory.setText("Mild Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }

        else if(intbmi<25 && intbmi>18.4)
        {
            mbmicategory.setText("Normal");
            //mbackground.setBackgroundColor(Color.YELLOW);
            mimageview.setImageResource(R.drawable.ok);
        }

        else if(intbmi<29.4 && intbmi>25)
        {
            mbmicategory.setText("Over Weight");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }

        else
        {
            mbmicategory.setText("Obese Class 1");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }
            mgender.setText(intent.getStringExtra("gender"));
            mbmidisplay.setText(mbmi);


        getSupportActionBar().hide();
        mrecalculateBmi = findViewById(R.id.recalculateBmi);
        mrecalculateBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BmiActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}