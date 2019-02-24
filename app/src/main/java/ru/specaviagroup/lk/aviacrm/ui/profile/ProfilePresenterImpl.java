package ru.specaviagroup.lk.aviacrm.ui.profile;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import ru.specaviagroup.lk.aviacrm.data.RepositoryManager;
import ru.specaviagroup.lk.aviacrm.data.models.RequestAll;
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
                getRepositoryManager().getServiceNetwork().getView("Bearer e5b11409f80a4dfa7fe17e56519ce6bde6709339", objectId)
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
                getRepositoryManager().getServiceNetwork().getPoints("Bearer e5b11409f80a4dfa7fe17e56519ce6bde6709339", objectId)
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
                getRepositoryManager().getServiceNetwork().saveFlyActive("Bearer e5b11409f80a4dfa7fe17e56519ce6bde6709339",
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
                getRepositoryManager().getServiceNetwork().getPreparation("Bearer e5b11409f80a4dfa7fe17e56519ce6bde6709339", id)
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
                getRepositoryManager().getServiceNetwork().getObjects("Bearer e5b11409f80a4dfa7fe17e56519ce6bde6709339", id)
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
                getRepositoryManager().getServiceNetwork().getObjects("Bearer e5b11409f80a4dfa7fe17e56519ce6bde6709339", id)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                getMvpView()::getObjectsCatching,
                                getMvpView()::error
                        )

        );
    }

    @Override
    public void getActions() {
        getCompositeDisposable().add(
                getRepositoryManager().getServiceNetwork().getActions("Bearer e5b11409f80a4dfa7fe17e56519ce6bde6709339")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                getMvpView()::getActions,
                                getMvpView()::error
                        )

        );
    }

    @Override
    public void getAllPets() {
        getCompositeDisposable().add(
                getRepositoryManager().getServiceNetwork().getAllPets("Bearer e5b11409f80a4dfa7fe17e56519ce6bde6709339")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                getMvpView()::getAllPets,
                                getMvpView()::error
                        )

        );
    }

    @Override
    public void getPreparationForAdditiional(int id) {
        getCompositeDisposable().add(
                getRepositoryManager().getServiceNetwork().getPreparation("Bearer e5b11409f80a4dfa7fe17e56519ce6bde6709339", id)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                getMvpView()::getPreparationForAdditiional,
                                getMvpView()::error
                        )

        );
    }

    @Override
    public void getAreas(int id) {
        getCompositeDisposable().add(
                getRepositoryManager().getServiceNetwork().getAreas("Bearer e5b11409f80a4dfa7fe17e56519ce6bde6709339", id)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                getMvpView()::getAreas,
                                getMvpView()::error
                        )

        );
    }

    @Override
    public void saveAll(RequestAll requestAll, int id) {
        getCompositeDisposable().add(
                getRepositoryManager().getServiceNetwork().saveAll("Bearer e5b11409f80a4dfa7fe17e56519ce6bde6709339", requestAll, id)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                getMvpView()::getSavedAll,
                                getMvpView()::error
                        )

        );
    }
}
