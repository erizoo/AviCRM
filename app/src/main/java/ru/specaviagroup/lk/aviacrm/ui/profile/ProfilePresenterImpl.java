package ru.specaviagroup.lk.aviacrm.ui.profile;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import ru.specaviagroup.lk.aviacrm.data.RepositoryManager;
import ru.specaviagroup.lk.aviacrm.data.request.RequestFlyActive;
import ru.specaviagroup.lk.aviacrm.ui.base.BasePresenter;

public class ProfilePresenterImpl<V extends ProfileMvpView> extends BasePresenter<V>
        implements ProfilePresenter<V> {

    @Inject
    public ProfilePresenterImpl(RepositoryManager repositoryManager, CompositeDisposable compositeDisposable) {
        super(repositoryManager, compositeDisposable);
    }

    @Override
    public void getView(Integer objectId) {
        getCompositeDisposable().add(
                getRepositoryManager().getServiceNetwork().getView("Bearer f777424ae437909c44289af18e91a51e66564cc4", objectId)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                getMvpView()::getData,
                                getMvpView()::error
                        )
        );
    }

    @Override
    public void getPoints(Integer objectId) {
        getCompositeDisposable().add(
                getRepositoryManager().getServiceNetwork().getPoints("Bearer f777424ae437909c44289af18e91a51e66564cc4", objectId)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                getMvpView()::getPoint,
                                getMvpView()::error
                        )
        );
    }

    @Override
    public void saveFlyActive(RequestFlyActive requestFlyActive, int objectId) {
        getCompositeDisposable().add(
                getRepositoryManager().getServiceNetwork().saveFlyActive("Bearer f777424ae437909c44289af18e91a51e66564cc4",
                        requestFlyActive, objectId)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                listResponse -> {
                                    if (listResponse.isSuccessful()) {
                                        getMvpView().saveFlyActive(true);
                                    } else {
                                        getMvpView().errorSave();
                                    }
                                }
                        )
        );
    }

    @Override
    public void getPreparation(int id) {
        getCompositeDisposable().add(
                getRepositoryManager().getServiceNetwork().getPreparation("Bearer f777424ae437909c44289af18e91a51e66564cc4", id)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                getMvpView()::getPreparation,
                                getMvpView()::error
                        )

        );
    }

    @Override
    public void getObjects(int id) {
        getCompositeDisposable().add(
                getRepositoryManager().getServiceNetwork().getObjects("Bearer f777424ae437909c44289af18e91a51e66564cc4", id)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                getMvpView()::getObjects,
                                getMvpView()::error
                        )

        );
    }

    @Override
    public void getObjectsCatching(int id) {
        getCompositeDisposable().add(
                getRepositoryManager().getServiceNetwork().getObjects("Bearer f777424ae437909c44289af18e91a51e66564cc4", id)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                getMvpView()::getObjectsCatching,
                                getMvpView()::error
                        )

        );
    }
}
