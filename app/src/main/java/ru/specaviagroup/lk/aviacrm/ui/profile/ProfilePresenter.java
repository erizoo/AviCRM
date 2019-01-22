package ru.specaviagroup.lk.aviacrm.ui.profile;

import ru.specaviagroup.lk.aviacrm.ui.base.MvpPresenter;

public interface ProfilePresenter <V extends ProfileMvpView> extends MvpPresenter<V> {

    void getView(Integer objectId);

}
