package ru.specaviagroup.lk.aviacrm.ui.main;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import ru.specaviagroup.lk.aviacrm.data.RepositoryManager;
import ru.specaviagroup.lk.aviacrm.ui.base.BasePresenter;

public class MainPresenterImpl<V extends MainMvpView> extends BasePresenter<V>
        implements MainPresenter<V> {

    @Inject
    public MainPresenterImpl(RepositoryManager repositoryManager, CompositeDisposable compositeDisposable) {
        super(repositoryManager, compositeDisposable);
    }

    @Override
    public void getFacility() {
        getCompositeDisposable().add(
                getRepositoryManager().getServiceNetwork().getFacility(getRepositoryManager().getServicePrefs().getUserToken())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                getMvpView()::getData,
                                getMvpView()::error
                        )
        );
    }
}
