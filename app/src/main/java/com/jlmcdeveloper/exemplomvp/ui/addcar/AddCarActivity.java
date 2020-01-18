package com.jlmcdeveloper.exemplomvp.ui.addcar;

import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;

import com.jlmcdeveloper.exemplomvp.AndroidApplication;
import com.jlmcdeveloper.exemplomvp.R;
import com.jlmcdeveloper.exemplomvp.data.db.CarsDAO;
import com.jlmcdeveloper.exemplomvp.data.db.model.Car;

import javax.inject.Inject;

public class AddCarActivity extends AppCompatActivity {

    @Inject
    CarsDAO carsDAO;

    private AppCompatEditText editTextName;
    private AppCompatEditText editTextYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AndroidApplication.getComponent().inject(this);

        editTextName = findViewById(R.id.ed_name);
        editTextYear = findViewById(R.id.ed_year);
    }


    public void btnSaveCar(View view) {
        carsDAO.open();
        String name = editTextName.getEditableText().toString();
        int year = Integer.decode(editTextYear.getEditableText().toString());
        carsDAO.create(new Car(name, year));
        carsDAO.close();
        finish();
    }


    public void btnCancel(View view) {
        finish();
    }
}
