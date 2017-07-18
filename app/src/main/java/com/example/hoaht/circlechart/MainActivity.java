package com.example.hoaht.circlechart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.hoaht.circlechart.widget.FanView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FanView fanView = (FanView) findViewById(R.id.fanView);
    }
}
