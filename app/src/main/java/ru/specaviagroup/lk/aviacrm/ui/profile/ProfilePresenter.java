package ru.specaviagroup.lk.aviacrm.ui.profile;

import ru.specaviagroup.lk.aviacrm.data.request.RequestFlyActive;
import ru.specaviagroup.lk.aviacrm.ui.base.MvpPresenter;

public interface ProfilePresenter <V extends ProfileMvpView> extends MvpPresenter<V> {

    void getView(Integer objectId);

    void getPoints(Integer objectId);

    void saveFlyActive(RequestFlyActive requestFlyActive, int objectId);

    void getPreparation(int i);

    void getObjects(int i);

    void getObjectsCatching(int i);
}
