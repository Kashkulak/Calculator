package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView panel;
    private double result, firstNumber, secondNumber;
    private String operation;
    private String intermediateNumber = "";
    boolean isOperation = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        panel = findViewById(R.id.panel);
    }

    public void onClick_buttonTyping(View view) {
        if (isOperation) {
            panel.setText("");
            result = 0;
            operation = null;
            firstNumber = 0;
            secondNumber = 0;
            intermediateNumber = "";
            isOperation = false;
        }
        switch (view.getId()) {

            case R.id.zero:
                if (!intermediateNumber.startsWith("0") || intermediateNumber.contains(".")) {
                    intermediateNumber += "0";
                }
                break;

            case R.id.one:
                intermediateNumber += "1";
                break;

            case R.id.two:
                intermediateNumber += "2";
                break;

            case R.id.three:
                intermediateNumber += "3";
                break;

            case R.id.four:
                intermediateNumber += "4";
                break;

            case R.id.five:
                intermediateNumber += "5";
                break;

            case R.id.six:
                intermediateNumber += "6";
                break;

            case R.id.seven:
                intermediateNumber += "7";
                break;

            case R.id.eight:
                intermediateNumber += "8";
                break;

            case R.id.nine:
                intermediateNumber += "9";
                break;

            case R.id.comma:
                if (!intermediateNumber.contains(".")) {
                    intermediateNumber += ".";
                }
                break;

            case R.id.cleaning:
                intermediateNumber = "";
                break;
        }
        panel.setText(intermediateNumber);
    }

    @SuppressLint("SetTextI18n")
    public void Logic_onClick_buttonTyping(View view) {
        switch (view.getId()) {
            case R.id.plus:
                try {
                    firstNumber = Double.parseDouble(intermediateNumber);
                    operation = "+";
                    intermediateNumber = "";
                    panel.setText("+");
                    break;
                } catch (Exception ignore) {
                }

            case R.id.minus:
                try {
                    firstNumber = Double.parseDouble(intermediateNumber);
                    operation = "-";
                    intermediateNumber = "";
                    panel.setText("-");
                    break;
                } catch (Exception ignore) {
                }

            case R.id.multiply:
                try {
                    firstNumber = Double.parseDouble(intermediateNumber);
                    operation = "*";
                    intermediateNumber = "";
                    panel.setText("*");
                    break;

                } catch (Exception ignore) {
                }

            case R.id.subtraction:
                try {
                    firstNumber = Double.parseDouble(intermediateNumber);
                    operation = "/";
                    intermediateNumber = "";
                    panel.setText("/");
                    break;

                } catch (Exception ignore) {
                }

            case R.id.equal:
                try {
                    secondNumber = Double.parseDouble(intermediateNumber);
                    switch (operation) {
                        case "+":
                            result = firstNumber + secondNumber;
                            break;

                        case "-":
                            result = firstNumber - secondNumber;
                            break;

                        case "*":
                            result = firstNumber * secondNumber;
                            break;

                        case "/":
                            if (firstNumber == 0 || secondNumber == 0) {
                                intermediateNumber = "Ошибка";
                                panel.setText(intermediateNumber);
                            } else {
                                result = firstNumber / secondNumber;
                            }
                            break;
                    }
                } catch (Exception ignore) {
                }

                if (!intermediateNumber.equals("Ошибка")) {
                    panel.setText(result + "");
                }
                isOperation = true;
                break;
        }
    }
}