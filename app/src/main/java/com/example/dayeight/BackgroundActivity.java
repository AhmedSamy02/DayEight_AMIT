package com.example.dayeight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.dayeight.databinding.ActivityBackgroundBinding;

public class BackgroundActivity extends AppCompatActivity {
    ActivityBackgroundBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_background);
        Intent backgroundIntent=new Intent(this,backgroundService.class);
        binding.start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isMyServiceRunning(backgroundService.class)){
                    //true
                    binding.start.setText("Stopped");
                    stopService(backgroundIntent);
                }
                else{
                    binding.start.setText("Started");
                    startService(backgroundIntent);
                }

            }
        });
    }
    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}