package app.dsce.automatedIrrigation;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class TempActivity extends AppCompatActivity {

    TextView temp,weather,tempview,descriptionn;
    DatabaseReference db;
    ProgressBar tempPB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Temperature and Weather");

        temp = findViewById(R.id.TempTV);

        weather = findViewById(R.id.weatherCondition);
        tempview = findViewById(R.id.textView6);
        descriptionn = findViewById(R.id.textView7);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("Weatherforcast", Context.MODE_PRIVATE);
        String temperatureee = sp.getString("temperature","");
        String description  = sp.getString("clowdiness","");

        tempview.setText(temperatureee+"°C");
        descriptionn.setText(description);


        //db = FirebaseDatabase.getInstance().getReference();
//        db.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String temperature = dataSnapshot.child("DisplayTempMin").getValue().toString();
//                temp.setText(temperature.substring(0,2)+"\u00B0"+"C");
//
//                String weatherCondition = dataSnapshot.child("CurrentWeather").getValue().toString();
//                weather.setText("Weather Condition:"+weatherCondition);
//                tempPB.setVisibility(View.GONE);
//                temp.setVisibility(View.VISIBLE);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                tempPB.setVisibility(View.GONE);
//                new AlertDialog.Builder(TempActivity.this)
//                        .setTitle("Oops!")
//                        .setMessage("Something went wrong!")
//                        .setNegativeButton("Cancel", null)
//                        .setIcon(R.drawable.ic_alert)
//                        .show();
//            }
//        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
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
