package com.jlmcdeveloper.exemplomvp.ui.listcar;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jlmcdeveloper.exemplomvp.R;
import com.jlmcdeveloper.exemplomvp.ui.base.BaseActivity;

import javax.inject.Inject;


public class ListCarActivity extends BaseActivity implements ListCarMvpView{

    @Inject
    ListCarMvpPresenter<ListCarMvpView> presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_car);
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        getActivityComponent().inject(this);
        presenter.onAttach(this);

        RecyclerView recyclerView = findViewById(R.id.rc_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CarAdapter adapter = new CarAdapter(presenter.getAllCars());
        recyclerView.setAdapter(adapter);
    }
}
