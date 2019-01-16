package ru.specaviagroup.lk.aviacrm.ui.trap;

import ru.specaviagroup.lk.aviacrm.ui.base.MvpPresenter;
import ru.specaviagroup.lk.aviacrm.ui.main.MainMvpView;

public interface TrapPresenter <V extends TrapMvpView> extends MvpPresenter<V> {

    void getTrapInfo(String id);

}
