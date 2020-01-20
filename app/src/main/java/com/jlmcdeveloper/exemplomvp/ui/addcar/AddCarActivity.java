package com.jlmcdeveloper.exemplomvp.ui.addcar;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;

import com.jlmcdeveloper.exemplomvp.R;
import com.jlmcdeveloper.exemplomvp.ui.base.BaseActivity;

import javax.inject.Inject;

public class AddCarActivity extends BaseActivity implements AddCarMvpView{

   @Inject
   AddCarMvpPresenter<AddCarMvpView> presenter;

    private AppCompatEditText editTextName;
    private AppCompatEditText editTextYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getActivityComponent().inject(this);
        presenter.onAttach(this);

        editTextName = findViewById(R.id.ed_name);
        editTextYear = findViewById(R.id.ed_year);
    }


    public void btnSaveCar(View view) {
        String name = editTextName.getEditableText().toString();
        int year = Integer.decode(editTextYear.getEditableText().toString());

        presenter.insertCar(name, year);
    }


    public void btnCancel(View view) {
        finish();
    }

    @Override
    public void closeActivity() {
        finish();
    }
}
