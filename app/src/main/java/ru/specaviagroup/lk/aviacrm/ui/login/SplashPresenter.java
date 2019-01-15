package ru.specaviagroup.lk.aviacrm.ui.login;

import ru.specaviagroup.lk.aviacrm.ui.base.MvpPresenter;

public interface SplashPresenter <V extends SplashMvpView> extends MvpPresenter<V> {

    void checkToken();

}
