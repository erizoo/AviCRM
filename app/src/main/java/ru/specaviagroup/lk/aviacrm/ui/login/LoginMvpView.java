package ru.specaviagroup.lk.aviacrm.ui.login;

import ru.specaviagroup.lk.aviacrm.ui.base.MvpView;

public interface LoginMvpView extends MvpView {

    void badLogin(String message, Object o);

    void isSuccessfulLogin();
}
