package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class VolumeActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private Spinner spinnerFrom, spinnerTo;

    private TextView textViewResult;

    private Button buttonClear;

    private Button buttonSolve;


    private static final String[] paths = {"To", "Cubic Meter", "Litre", "Millilitre", "CC"};

    private static final String[] path = {"From", "Cubic Meter", "Litre", "Millilitre", "CC"};

    private EditText editTextValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);
        toolbar = findViewById(R.id.toolbar_all);

        buttonClear = findViewById(R.id.btn_clear);

        buttonSolve = findViewById(R.id.btn_solve);

        editTextValue = findViewById(R.id.edit_value);
        textViewResult = findViewById(R.id.TitleAnswer);


        spinnerTo = findViewById(R.id.simpleSpinnerTo);

        ArrayAdapter<String> to = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, paths);
        to.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinnerTo.setAdapter(to);


        spinnerFrom = findViewById(R.id.simpleSpinnerFrom);

        ArrayAdapter<String> from = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, path);
        from.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        //Setting the ArrayAdapter data on the Spinner

        spinnerFrom.setAdapter(from);


        spinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        // Whatever you want to happen when the first item gets selected
                        break;
                    case 1:
                        // Whatever you want to happen when the second item gets selected
                        break;
                    case 2:
                        // Whatever you want to happen when the thrid item gets selected
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //What to do on back clicked
                onBackPressed();
            }
        });
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setTitle("Volume");


        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editTextValue.setText("");
                textViewResult.setText("0.0");


            }
        });

        buttonSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp1 = spinnerFrom.getSelectedItem().toString();
                String temp2 = spinnerTo.getSelectedItem().toString();
                String value = editTextValue.getText().toString();

                if (temp1.equals("From") || temp2.equals("To")) {

                    Toast.makeText(getApplicationContext(), "Please choose a From and To", Toast.LENGTH_LONG).show();

                } else if (value.equals("")) {
                    editTextValue.setText("");
                    editTextValue.setError("Please enter a value to convert");
                    editTextValue.setFocusable(true);
                } else {
                    if (temp1.equals("Cubic Meter")) {
                        if (temp2.equals("Litre")) {
                            Double a;

                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 1000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Litre(s)");
                            //Toast.makeText(TemperatureActivity.this,r+"°F",Toast.LENGTH_SHORT).show();

                        } else if (temp2.equals("Millilitre")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 8.71828182846;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Millilitre(s)");


                        } else if (temp2.equals("CC")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 8.71828182846;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Cubic Centimeter(s)");


                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from Cubic Meter to Cubic Meter .Please choose a To", Toast.LENGTH_LONG).show();
                            textViewResult.setText("");

                        }

                    }
                    else if (temp1.equals("CC")) {
                        if (temp2.equals("Litre")) {
                            Double a;

                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 1000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Litre(s)");
                            //Toast.makeText(TemperatureActivity.this,r+"°F",Toast.LENGTH_SHORT).show();

                        } else if (temp2.equals("Millilitre")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 1;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Millilitre(s)");


                        } else if (temp2.equals("Cubic Meter")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 8.71828182846;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Cubic Meter(s)");


                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from Cubic Meter to Cubic Meter .Please choose a To", Toast.LENGTH_LONG).show();
                            textViewResult.setText("");

                        }

                    }

                    else if (temp1.equals("Litre")) {
                        if (temp2.equals("Cubic Meter")) {
                            Double a;

                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 3.52;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Cubic Meter(s)");
                            //Toast.makeText(TemperatureActivity.this,r+"°F",Toast.LENGTH_SHORT).show();

                        } else if (temp2.equals("Millilitre")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a *1000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Millilitre(s)");


                        } else if (temp2.equals("CC")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 1000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Cubic Centimeter(s)");


                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from Litre to Litre .Please choose a To", Toast.LENGTH_LONG).show();
                            textViewResult.setText("");

                        }

                    }

                    else if (temp1.equals("Millilitre")) {
                        if (temp2.equals("Litre")) {
                            Double a;

                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a /1000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Litre(s)");
                            //Toast.makeText(TemperatureActivity.this,r+"°F",Toast.LENGTH_SHORT).show();

                        } else if (temp2.equals("Cubic Meter")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 8.71828182846;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Cubic Meter(s)");


                        } else if (temp2.equals("CC")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 1;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Cubic Centimeter(s)");


                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from Millilitre to Millilitre .Please choose a To", Toast.LENGTH_LONG).show();
                            textViewResult.setText("");

                        }

                    }





                }

            }
        });

    }
}