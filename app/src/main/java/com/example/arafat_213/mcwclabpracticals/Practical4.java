package com.example.arafat_213.mcwclabpracticals;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

public class Practical4 extends AppCompatActivity {

    private AutoCompleteTextView actCountry;
    private Spinner stateSpinner;
    private String countries[] = {"India", "USA", "Canada", "Indonesia"};
    private String indiaStates[] = {"Gujarat", "Maharashtra", "Goa"};
    private String usaStates[] = {"New York", "Florida", "California"};
    private String canadaStates[] = {"Ontario"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical4);
        ArrayAdapter<String> countriesArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, countries);
        final ArrayAdapter<String> IndiaStatesArrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, indiaStates);
        final ArrayAdapter<String> usaStatesArrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, usaStates);
        final ArrayAdapter<String> canadaStatesArrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, canadaStates);
        actCountry = findViewById(R.id.actCountry);
        stateSpinner = findViewById(R.id.stateSpinner);
        actCountry.setAdapter(countriesArrayAdapter);
        actCountry.setThreshold(0);
        actCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), adapterView.getItemAtPosition(i) + " Selected ", Toast.LENGTH_SHORT).show();
                String selectedCountry = adapterView.getItemAtPosition(i).toString();
                switch (selectedCountry) {
                    case "India":
                        stateSpinner.setAdapter(IndiaStatesArrayAdapter);
                        break;
                    case "USA":
                        stateSpinner.setAdapter(usaStatesArrayAdapter);
                        break;
                    case "Canada":
                        stateSpinner.setAdapter(canadaStatesArrayAdapter);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}