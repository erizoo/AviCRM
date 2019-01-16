package ru.specaviagroup.lk.aviacrm.ui.main;

import ru.specaviagroup.lk.aviacrm.ui.base.MvpPresenter;

public interface MainPresenter <V extends MainMvpView> extends MvpPresenter<V> {

    void getFacility();

}
