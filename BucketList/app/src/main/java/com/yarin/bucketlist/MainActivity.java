package com.yarin.bucketlist;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupClickListeners();
    }



    private void setupClickListeners() {
        final CardView thingsToDoCard = findViewById(R.id.card_thingstodo);
        final CardView placesToGoCard = findViewById(R.id.card_placestogo);

        thingsToDoCard.setOnClickListener(v -> startActivity(new Intent(this, ThingsToDoActivity.class)));
        placesToGoCard.setOnClickListener(v -> startActivity(new Intent(this, PlacesToGoActivity.class)));

    }
}