package com.yarin.bucketlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class PlacesToGoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_to_go);
        setupList();
    }

    private void setupList() {
        final BucketListEntry[] bucketList = {
                new BucketListEntry("Vietnam", "Wow! Description here", R.drawable.kilimanjaro, 5f),
                new BucketListEntry("Kerala, India", "Wow! Description here", R.drawable.northern_lights, 4.5f),
                new BucketListEntry("Japan", "Wow! Description here", R.drawable.road_trip, 5f),
                new BucketListEntry("Iceland", "Wow! Description here", R.drawable.scubadive, 1f),
                new BucketListEntry("The Amazon, Brazil", "Wow! Description here", R.drawable.skydive, 3.5f),
        };

        final RecyclerView recyclerView = findViewById(R.id.recycler_view_placestogo);
        final BucketListEntryAdapter adapter = new BucketListEntryAdapter(bucketList);
        recyclerView.setAdapter(adapter);
    }
}