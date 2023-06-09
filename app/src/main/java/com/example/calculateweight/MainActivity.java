package com.example.calculateweight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    android.widget.Button mcalculateBmi;

    TextView mcurrentHeight;
    TextView mcurrentWeight, mcurrentAge;
    ImageView mincrementAge, mincrementWeight, mdecrementWeight, mdecrementAge;
    SeekBar mseekbar;
    RelativeLayout mmale, mfemale;

    int intweight = 55;
    int intage = 22;
    int currentprogress;
    String mintprogress = "170";
    String typeofuser = "0";
    String weight2 = "55";
    String age2 = "22";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        mcalculateBmi = findViewById(R.id.bmiBtn);
        mcurrentAge = findViewById(R.id.currentAge);
        mcurrentWeight = findViewById(R.id.currentWeight);
        mcurrentHeight = findViewById(R.id.heightValue);
        mincrementWeight = findViewById(R.id.incrementWeight);
        mdecrementWeight = findViewById(R.id.decrementWeight);
        mincrementAge = findViewById(R.id.incrementAge);
        mdecrementAge = findViewById(R.id.decrementAge);
        mseekbar = findViewById(R.id.seekbar);
        mmale = findViewById(R.id.male);
        mfemale = findViewById(R.id.female);

        mmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofuser = "Male";
            }
        });

        mfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofuser = "Female";
            }
        });

        mseekbar.setMax(300);
        mseekbar.setProgress(180);
        mseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                currentprogress = i;
                mintprogress = String.valueOf(currentprogress);
                mcurrentHeight.setText(mintprogress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mincrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intage = intage+1;
                age2 = String.valueOf(intage);
                mcurrentAge.setText(age2);
            }
        });

        mincrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intweight = intweight+1;
                weight2 = String.valueOf(intweight);
                mcurrentWeight.setText(weight2);
            }
        });

        mdecrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intage = intage-1;
                age2 = String.valueOf(intage);
                mcurrentAge.setText(age2);
            }
        });

        mdecrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intweight = intweight-1;
                weight2 = String.valueOf(intweight);
                mcurrentWeight.setText(weight2);
            }
        });

        mcalculateBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(typeofuser.equals("0"))
                {
                    Toast.makeText(getApplicationContext(),"Select your Gender first",Toast.LENGTH_SHORT).show();
                }
                else if(mintprogress.equals("0"))
                {
                    Toast.makeText(getApplicationContext(),"Select your Height first",Toast.LENGTH_SHORT).show();
                }
                else if(intage==0 || intage<0)
                {
                    Toast.makeText(getApplicationContext(),"Age is incorrect",Toast.LENGTH_SHORT).show();
                }
                else if(intweight==0 || intweight<0)
                {
                    Toast.makeText(getApplicationContext(),"Weight is incorrect",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(MainActivity.this, BmiActivity.class);
                    intent.putExtra("gender",typeofuser);
                    intent.putExtra("height",mintprogress);
                    intent.putExtra("weight",weight2);
                    intent.putExtra("age",age2);
                    startActivity(intent);
                }



            }
        });


    }
}