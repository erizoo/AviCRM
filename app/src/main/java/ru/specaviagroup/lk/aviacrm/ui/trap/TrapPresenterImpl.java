package ru.specaviagroup.lk.aviacrm.ui.trap;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import ru.specaviagroup.lk.aviacrm.data.RepositoryManager;
import ru.specaviagroup.lk.aviacrm.ui.base.BasePresenter;
import ru.specaviagroup.lk.aviacrm.ui.main.MainMvpView;
import ru.specaviagroup.lk.aviacrm.ui.main.MainPresenter;

public class TrapPresenterImpl <V extends TrapMvpView> extends BasePresenter<V>
        implements TrapPresenter<V> {

    @Inject
    public TrapPresenterImpl(RepositoryManager repositoryManager, CompositeDisposable compositeDisposable) {
        super(repositoryManager, compositeDisposable);
    }

    @Override
    public void getTrapInfo(String id) {
        getCompositeDisposable().add(
                getRepositoryManager().getServiceNetwork().getTrapInfo(getRepositoryManager().getServicePrefs().getUserToken(), id)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                getMvpView()::getData,
                                getMvpView()::error
                        )
        );
    }
}
