package com.example.arafat_213.mcwclabpracticals;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;

public class Practical4 extends AppCompatActivity {

    private AutoCompleteTextView actCountry;
    private Spinner stateSpinner;
    private EditText etName, etAge, etDOB, etEmail, etPhone;
    private Button btnSubmit;
    private CheckBox cbCoding, cbSinging, cbGaming;
    private RadioGroup rgGender;
    private Switch married;
    private String countries[] = {"India", "USA", "Canada", "Indonesia"};
    private String indiaStates[] = {"Gujarat", "Maharashtra", "Goa"};
    private String usaStates[] = {"New York", "Florida", "California"};
    private String canadaStates[] = {"Ontario"};
    private String selectedState;
    private String selectedCountry;
    private RadioButton selectedGender;
    private String selectedHobbies = " ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical4);

        etName = findViewById(R.id.etName);
        etDOB = findViewById(R.id.etDOB);
        etAge = findViewById(R.id.etAge);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        actCountry = findViewById(R.id.actCountry);
        stateSpinner = findViewById(R.id.stateSpinner);
        btnSubmit = findViewById(R.id.btnSubmit);
        cbCoding = findViewById(R.id.cbCoding);
        cbSinging = findViewById(R.id.cbSinging);
        cbGaming = findViewById(R.id.cbGaming);
        rgGender = findViewById(R.id.rgGender);
        married = findViewById(R.id.married);

        ArrayAdapter<String> countriesArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, countries);
        final ArrayAdapter<String> IndiaStatesArrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, indiaStates);
        final ArrayAdapter<String> usaStatesArrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, usaStates);
        final ArrayAdapter<String> canadaStatesArrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, canadaStates);

        actCountry.setAdapter(countriesArrayAdapter);
        actCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedCountry = adapterView.getItemAtPosition(i).toString();
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

        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedState = adapterView.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                selectedState = "Undefined";
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Practical4.this, Practical4Display.class);
                intent.putExtra("Name", etName.getText().toString());
                intent.putExtra("DOB", etDOB.getText().toString());
                intent.putExtra("Age", etAge.getText().toString());
                intent.putExtra("Phone", etPhone.getText().toString());
                intent.putExtra("Email", etEmail.getText().toString());
                intent.putExtra("State", selectedState);
                intent.putExtra("Country", selectedCountry);
                selectedGender = findViewById(rgGender.getCheckedRadioButtonId());
                intent.putExtra("Gender", selectedGender.getText().toString());
                if (cbCoding.isChecked())
                    selectedHobbies += cbCoding.getText().toString() + " ";
                if (cbGaming.isChecked())
                    selectedHobbies += cbGaming.getText().toString() + " ";
                if (cbSinging.isChecked())
                    selectedHobbies += cbSinging.getText().toString();
                intent.putExtra("Hobbies", selectedHobbies);
                if (married.isChecked())
                    intent.putExtra("Married", "Yes");
                else
                    intent.putExtra("Married", "No");
                if (intent != null)
                    startActivity(intent);
            }
        });
    }
}