package com.yarin.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private RadioButton male, female;

    private EditText age, feet, weight, inches;
    private Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();


    }

    private void findViews() {
        this.result = findViewById(R.id.textview_result);

        this.male = findViewById(R.id.radio_button_male);
        this.female = findViewById(R.id.radio_button_female);

        this.age = findViewById(R.id.edit_text_age);
        this.feet = findViewById(R.id.edit_text_feet);
        this.weight = findViewById(R.id.edit_text_weight);
        this.inches = findViewById(R.id.edit_text_inches);

        this.calculate = findViewById(R.id.button_calculate);
    }

    private void setupButtonClickListener() {
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double res = calculateBmi();

                final String ageText = age.getText().toString();
                final int age = Integer.parseInt(ageText);

                if (age >= 18) {
                    displayResult(res);
                } else {
                    displayGuidance(res);
                }

            }
        });
    }

    private void displayGuidance(double bmi) {
        final DecimalFormat decimalFormat = new DecimalFormat("0.00");
        final String bmiText = decimalFormat.format(bmi);

        String fullRes = "";
        if (male.isChecked()) {
            fullRes = bmiText + "- As you are under 18, please consult with your doctor for the healthy range for boys";
        } else if (female.isChecked()) {
            fullRes = bmiText + "- As you are under 18, please consult with your doctor for the healthy range for girls";
        } else {
            fullRes = bmiText + "- As you are under 18, please consult with your doctor for the healthy range";
        }
        result.setText(fullRes);
    }

    private double calculateBmi() {
        final String feetText = feet.getText().toString();
        final String weightText = weight.getText().toString();
        final String inchesText = inches.getText().toString();

        final int feet = Integer.parseInt(feetText);
        final int weight = Integer.parseInt(weightText);
        final int inches = Integer.parseInt(inchesText);

        final int totalInches = (feet * 12) + inches;
        final double heightInMeters = totalInches * 0.254;

        return weight / (heightInMeters * heightInMeters);
    }

    private void displayResult(double bmi) {
        final DecimalFormat formatter = new DecimalFormat("0.00");

        final String resText = formatter.format(bmi);

        String full = "";
        if (bmi < 18.5) {
            full = resText + " - You are underweight";
        } else if (bmi > 25) {
            full = resText + "- You are overweight";
        } else {
            full = "You are healthy";
        }

        result.setText(full);
    }

}