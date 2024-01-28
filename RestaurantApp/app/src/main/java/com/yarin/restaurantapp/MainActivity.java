package com.yarin.restaurantapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    private CardView startersCard, mainsCard, desertsCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startersCard = findViewById(R.id.card_view_starters);
        mainsCard = findViewById(R.id.card_view_main);
        desertsCard = findViewById(R.id.card_view_deserts);

        startersCard.setOnClickListener(v -> startActivity(new Intent(this, StartersActivity.class)));
        mainsCard.setOnClickListener(v -> startActivity(new Intent(this, MainCoursesActivity.class)));
        desertsCard.setOnClickListener(v -> startActivity(new Intent(this, DesertsActivity.class)));

        final TextView emailView = findViewById(R.id.text_email);
        emailView.setOnClickListener(v -> {
            final Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:somemail@gmail.com"));
            startActivity(emailIntent);
        });

    }
}