package com.yarin.bucketlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BucketListEntryAdapter extends RecyclerView.Adapter<BucketListEntryAdapter.BucketListEntryViewHolder> {

    private final BucketListEntry[] entries;

    public BucketListEntryAdapter(BucketListEntry[] entries) {
        this.entries = entries;
    }

    @NonNull
    @Override
    public BucketListEntryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bucketlist, parent, false);
        return new BucketListEntryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BucketListEntryViewHolder holder, int position) {
        holder.bind(entries[position], position);
    }

    @Override
    public int getItemCount() {
        return entries.length;
    }

    static class BucketListEntryViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView header, description;
        private final RatingBar ratingBar;


        public BucketListEntryViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.bucket_image);
            this.header = itemView.findViewById(R.id.text_heading);
            this.description = itemView.findViewById(R.id.text_description);
            this.ratingBar = itemView.findViewById(R.id.ratingbar);
        }

        public void bind(final BucketListEntry entry, int position) {
            final String headerString = position + 1 + ". " + entry.getHeading();
            imageView.setImageResource(entry.getImage());
            header.setText(headerString);
            description.setText(entry.getDescription());
            ratingBar.setRating(entry.getRating());
        }
    }

}
