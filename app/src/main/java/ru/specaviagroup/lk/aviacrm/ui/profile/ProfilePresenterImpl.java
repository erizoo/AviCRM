package ru.specaviagroup.lk.aviacrm.ui.profile;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import ru.specaviagroup.lk.aviacrm.data.RepositoryManager;
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
                getRepositoryManager().getServiceNetwork().getView("Bearer d81d02ac16bc6e3d9ba964443d47d284686bccbc", objectId)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                getMvpView()::getData,
                                getMvpView()::error
                        )
        );
    }
}
