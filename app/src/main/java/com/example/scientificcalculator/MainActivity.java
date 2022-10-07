package com.example.scientificcalculator;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(R.string.display).equals(display.getText().toString()))
                    display.setText("");
            }
        });
    }

    private void updateText (String strToAdd) {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if (getString(R.string.display).equals(display.getText().toString())) {
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);
        }
        else{
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + 1);
        }

    }

    public void zeroBTN(View view) {
        updateText("0");
    }
    public void oneBTN(View view) {
        updateText("1");
    }
    public void twoBTN(View view) {
        updateText("2");
    }
    public void threeBTN(View view) {
        updateText("3");
    }
    public void fourBTN(View view) {
        updateText("4");
    }
    public void fiveBTN(View view) {
        updateText("5");
    }
    public void sixBTN(View view) {
        updateText("6");
    }
    public void sevenBTN(View view) {
        updateText("7");
    }
    public void eightBTN(View view) {
        updateText("8");
    }
    public void nineBTN(View view) {
        updateText("9");
    }

    public void all_clear(View view) {
        display.setText("");
    }
    public void backspaceBTN(View view) {
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }
    }
    public void addBTN(View view) {
        updateText("+");
    }
    public void minusBTN(View view) {
        updateText("-");
    }
    public void multiplyBTN(View view) {
        updateText("*");
    }
    public void divideBTN(View view) {
        updateText("÷");
    }
    public void pointBTN(View view) {
        updateText(".");
    }

    public void equalBTN(View view) {
        String userExp = display.getText().toString();

        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("×", "*");

        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }

    public void exponentBTN(View view) {
        updateText("^");
    }

    public void parenthesisBTN(View view) {
        int cursorPos = display.getSelectionStart();
        int openPar = 0;
        int closedPar = 0;
        int textLen = display.getText().length();

        for (int i = 0; i < cursorPos; i++) {
            if (display.getText().toString().substring(i, i+1).equals("(")) {
                openPar += 1;
            }
            if (display.getText().toString().substring(i, i+1).equals(")")) {
                closedPar += 1;
            }
        }

        if (openPar == closedPar || display.getText().toString().substring(textLen-1, textLen).equals("(")) {
            updateText("(");
        }
        if (closedPar < openPar && !display.getText().toString().substring(textLen-1, textLen).equals("(")) {
            updateText(")");
        }
        display.setSelection(cursorPos + 1);
    }

    public void factorialBTN(View view) {
        updateText("!");
    }
    public void moduloBTN(View view) {
        updateText("%");
    }
    public void cube_rootBTN(View view) {

    }
    public void square_rootBTN(View view) {

    }
    public void log_b2BTN(View view) {

    }
    public void logBTN(View view) {

    }
    public void nprBTN(View view) {

    }
    public void ncrBTN(View view) {

    }
    public void abstractBTN(View view) {

    }
    public void roundBTN(View view) {

    }
    public void ceilBTN(View view) {

    }
    public void flrBTN(View view) {

    }
    public void maxBTN(View view) {

    }
    public void minBTN(View view) {

    }
    public void xBTN(View view) {

    }
    public void yBTN(View view) {

    }

    public void summation_notationBTN(View view) {

    }
    public void double_summationBTN(View view) {

    }
    public void product_notationBTN(View view) {

    }
    public void double_productBTN(View view) {

    }

}