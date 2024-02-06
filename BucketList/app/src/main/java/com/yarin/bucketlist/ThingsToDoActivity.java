package com.yarin.bucketlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ThingsToDoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_things_to_do);

        setupList();
    }

    private void setupList() {
        final BucketListEntry[] bucketList = {
                new BucketListEntry("Climb Mt Kilimanjaro", "Do it the difficult way!", R.drawable.kilimanjaro, 5f),
                new BucketListEntry("Experience the Northern Lights", "Somewhere in the arctic circle, probably Norway!", R.drawable.northern_lights, 4.5f),
                new BucketListEntry("Roadtrip Across the USA", "Hire a car from the west coast, and travel to the east coast.", R.drawable.road_trip, 5f),
                new BucketListEntry("Scuba Dive", "In Koh Tao, Thailand.", R.drawable.scubadive, 1f),
                new BucketListEntry("Skydive", "Preferably over somewhere with an amazing view", R.drawable.skydive, 3.5f),
        };

        final RecyclerView recyclerView = findViewById(R.id.recycler_view_thingstodo);
        final BucketListEntryAdapter adapter = new BucketListEntryAdapter(bucketList);
        recyclerView.setAdapter(adapter);
    }
}