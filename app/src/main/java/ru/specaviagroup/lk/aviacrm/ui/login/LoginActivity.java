package ru.specaviagroup.lk.aviacrm.ui.login;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.specaviagroup.lk.aviacrm.R;
import ru.specaviagroup.lk.aviacrm.ui.base.BaseActivity;
import ru.specaviagroup.lk.aviacrm.ui.main.MainActivity;

public class LoginActivity extends BaseActivity implements LoginMvpView{

    @BindView(R.id.login)
    EditText login;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.progress)
    ProgressBar progressBar;
    @BindView(R.id.enter_button)
    Button buttonLogin;

    @Inject
    LoginPresenter<LoginMvpView> presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        getScreenComponent().inject(this);
        presenter.onAttach(this);
    }

    @Override
    protected int getContentView() {
        return R.layout.login_activity;
    }

    @OnClick(R.id.enter_button)
    public void login(){
        progressBar.setVisibility(View.VISIBLE);
        buttonLogin.setText("");
        if (login.getText().toString().equals("")){
            Snackbar.make(password, "Введите логин", Snackbar.LENGTH_LONG).show();
        } else if(password.getText().toString().equals("")){
            Snackbar.make(password, "Введите пароль", Snackbar.LENGTH_LONG).show();
        } else {
            presenter.login(login.getText().toString(), password.getText().toString());
        }
    }

    @Override
    public void badLogin(String message, Object o) {
        progressBar.setVisibility(View.GONE);
        buttonLogin.setText("ВОЙТИ");
        Snackbar.make(password, "Ошибка авторизации, попробуйте снова", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void isSuccessfulLogin() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
