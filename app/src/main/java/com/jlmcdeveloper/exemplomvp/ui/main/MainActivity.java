package com.jlmcdeveloper.exemplomvp.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jlmcdeveloper.exemplomvp.R;
import com.jlmcdeveloper.exemplomvp.ui.addcar.AddCarActivity;
import com.jlmcdeveloper.exemplomvp.ui.base.BaseActivity;
import com.jlmcdeveloper.exemplomvp.ui.listcar.ListCarActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject
    MainMvpPresenter<MainMvpView> presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(MainActivity.this);

        presenter.onAttach(MainActivity.this);
    }


    @Override
    protected void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }


    public void btnAddCar(View view){
        presenter.btnAddCar();
    }

    public void btnListCar(View view){
       presenter.btnListCar();
    }


    @Override
    public void openListCarActivity() {
        startActivity(new Intent(this, ListCarActivity.class));
    }

    @Override
    public void openAddCarActivity() {
        startActivity(new Intent(this, AddCarActivity.class));
    }
}
