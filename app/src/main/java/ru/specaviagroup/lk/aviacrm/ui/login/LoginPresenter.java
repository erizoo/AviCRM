package ru.specaviagroup.lk.aviacrm.ui.login;

import ru.specaviagroup.lk.aviacrm.ui.base.MvpPresenter;

public interface LoginPresenter <V extends LoginMvpView> extends MvpPresenter<V> {

    void login(String login, String password);

}
