package com.fadh.perkiraancuaca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Constraints;
import androidx.databinding.DataBindingUtil;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    ActivityBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      Log.v("","STARTED.... ...");
      activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
      init();
    }
  private void init() {
    activityMainBinding.fetchData.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Log.v("","CLICKED.... ...");
        Constraints constraints = new Constraints.Builder()
                .setRequiresDeviceIdle(true)
                .setRequiresCharging(true)
                .build();
        WorkManager mWorkManager = WorkManager.getInstance();
        PeriodicWorkRequest periodicWork = new PeriodicWorkRequest.Builder(API.class, 2, TimeUnit.HOURS)
                .setConstraints(constraints)
                .build();
        mWorkManager.enqueue(periodicWork);
        Log.v("","DOING ...");
      }
    });
  }
}