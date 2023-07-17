package com.example.unitconverterfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnTemperature, btnLength, btnWeight, btnVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTemperature = findViewById(R.id.btnTemperature);
        btnLength = findViewById(R.id.btnLength);
        btnWeight = findViewById(R.id.btnWeight);
        btnVolume = findViewById(R.id.btnVolume);

        btnTemperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConversionActivity("Temperature");
            }
        });

        btnLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConversionActivity("Length");
            }
        });

        btnWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConversionActivity("Weight");
            }
        });

        btnVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConversionActivity("Volume");
            }
        });
    }

    private void openConversionActivity(String conversionType) {
        Intent intent = new Intent(MainActivity.this, ConversionActivity.class);
        intent.putExtra("conversionType", conversionType);
        startActivity(intent);
    }
}
