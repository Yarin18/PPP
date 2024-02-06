package com.yarin.portfolioproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView list = findViewById(R.id.recyclerview_projects);

        final Project[] projects = {
                new Project("Getting Started App", "The default 'Hello World' app", R.drawable.getting_started),
                new Project("Quotes", "The Quote App", R.drawable.quote),
                new Project("BMI Calculator", "Calculate BMI", R.drawable.calculator),
                new Project("Inches Converter", "Convert inches to meters", R.drawable.tape),
                new Project("The Restaurant App", "Restaurant app", R.drawable.hungry_developer)
        };

        final ProjectAdapter adapter = new ProjectAdapter(projects);

        list.setAdapter(adapter);


    }
}