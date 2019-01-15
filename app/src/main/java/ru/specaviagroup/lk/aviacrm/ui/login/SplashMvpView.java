package ru.specaviagroup.lk.aviacrm.ui.login;

import ru.specaviagroup.lk.aviacrm.ui.base.MvpView;

public interface SplashMvpView extends MvpView {

    void isSuccessfulToken();

    void badToken(String message, Object o);
}
