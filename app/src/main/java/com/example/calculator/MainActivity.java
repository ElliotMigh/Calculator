package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonZero, buttonClear, buttonBack, buttonSum, buttonMin, buttonMul, buttonDiv, buttonPercent, buttonEqual, buttonDecimal;
    private TextView textViewResult, textViewOperation;
    boolean isNewOp = true;
    String Op = "+";
    String oldNumber = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //insert function
        initViews();
        setFontOnButtons();

    }

    public void NumberEvent(View view) {

        //animation
        final Animation animationAlphaNumberButton = AnimationUtils.loadAnimation(this, R.anim.alpha_animation);

        //sound
        final MediaPlayer sound = MediaPlayer.create(this, R.raw.soundbutton);

        if (isNewOp) {
            textViewOperation.setText("");
            isNewOp = false;
        }
        String operation = textViewOperation.getText().toString();
        switch (view.getId()) {
            case R.id.btn1:
                operation += "1";
                button1.startAnimation(animationAlphaNumberButton);
                sound.start();
                break;
            case R.id.btn2:
                operation += "2";
                button2.startAnimation(animationAlphaNumberButton);
                sound.start();
                break;
            case R.id.btn3:
                operation += "3";
                button3.startAnimation(animationAlphaNumberButton);
                sound.start();
                break;
            case R.id.btn4:
                operation += "4";
                button4.startAnimation(animationAlphaNumberButton);
                sound.start();
                break;
            case R.id.btn5:
                operation += "5";
                button5.startAnimation(animationAlphaNumberButton);
                sound.start();
                break;
            case R.id.btn6:
                operation += "6";
                button6.startAnimation(animationAlphaNumberButton);
                sound.start();
                break;
            case R.id.btn7:
                operation += "7";
                button7.startAnimation(animationAlphaNumberButton);
                sound.start();
                break;
            case R.id.btn8:
                operation += "8";
                button8.startAnimation(animationAlphaNumberButton);
                sound.start();
                break;
            case R.id.btn9:
                operation += "9";
                button9.startAnimation(animationAlphaNumberButton);
                sound.start();
                break;
            case R.id.btnZero:
                operation += "0";
                buttonZero.startAnimation(animationAlphaNumberButton);
                sound.start();
                break;
            case R.id.btnDecimal:
                operation += ".";
                buttonDecimal.startAnimation(animationAlphaNumberButton);
                sound.start();
                break;
        }
        textViewOperation.setText(operation);
    }

    public void operatorEvent(View view) {

        //animation
        final Animation animationAlphaOperatorButton = AnimationUtils.loadAnimation(this, R.anim.alpha_animation);

        //sound
        final MediaPlayer sound = MediaPlayer.create(this, R.raw.soundbutton);

        isNewOp = true;
        oldNumber = textViewOperation.getText().toString();
        switch (view.getId()) {
            case R.id.btnSum:
                Op = "+";
                buttonSum.startAnimation(animationAlphaOperatorButton);
                sound.start();
                break;
            case R.id.btnMin:
                Op = "-";
                buttonMin.startAnimation(animationAlphaOperatorButton);
                sound.start();
                break;
            case R.id.btnMul:
                Op = "*";
                buttonMul.startAnimation(animationAlphaOperatorButton);
                sound.start();
                break;
            case R.id.btnDiv:
                Op = "/";
                buttonDiv.startAnimation(animationAlphaOperatorButton);
                sound.start();
                break;
        }
    }

    public void EqualEvent(View view) {

        //animation
        final Animation animationAlphaEqualButton = AnimationUtils.loadAnimation(this, R.anim.alpha_animation);
        buttonEqual.startAnimation(animationAlphaEqualButton);

        //sound
        final MediaPlayer sound = MediaPlayer.create(this, R.raw.soundbutton);
        sound.start();

        String newNumber = textViewOperation.getText().toString();
        double result = 0.0;
        if (!oldNumber.isEmpty()) {
            switch (Op) {
                case "+":
                    result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                    break;
                case "-":
                    result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                    break;
                case "*":
                    result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                    break;
                case "/":
                    result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                    break;
            }
        } else {
            Toast.makeText(MainActivity.this, "Enter a number first", Toast.LENGTH_SHORT).show();
        }
        textViewOperation.setText(String.valueOf(result)); //*
        textViewResult.setText(String.valueOf(result));
    }

    public void acEvent(View view) {

        //animation
        final Animation animationAlphaACButton = AnimationUtils.loadAnimation(this, R.anim.alpha_animation);
        buttonClear.startAnimation(animationAlphaACButton);

        //sound
        final MediaPlayer sound = MediaPlayer.create(this, R.raw.soundbutton);
        sound.start();

        textViewResult.setText("0.0");
        textViewOperation.setText("0.0");
        isNewOp = true;
    }

    public void percentEvent(View view) {

        //animation
        final Animation animationAlphaPercentButton = AnimationUtils.loadAnimation(this, R.anim.alpha_animation);
        buttonPercent.startAnimation(animationAlphaPercentButton);

        //sound
        final MediaPlayer sound = MediaPlayer.create(this, R.raw.soundbutton);
        sound.start();

        Double percent = Double.parseDouble(textViewOperation.getText().toString()) / 100;
        textViewResult.setText(String.valueOf(percent));
        textViewOperation.setText(String.valueOf(percent));
        isNewOp = true;
    }

    public void backEvent(View view) {

        //animation
        final Animation animationAlphaBackButton = AnimationUtils.loadAnimation(this, R.anim.alpha_animation);
        buttonBack.startAnimation(animationAlphaBackButton);

        //sound
        final MediaPlayer sound = MediaPlayer.create(this, R.raw.soundbutton);
        sound.start();

        String content = textViewOperation.getText().toString();
        textViewOperation.setText("");
        for (int i = 0; i < content.length() - 1; i++) {
            textViewOperation.setText(textViewOperation.getText().toString() + content.charAt(i));
        }
    }

    void initViews() {
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button7 = findViewById(R.id.btn7);
        button8 = findViewById(R.id.btn8);
        button9 = findViewById(R.id.btn9);
        buttonZero = findViewById(R.id.btnZero);
        buttonSum = findViewById(R.id.btnSum);
        buttonMin = findViewById(R.id.btnMin);
        buttonMul = findViewById(R.id.btnMul);
        buttonDiv = findViewById(R.id.btnDiv);
        buttonDecimal = findViewById(R.id.btnDecimal);
        buttonEqual = findViewById(R.id.btnEqual);
        buttonClear = findViewById(R.id.btnClear);
        buttonBack = findViewById(R.id.btnBack); //*
        buttonPercent = findViewById(R.id.btnPercent);
        textViewResult = findViewById(R.id.txtResult);
        textViewOperation = findViewById(R.id.txtOperation);
    }

    private void setFontOnButtons() {
        Typeface typefaceBold = Typeface.createFromAsset(getAssets(), "fonts/boldi.ttf");
        button1.setTypeface(typefaceBold);
        button2.setTypeface(typefaceBold);
        button3.setTypeface(typefaceBold);
        button4.setTypeface(typefaceBold);
        button5.setTypeface(typefaceBold);
        button6.setTypeface(typefaceBold);
        button7.setTypeface(typefaceBold);
        button8.setTypeface(typefaceBold);
        button9.setTypeface(typefaceBold);
        buttonZero.setTypeface(typefaceBold);
        buttonSum.setTypeface(typefaceBold);
        buttonMin.setTypeface(typefaceBold);
        buttonMul.setTypeface(typefaceBold);
        buttonDiv.setTypeface(typefaceBold);
        buttonDecimal.setTypeface(typefaceBold);
        buttonEqual.setTypeface(typefaceBold);
        buttonClear.setTypeface(typefaceBold);
        buttonPercent.setTypeface(typefaceBold);
    }
}