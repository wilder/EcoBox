package com.wilderpereira.ecobox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TrashTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trash_type);
    }

    public void proceed(View view) {
        startActivity(new Intent(this, WaitingActivity.class));
    }
}
