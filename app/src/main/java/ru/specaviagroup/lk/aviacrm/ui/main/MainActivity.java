package ru.specaviagroup.lk.aviacrm.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;

import ru.specaviagroup.lk.aviacrm.R;
import ru.specaviagroup.lk.aviacrm.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentView() {
        return R.layout.main_activity;
    }
}
