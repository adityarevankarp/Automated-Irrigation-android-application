package app.dsce.automatedIrrigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Irrigate extends AppCompatActivity {
    Button ON,OFF;
    TextView timer,status;
    private long START_TIME_IN_MILLIS ;
    private CountDownTimer mCountDownTimer;
    private boolean timerRunning;

    private boolean mTimerRunning;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_irrigate);

        getSupportActionBar().setTitle("Irrigate");

        ON = findViewById(R.id.turnOnBtn);
        OFF = findViewById(R.id.turnOffBtn);
        timer = findViewById(R.id.timer);
        status = findViewById(R.id.statusTV);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("volumeRequired");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Integer value = dataSnapshot.getValue(Integer.class);
                Toast.makeText(Irrigate.this, "value is"+value, Toast.LENGTH_SHORT).show();
                //int total = value/2000;

                senddata(value);



                //volreqfinal.setText(value);


            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



//        SharedPreferences sp = getApplicationContext().getSharedPreferences("CropActivity", Context.MODE_PRIVATE);
//        String finalvol = sp.getString("finalVolRequired","");

//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("volumeRequired");
//        ref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                int value = dataSnapshot.getValue(int.class);
//                String val = Integer.toString(value);
//                volreqfinal.setText(val);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });





        //volreqfinal.setText(finalvol);



        ON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               startStop();
               status.setText("Water Pump is ON");
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("relay");

                myRef.setValue(0);
            }
        });

        OFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopTimer();
                status.setText("Water Pump is OFF");
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("relay");

                myRef.setValue(1);
            }
        });


    }

    private void senddata(Integer value) {

        int min = value/2000;
        int mint = min * 60000;
        START_TIME_IN_MILLIS = mint;
    }

    public void startStop() {
        if(timerRunning){
            stopTimer();
        }else{
            startTimer();
        }
    }

    public void stopTimer() {
        mCountDownTimer.cancel();
        timerRunning = false;
    }

    public void startTimer(){

        mCountDownTimer = new CountDownTimer(START_TIME_IN_MILLIS,1000) {
            @Override
            public void onTick(long l) {
                START_TIME_IN_MILLIS = l;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();

        timerRunning  = true;

    }

    public void updateTimer(){
        int minuts = (int) START_TIME_IN_MILLIS/60000;
        int seconds = (int) START_TIME_IN_MILLIS % 60000 / 1000;

        String timelefttext;

        timelefttext = "" + minuts;
        timelefttext += ":";
        if(seconds < 10) timelefttext += "0";
        timelefttext += seconds;

        timer.setText(timelefttext);
    }


}