package com.example.hw2_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private boolean isOperationClick;
    private String operation = "";
    private double first, second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);
    }

    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                setNumber("1");
                break;
            case R.id.btn_2:
                setNumber("2");
                break;
            case R.id.btn_3:
                setNumber("3");
                break;
            case R.id.btn_4:
                setNumber("4");
                break;
            case R.id.btn_5:
                setNumber("5");
                break;
            case R.id.btn_6:
                setNumber("6");
                break;
            case R.id.btn_7:
                setNumber("7");
                break;
            case R.id.btn_8:
                setNumber("8");
                break;
            case R.id.btn_9:
                setNumber("9");
                break;
            case R.id.btn_zero:
                setNumber("0");
                break;
            case R.id.btn_dot:
                setNumber(".");
                break;
        }
    }

    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.btn_ac:
                textView.setText("0");
                first = 0;
                second = 0;
                break;
            case R.id.btn_plus_minus:
                textView.setText("-" + textView.getText());
                break;
            case R.id.btn_percent:
                operation = "%";
                first = Double.parseDouble(textView.getText().toString());
                isOperationClick = true;
                break;
            case R.id.btn_plus:
                operation = "+";
                first = Double.parseDouble(textView.getText().toString());
                isOperationClick = true;
                break;
            case R.id.btn_minus:
                operation = "-";
                first = Double.parseDouble(textView.getText().toString());
                isOperationClick = true;
                break;
            case R.id.btn_multiply:
                operation = "*";
                first = Double.parseDouble(textView.getText().toString());
                isOperationClick = true;
                break;
            case R.id.btn_divide:
                operation = "/";
                first = Double.parseDouble(textView.getText().toString());
                isOperationClick = true;
                break;
            case R.id.btn_equals:
                second = Double.parseDouble(textView.getText().toString());
                Double result = 0.0;
                switch (operation) {
                    case "+":
                        result = first + second;
                        break;
                    case "-":
                        result = first - second;
                        break;
                    case "*":
                        result = first * second;
                        break;
                    case "/":
                        if (first != 0 && second != 0) {
                            result = first / second;
                        } else {
                            Toast.makeText(this, "На ноль делить нельзя!", Toast.LENGTH_SHORT).show();
                            textView.setText("0");
                            first = 0;
                            second = 0;
                            return;
                        }
                        break;
                    case "%":
                        result = Math.abs(first) * (Math.abs(second) / 100);
                        break;
                }
                if(result % 1 == 0){
                    int resultInt = (int) Math.round(result);
                    textView.setText(String.valueOf(resultInt));
                }else {
                    textView.setText(result.toString());
                }
                isOperationClick = true;
                break;
        }
    }

    public void setNumber(String string) {
        if (textView.getText().toString().equals("0")) {
            textView.setText(string);
        } else if (isOperationClick) {
            textView.setText(string);
        } else {
            textView.append(string);
        }
        isOperationClick = false;
    }

}