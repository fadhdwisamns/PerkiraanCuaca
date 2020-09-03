package com.fadh.perkiraancuaca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Constraints;
import androidx.databinding.DataBindingUtil;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fadh.perkiraancuaca.model.TodayWeather;
import com.fadh.perkiraancuaca.model.Weather;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

  ImageView image;
  TextView Lokasi, Deg, Wind, Sunset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      image = findViewById(R.id.img);
      Lokasi = findViewById(R.id.lokasi);
      Deg = findViewById(R.id.dag);
      Wind = findViewById(R.id.wind);
      Sunset = findViewById(R.id.sunset);

      callForecastbyCity("jakarta");
//
//      Log.v("","STARTED.... ...");
//      activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//      init();

    }
  APIInterfacesRest apiInterface;
  ProgressDialog progressDialog;
  private void callForecastbyCity(String kota) {
    apiInterface = API.getClient().create(APIInterfacesRest.class);
    progressDialog = new ProgressDialog(MainActivity.this);
    progressDialog.setTitle("Loading");
    progressDialog.show();
    Call<TodayWeather> call3 = apiInterface.getForecastByCity(kota,"a34bc11e6c2a41384f72dca0633c9959");
    call3.enqueue(new Callback<TodayWeather>() {
      @Override
      public void onResponse(Call<TodayWeather> call, Response<TodayWeather> response) {
        progressDialog.dismiss();
        TodayWeather dataWeather = response.body();
        if (dataWeather != null) {
          //     txtKota.setText(dataWeather.getName());
          //     txtTemperature.setText(new DecimalFormat("##.##").format(dataWeather.getMain().getTemp()-273.15));
          Deg.setText("Sun / " + String.valueOf(dataWeather.getWind().getDeg()) + " degree");
          Wind.setText("Wind " + String.valueOf(dataWeather.getWind().getSpeed()));
          Sunset.setText("Sunset " + String.valueOf(dataWeather.getSys().getSunset()));
          String img = "http://openweathermap.org/img/wn/" + dataWeather.getWeather().get(0).getIcon() + "@2x.png";
          Picasso.get().load(img).into(image);
        } else {

          try {
            JSONObject jObjError = new JSONObject(response.errorBody().string());
            Toast.makeText(MainActivity.this, jObjError.getString("message"), Toast.LENGTH_LONG).show();
          } catch (Exception e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
          }
        }
      }

      @Override
      public void onFailure(Call<TodayWeather> call, Throwable t) {
        progressDialog.dismiss();
        Toast.makeText(getApplicationContext(),"Hubungkan Internet",Toast.LENGTH_LONG).show();
        call.cancel();
      }
    });
  }
//  private void init() {
//    activityMainBinding.fetchData.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        Log.v("","CLICKED.... ...");
//        Constraints constraints = new Constraints.Builder()
//                .setRequiresDeviceIdle(true)
//                .setRequiresCharging(true)
//                .build();
//        WorkManager mWorkManager = WorkManager.getInstance();
//        PeriodicWorkRequest periodicWork = new PeriodicWorkRequest.Builder(API.class, 2, TimeUnit.HOURS)
//                .setConstraints(constraints)
//                .build();
//        mWorkManager.enqueue(periodicWork);
//        Log.v("","DOING ...");
//      }
//    });
//  }
}