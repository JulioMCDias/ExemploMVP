package com.jlmcdeveloper.exemplomvp.ui.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.jlmcdeveloper.exemplomvp.AndroidApplication;
import com.jlmcdeveloper.exemplomvp.contract.ActivityComponent;
import com.jlmcdeveloper.exemplomvp.contract.DaggerActivityComponent;
import com.jlmcdeveloper.exemplomvp.module.ActivityModule;

public abstract class BaseActivity extends AppCompatActivity implements MvpView{

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(((AndroidApplication) getApplication()).getComponent())
                .activityModule(new ActivityModule(this))
                .build();

    }


    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

}
