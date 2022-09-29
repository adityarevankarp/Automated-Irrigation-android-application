package app.dsce.automatedIrrigation;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class WindActivity extends AppCompatActivity {
    TextView precip;
    DatabaseReference db;
    ProgressBar precipPB;

    TextView humTV;
    ProgressBar humPB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wind);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Wind and Pressure");

        precip = findViewById(R.id.PrecipAmount);
        precipPB = findViewById(R.id.PrecipPB);

        humTV = findViewById(R.id.humidityPercentage);
        humPB = findViewById(R.id.humidityPB);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("Weatherforcast", Context.MODE_PRIVATE);
        String windspeed = sp.getString("windspeed","");
        String pressure = sp.getString("pressure","");

                precip.setText(windspeed+"m/s");

                precipPB.setVisibility(View.GONE);
                precip.setVisibility(View.VISIBLE);

                humTV.setText(pressure);

                humPB.setVisibility(View.GONE);
                humTV.setVisibility(View.VISIBLE);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch(id) {
            // back button
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
