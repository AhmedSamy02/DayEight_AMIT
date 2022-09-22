package com.example.dayeight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.dayeight.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    Intent foregroundIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        foregroundIntent=new Intent(MainActivity.this,foreground_service.class);
        binding.start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService();
            }
        });
        binding.stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(foregroundIntent);
                Toast.makeText(MainActivity.this, "Service Stopped Succesfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,BackgroundActivity.class));
            }
        });

    }

    private void startService() {
        foregroundIntent.putExtra("foreground","Forground Service Started");
        ContextCompat.startForegroundService(getApplicationContext(),foregroundIntent);
    }
}