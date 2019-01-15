package ru.specaviagroup.lk.aviacrm.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import ru.specaviagroup.lk.aviacrm.R;
import ru.specaviagroup.lk.aviacrm.ui.base.BaseActivity;
import ru.specaviagroup.lk.aviacrm.ui.main.MainActivity;

public class SplashActivity extends BaseActivity implements SplashMvpView{

    @Inject
    SplashPresenter<SplashMvpView> presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getScreenComponent().inject(this);
        presenter.onAttach(this);
        presenter.checkToken();

    }

    @Override
    protected int getContentView() {
        return R.layout.splash_activity;
    }

    @Override
    public void isSuccessfulToken() {
        Intent intent = new Intent(this, MainActivity.class);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        startActivity(intent);
        finish();
    }

    @Override
    public void badToken(String message, Object o) {
        Intent intent = new Intent(this, LoginActivity.class);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        startActivity(intent);
        finish();
    }
}
