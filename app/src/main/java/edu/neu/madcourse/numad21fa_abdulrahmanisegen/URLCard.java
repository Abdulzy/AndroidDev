package edu.neu.madcourse.numad21fa_abdulrahmanisegen;

import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;

public class URLCard extends AppCompatActivity implements UrlListener {
    private final String name;
    private final String url;

    //Constructor
    public URLCard(String item_name, String item_url) {
        this.name = item_name;
        this.url = item_url;
    }

    //Getters for the name and
    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public void onURLClick(int position) {
        Uri uri = Uri.parse(url);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}
