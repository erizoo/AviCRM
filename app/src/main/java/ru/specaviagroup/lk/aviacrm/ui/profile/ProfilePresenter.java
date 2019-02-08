package ru.specaviagroup.lk.aviacrm.ui.profile;

import ru.specaviagroup.lk.aviacrm.data.request.RequestFlyActive;
import ru.specaviagroup.lk.aviacrm.ui.base.MvpPresenter;

public interface ProfilePresenter <V extends ProfileMvpView> extends MvpPresenter<V> {

    void getView(Integer objectId);

    void getPoints(Integer objectId);

    void saveFlyActive(RequestFlyActive requestFlyActive, int objectId);

    void getPreparation(int id);

    void getObjects(int id);

    void getObjectsCatching(int id);

    void getActions();

    void getAllPets();
}
