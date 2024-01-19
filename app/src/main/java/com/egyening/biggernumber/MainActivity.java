package com.egyening.biggernumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int num1;
    private int num2;
    private int num3;
    private int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roll();
    }

    public void clickButton1(View view){
        check(num1,num2,num3);
        //Toast.makeText(this, "Button one Horray!", Toast.LENGTH_SHORT).show();

    }


    public void clickButton2(View view){
        check(num2,num1,num3);
       // Toast.makeText(this, "Button two Horray!", Toast.LENGTH_SHORT).show();

    }

    public void clickButton3(View view){
        check(num3,num2,num1);
        // Toast.makeText(this, "Button two Horray!", Toast.LENGTH_SHORT).show();

    }

    private void roll(){
        Random r = new Random();
        num1 = r.nextInt(20);
        num2 = r.nextInt(20);
        num3 = r.nextInt(20);
        while(num1==num2 ||num1==num3||num2==num3){
            num2 = r.nextInt(20);
            num3= r.nextInt(20);
        }
        Button left = (Button) findViewById(R.id.button1);
        left.setText("" + num1);
        Button right = (Button) findViewById(R.id.button2);
        right.setText("" + num2);
        Button center = (Button) findViewById(R.id.button3);
        center.setText("" + num3);



    }
    private void check(int a, int b,int c) {
        if (a > b && a>c) {
            points++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            points--;
            Toast.makeText(this, "Incorrect!.", Toast.LENGTH_SHORT).show();
        }
        TextView pointsView = (TextView) findViewById(R.id.textView3);
        pointsView.setText("Points: " + points);
        roll();
    }

}