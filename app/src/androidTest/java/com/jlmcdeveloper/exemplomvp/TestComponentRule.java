package com.jlmcdeveloper.exemplomvp;

import android.content.Context;

import com.jlmcdeveloper.exemplomvp.contract.TestComponent;
import com.jlmcdeveloper.exemplomvp.contract.DaggerTestComponent;
import com.jlmcdeveloper.exemplomvp.data.DataManager;
import com.jlmcdeveloper.exemplomvp.module.ApplicationTestModule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class TestComponentRule implements TestRule {

    Context context;
    TestComponent testComponent;


    public TestComponentRule(Context context){
        this.context=context;
    }

    public Context getContext() {
        return context;
    }

    public TestComponent getTestComponent() {
        return testComponent;
    }



    private void setupDaggerTestComponentInApplication() {
        AndroidApplication application = ((AndroidApplication) context.getApplicationContext());
        testComponent = DaggerTestComponent.builder()
                .applicationTestModule(new ApplicationTestModule(application))
                .build();
        application.setComponent(testComponent);
    }


    @Override
    public Statement apply(final Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    setupDaggerTestComponentInApplication();
                    base.evaluate();
                }finally {
                    testComponent =null;
                }
            }
        };
    }
}
