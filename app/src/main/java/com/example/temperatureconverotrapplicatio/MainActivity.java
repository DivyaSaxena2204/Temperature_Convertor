package com.example.temperatureconverotrapplicatio;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextValue;
    private RadioGroup radioGroup;
    private RadioButton radioCelsius, radioFahrenheit;
    private Button convertButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextValue = findViewById(R.id.editTextValue);
        radioGroup = findViewById(R.id.radioGroup);
        radioCelsius = findViewById(R.id.radioCelsius);
        radioFahrenheit = findViewById(R.id.radioFahrenheit);
        convertButton = findViewById(R.id.convertButton);
        resultTextView = findViewById(R.id.resultTextView);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
            }
        });
    }

    private void convertTemperature() {
        String input = editTextValue.getText().toString().trim();
        if (input.isEmpty()) {
            resultTextView.setText("Please enter a temperature.");
            return;
        }

        double temperature = Double.parseDouble(input);
        double convertedTemperature;

        if (radioCelsius.isChecked()) {
            convertedTemperature = (temperature - 32) * 5 / 9;
            resultTextView.setText("Result: " + convertedTemperature + " °C");
        } else if (radioFahrenheit.isChecked()) {
            convertedTemperature = (temperature * 9 / 5) + 32;
            resultTextView.setText("Result: " + convertedTemperature + " °F");
        }
    }
}
