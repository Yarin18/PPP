package com.yarin.bucketlist;

public class BucketListEntry {

    private final String heading, description;
    private final int image;
    private final float rating;

    public BucketListEntry(String heading, String description, int image, float rating) {
        this.heading = heading;
        this.description = description;
        this.image = image;
        this.rating = rating;
    }

    public String getHeading() {
        return heading;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }

    public float getRating() {
        return rating;
    }
}
