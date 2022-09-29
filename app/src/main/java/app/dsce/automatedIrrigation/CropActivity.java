package app.dsce.automatedIrrigation;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;

public class CropActivity extends AppCompatActivity {

    Spinner crop,growth;

    ArrayList<String> cropList = new ArrayList<String>(Arrays.asList("Select an Option","Potato","Onion","Tomato","Cauliflower"));
    ArrayList<String> cropStage = new ArrayList<String>(Arrays.asList("Select an Option","Initial Stage","Mid Stage","End Stage"));
    String CropType,CropStage;
    //DatabaseReference db;
    ProgressBar progressBar;
    EditText lenght,breadth;
    Button saveButton;
    TextView totalWater,tempCrop;
    //SharedPreferences sp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Crop Details");

        lenght = findViewById(R.id.lengthText);
        breadth = findViewById(R.id.lengthText);
        crop = findViewById(R.id.CropSpinner);
        growth = findViewById(R.id.GrowthSpinner);


        progressBar = findViewById(R.id.progressBar);
        saveButton = findViewById(R.id.Savebutton);
        totalWater = findViewById(R.id.totalWatertv);
        tempCrop = findViewById(R.id.tempCrop);


        crop.setAdapter(new ArrayAdapter<String>(CropActivity.this, android.R.layout.simple_spinner_dropdown_item, cropList));
        growth.setAdapter(new ArrayAdapter<String>(CropActivity.this, android.R.layout.simple_spinner_dropdown_item, cropStage));

        final SharedPreferences sp = getApplicationContext().getSharedPreferences("Weatherforcast", Context.MODE_PRIVATE);
        final String temperatureee = sp.getString("temperature","");

        tempCrop.setText(temperatureee);



        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int len = Integer.parseInt(lenght.getText().toString());
                int brea = Integer.parseInt(lenght.getText().toString());
                int temp = Integer.parseInt(temperatureee);
                int volume = len * brea;


                    CropType = crop.getSelectedItem().toString();
                    CropStage = growth.getSelectedItem().toString();


                    if (CropType.equals("Potato")){
                        if (CropStage.equals("Initial Stage")){
                            if(temp>=0 && temp<=19){
                                double wr = volume * 2.9;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);

                            }
                            if(temp>=20 && temp<=30){
                                double wr = volume * 2.8;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);

                            }
                            if(temp>=31 && temp<=40){
                                double wr = volume * 3.2;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }

                        }else if(CropStage.equals("Mid Stage")){
                            if(temp>=0 && temp<=19){
                                double wr = volume * 3.1;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }
                            if(temp>=20 && temp<=30){
                                double wr = volume * 3.3;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }
                            if(temp>=31 && temp<=40){
                                double wr = volume * 3.4;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }


                        }else if(CropStage.equals("End Stage")){
                            if(temp>=0 && temp<=19){
                                double wr = volume * 3.3;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }
                            if(temp>=20 && temp<=30){
                                double wr = volume * 3.5;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }
                            if(temp>=31 && temp<=40){
                                double wr = volume * 3.8;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }

                        }
                    }else if (CropType.equals("Onion")){
                        if (CropStage.equals("Initial Stage")){
                            if(temp>=0 && temp<=19){
                                double wr = volume * 1.12;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }
                            if(temp>=20 && temp<=30){
                                double wr = volume * 1.22;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }
                            if(temp>=31 && temp<=40){
                                double wr = volume * 1.32;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }


                        }else if(CropStage.equals("Mid Stage")){
                            if(temp>=0 && temp<=19){
                                double wr = volume * 1.32;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }
                            if(temp>=20 && temp<=30){
                                double wr = volume * 1.52;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }
                            if(temp>=31 && temp<=40){
                                double wr = volume * 1.72;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }


                        }else if(CropStage.equals("End Stage")){
                            if(temp>=0 && temp<=19){
                                double wr = volume * 1.52;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }
                            if(temp>=20 && temp<=30){
                                double wr = volume * 1.72;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }
                            if(temp>=31 && temp<=40){
                                double wr = volume * 1.92;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }


                        }
                    }else if (CropType.equals("Tomato")){
                        if (CropStage.equals("Initial Stage")){
                            if(temp>=0 && temp<=19){
                                double wr = volume * 0.78;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }
                            if(temp>=20 && temp<=30){
                                double wr = volume * 0.98;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }
                            if(temp>=31 && temp<=40){
                                double wr = volume * 1.1;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }


                        }else if(CropStage.equals("Mid Stage")){
                            if(temp>=0 && temp<=19){
                                double wr = volume * 0.98;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }
                            if(temp>=20 && temp<=30){
                                double wr = volume * 1.1;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }
                            if(temp>=31 && temp<=40){
                                double wr = volume * 1.38;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }


                        }else if(CropStage.equals("End Stage")){

                            if(temp>=0 && temp<=19){
                                double wr = volume * 1.32;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }
                            if(temp>=20 && temp<=30){
                                double wr = volume * 1.52;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }
                            if(temp>=31 && temp<=40){
                                double wr = volume * 1.72;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }
                        }
                    }else if (CropType.equals("Cauliflower")){
                        if (CropStage.equals("Initial Stage")){
                            if(temp>=0 && temp<=19){
                                double wr = volume * 1.32;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }
                            if(temp>=20 && temp<=30){
                                double wr = volume * 1.52;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }
                            if(temp>=31 && temp<=40){
                                double wr = volume * 1.72;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }

                        }else if(CropStage.equals("Mid Stage")){

                            if(temp>=0 && temp<=19){
                                double wr = volume * 1.32;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }
                            if(temp>=20 && temp<=30){
                                double wr = volume * 1.52;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }
                            if(temp>=31 && temp<=40){
                                double wr = volume * 1.72;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }
                        }else if(CropStage.equals("End Stage")){

                            if(temp>=0 && temp<=19){
                                double wr = volume * 1.32;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }
                            if(temp>=20 && temp<=30){
                                double wr = volume * 1.52;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }
                            if(temp>=31 && temp<=40){
                                double wr = volume * 1.72;
                                sendVolData(wr);
                                String waterStr = Double.toString(wr);
                                totalWater.setText(waterStr);
                            }
                        }
                    }






                }

            private void sendVolData(double wr) {


                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("volumeRequired");

                myRef.setValue(wr);
                String waterReq = Double.toString(wr);

//                SharedPreferences.Editor editor = sp.edit();
//
//
//
//                editor.putString("finalVolRequired",waterReq);
//                editor.commit();
                
            }

        });


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
