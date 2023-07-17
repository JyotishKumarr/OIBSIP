package com.example.unitconverterfinal;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ConversionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerFrom, spinnerTo;
    private Button btnConvert;
    private EditText e1, e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

        // Get the selected conversion type from the intent
        String conversionType = getIntent().getStringExtra("conversionType");

        // Set the title of the activity based on the conversion type
        setTitle(conversionType + " Conversion");

        spinnerFrom = findViewById(R.id.spinnerFrom);
        spinnerTo = findViewById(R.id.spinnerTo);
        btnConvert = findViewById(R.id.btnConvert);
        e1 = findViewById(R.id.input1);
        e2 = findViewById(R.id.output);
        // Populate the spinners with conversion units based on the selected conversion type
        List<String> conversionUnits = getConversionUnits(conversionType);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, conversionUnits);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerFrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);

        spinnerFrom.setOnItemSelectedListener(this);
        spinnerTo.setOnItemSelectedListener(this);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String unitFrom = spinnerFrom.getSelectedItem().toString();
                String unitTo = spinnerTo.getSelectedItem().toString();

                // Get the input value from the input EditText
                double inputValue = 0.0;
                try {
                    inputValue = Double.parseDouble(e1.getText().toString());
                } catch (NumberFormatException e) {
                    Toast.makeText(ConversionActivity.this, "Invalid input value", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Perform the conversion based on the selected units
                double result = performConversion(unitFrom, unitTo, inputValue);

                // Display the result or show an error message
                if (result != Double.MIN_VALUE) {
                    e2.setText(String.valueOf(result));
                } else {
                    Toast.makeText(ConversionActivity.this, "Invalid conversion units", Toast.LENGTH_SHORT).show();
                }
            }

            private double performConversion(String unitFrom, String unitTo, double inputValue) {
                double result = Double.MIN_VALUE;

                // Conversion logic for Temperature
                if (unitFrom.equals("Celsius") && unitTo.equals("Fahrenheit")) {
                    result = (inputValue * 9/5) + 32;
                } else if (unitFrom.equals("Fahrenheit") && unitTo.equals("Celsius")) {
                    result = (inputValue - 32) * 5/9;
                } else if (unitFrom.equals("Celsius") && unitTo.equals("Kelvin")) {
                    result = inputValue + 273.15;
                } else if (unitFrom.equals("Kelvin") && unitTo.equals("Celsius")) {
                    result = inputValue - 273.15;
                } else if (unitFrom.equals("Fahrenheit") && unitTo.equals("Kelvin")) {
                    result = (inputValue + 459.67) * 5/9;
                } else if (unitFrom.equals("Kelvin") && unitTo.equals("Fahrenheit")) {
                    result = (inputValue * 9/5) - 459.67;
                }

                // Conversion logic for Length
                // Add your conversion logic for length units here
                if (unitFrom.equals("Meter") && unitTo.equals("Foot")) {
                    result = inputValue * 3.28084;
                } else if (unitFrom.equals("Meter") && unitTo.equals("Mile")) {
                    result = inputValue * 0.000621371192;
                } else if (unitFrom.equals("Meter") && unitTo.equals("Inch")) {
                    result = inputValue * 39.3701;
                } else if (unitFrom.equals("Meter") && unitTo.equals("Centimeter")) {
                    result = inputValue * 100;
                } else if (unitFrom.equals("Meter") && unitTo.equals("Kilometer")) {
                    result = inputValue / 1000;
                } else if (unitFrom.equals("Foot") && unitTo.equals("Meter")) {
                    result = inputValue / 3.28084;
                } else if(unitFrom.equals("Foot") && unitTo.equals("Inch")){
                    result = inputValue * 12;
                }else if(unitFrom.equals("Foot") && unitTo.equals("Centimeter")){
                    result = inputValue * 30.48;
                }else if(unitFrom.equals("Foot") && unitTo.equals("Kilometer")){
                    result = inputValue * 0.0003048;
                }else if(unitFrom.equals("Foot") && unitTo.equals("Mile")){
                    result = inputValue * 0.000189;
                }else if (unitFrom.equals("Inch") && unitTo.equals("Meter")) {
                    result = inputValue / 39.3701;
                }else if (unitFrom.equals("Inch") && unitTo.equals("Kilometer")) {
                    result = inputValue /39370.07;
                }else if (unitFrom.equals("Inch") && unitTo.equals("Centimeter")) {
                    result = inputValue * 2.54;
                }else if (unitFrom.equals("Inch") && unitTo.equals("Mile")) {
                    result = inputValue / 63360;
                } else if (unitFrom.equals("Inch") && unitTo.equals("Foot")) {
                    result = inputValue * 0.083333;
                }else if (unitFrom.equals("Centimeter") && unitTo.equals("Meter")) {
                    result = inputValue / 100;
                } else if (unitFrom.equals("Centimeter") && unitTo.equals("Inch")) {
                    result = inputValue / 2.54;
                } else if (unitFrom.equals("Centimeter") && unitTo.equals("Kilometer")) {
                    result = inputValue / 100000;
                } else if (unitFrom.equals("Centimeter") && unitTo.equals("Mile")) {
                    result = inputValue / 160934.4;
                } else if (unitFrom.equals("Centimeter") && unitTo.equals("Foot")) {
                    result = inputValue * 0.0328;
                } else if (unitFrom.toString() == unitTo.toString()) {
                    result = inputValue;
                } else if (unitFrom.equals("Kilometer") && unitTo.equals("Meter")) {
                    result = inputValue * 1000;
                } else if (unitFrom.equals("Kilometer") && unitTo.equals("Mile")) {
                    result = inputValue / 1.60934;
                } else if (unitFrom.equals("Kilometer") && unitTo.equals("Centimeter")) {
                    result = inputValue * 100000;
                } else if (unitFrom.equals("Kilometer") && unitTo.equals("Foot")) {
                    result = inputValue * 3280.8399;
                } else if (unitFrom.equals("Kilometer") && unitTo.equals("Inch")) {
                    result = inputValue * 39370.0787;
                } else if (unitFrom.equals("Mile") && unitTo.equals("Kilometer")) {
                    result = inputValue * 1.60934;
                } else if (unitFrom.equals("Mile") && unitTo.equals("Meter")) {
                    result = inputValue * 1609.344;
                } else if (unitFrom.equals("Mile") && unitTo.equals("Centimeter")) {
                    result = inputValue * 160934.4;
                } else if (unitFrom.equals("Mile") && unitTo.equals("Foot")) {
                    result = inputValue * 5280;
                } else if (unitFrom.equals("Mile") && unitTo.equals("Inch")) {
                    result = inputValue * 63360;
                }
                // Conversion logic for Weight
                // Add your conversion logic for weight units here
                if (unitFrom.equals("Gram") && unitTo.equals("Kilogram")) {
                    result = inputValue * 0.001;
                } else if (unitFrom.equals("Gram") && unitTo.equals("Pound")) {
                    result = inputValue * 63360;
                } else if (unitFrom.equals("Gram") && unitTo.equals("Ounce")) {
                    result = inputValue * 0.035274;
                } else if (unitFrom.equals("Kilogram") && unitTo.equals("Gram")) {
                    result = inputValue * 1000;
                } else if (unitFrom.equals("Kilogram") && unitTo.equals("Pound")) {
                    result = inputValue * 2.20462;
                } else if (unitFrom.equals("Kilogram") && unitTo.equals("Ounce")) {
                    result = inputValue * 35.274;
                } else if (unitFrom.equals("Pound") && unitTo.equals("Gram")) {
                    result = inputValue / 0.00220462;
                } else if (unitFrom.equals("Pound") && unitTo.equals("Kilogram")) {
                    result = inputValue / 2.20462;
                } else if (unitFrom.equals("Pound") && unitTo.equals("Ounce")) {
                    result = inputValue * 16;
                } else if (unitFrom.equals("Ounce") && unitTo.equals("Gram")) {
                    result = inputValue / 0.035274;
                } else if (unitFrom.equals("Ounce") && unitTo.equals("Kilogram")) {
                    result = inputValue / 0.035274;
                } else if (unitFrom.equals("Ounce") && unitTo.equals("Pound")) {
                    result = inputValue / 16;
                }
                // Conversion logic for Volume
                // Add your conversion logic for volume units here
                if (unitFrom.equals("Liter") && unitTo.equals("Millileter")) {
                    result = inputValue * 1000;
                } else if (unitFrom.equals("Liter") && unitTo.equals("Gallon")) {
                    result = inputValue * 0.264172;
                } else if (unitFrom.equals("Liter") && unitTo.equals("Quart")) {
                    result = inputValue * 1.05669;
                } else if (unitFrom.equals("Milliliter") && unitTo.equals("Liter")) {
                    result = inputValue / 1000;
                } else if (unitFrom.equals("Milliliter") && unitTo.equals("Gallon")) {
                    result = inputValue * 0.000264172;
                } else if (unitFrom.equals("Milliliter") && unitTo.equals("Quart")) {
                    result = inputValue * 0.00105669;
                } else if (unitFrom.equals("Gallon") && unitTo.equals("Liter")) {
                    result = inputValue / 0.264172;
                } else if (unitFrom.equals("Gallon") && unitTo.equals("Milliliter")) {
                    result = inputValue / 0.000264172;
                } else if (unitFrom.equals("Gallon") && unitTo.equals("Quart")) {
                    result = inputValue * 4;
                } else if (unitFrom.equals("Quart") && unitTo.equals("Liter")) {
                    result = inputValue / 1.05669;
                } else if (unitFrom.equals("Quart") && unitTo.equals("Milliliter")) {
                    result = inputValue / 0.00105669;
                } else if (unitFrom.equals("Quart") && unitTo.equals("Gallon")) {
                    result = inputValue / 4;
                }

                return result;
            }

        });


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Handle spinner item selection if needed
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Handle no spinner item selected if needed
    }

    private List<String> getConversionUnits(String conversionType) {
        // Get the conversion units based on the selected conversion type
        List<String> conversionUnits = new ArrayList<>();

        // Add conversion units for the selected conversion type
        // Modify this section based on your specific conversion requirements

        if (conversionType.equals("Temperature")) {
            conversionUnits.add("Celsius");
            conversionUnits.add("Fahrenheit");
            conversionUnits.add("Kelvin");
        } else if (conversionType.equals("Length")) {
            conversionUnits.add("Meter");
            conversionUnits.add("Kilometer");
            conversionUnits.add("Centimeter");
            conversionUnits.add("Foot");
            conversionUnits.add("Mile");
            conversionUnits.add("Inch");

        } else if (conversionType.equals("Weight")) {
            conversionUnits.add("Gram");
            conversionUnits.add("Kilogram");
            conversionUnits.add("Pound");
            conversionUnits.add("Ounce");
        } else if (conversionType.equals("Volume")) {
            conversionUnits.add("Liter");
            conversionUnits.add("Milliliter");
            conversionUnits.add("Gallon");
            conversionUnits.add("Quart");
        }

        return conversionUnits;
    }


}
