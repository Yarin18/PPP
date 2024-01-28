package com.yarin.challengesection5;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText inchesEdit;
    private Button calculateBtn;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        calculateBtn.setOnClickListener((v) -> {
            final String inchestString = inchesEdit.getText().toString();
            if (inchestString.isEmpty()) {
                Toast.makeText(this, "Please input a value", Toast.LENGTH_LONG).show();
            } else {
                final double res = calculateHeight(inchestString);
                displayResult(res);
            }
        });
    }

    private void displayResult(final double res) {
        final DecimalFormat format = new DecimalFormat("0.00");
        final String resString = format.format(res);
        this.result.setText("Your height is " + resString + " meters");
    }

    private double calculateHeight(final String string) {
        final int inches = Integer.parseInt(string);
        return inches * 0.0254;
    }

    private void findViews() {
        this.inchesEdit = findViewById(R.id.edit_text_inches);
        this.calculateBtn = findViewById(R.id.button_calculate);
        this.result = findViewById(R.id.textview_result);
    }
}