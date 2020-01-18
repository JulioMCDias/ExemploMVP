package com.jlmcdeveloper.exemplomvp.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jlmcdeveloper.exemplomvp.R;
import com.jlmcdeveloper.exemplomvp.ui.addcar.AddCarActivity;
import com.jlmcdeveloper.exemplomvp.ui.listcar.ListCarActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnAddCar(View view){
        startActivity(new Intent(this, AddCarActivity.class));
    }

    public void btnListCar(View view){
        startActivity(new Intent(this, ListCarActivity.class));
    }
}
