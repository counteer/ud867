package com.zflabs.jokedisplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class DisplayJokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
        String text = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}
