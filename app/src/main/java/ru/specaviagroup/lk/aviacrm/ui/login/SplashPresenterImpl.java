package ru.specaviagroup.lk.aviacrm.ui.login;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import ru.specaviagroup.lk.aviacrm.data.RepositoryManager;
import ru.specaviagroup.lk.aviacrm.ui.base.BasePresenter;

public class SplashPresenterImpl<V extends SplashMvpView> extends BasePresenter<V>
        implements SplashPresenter<V> {

    @Inject
    public SplashPresenterImpl(RepositoryManager repositoryManager, CompositeDisposable compositeDisposable) {
        super(repositoryManager, compositeDisposable);
    }

    @Override
    public void checkToken() {
        getCompositeDisposable().add(
                getRepositoryManager().getServiceNetwork().checkToken(getRepositoryManager().getServicePrefs().getUserToken())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                response -> {
                                    if (response.isSuccessful()) {
                                        getMvpView().isSuccessfulToken();
                                    } else {
                                        getMvpView().badToken(response.message(), null);
                                    }
                                }
                        )
        );

    }
}
