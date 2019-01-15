package ru.specaviagroup.lk.aviacrm.ui.login;

import java.util.Objects;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import ru.specaviagroup.lk.aviacrm.data.RepositoryManager;
import ru.specaviagroup.lk.aviacrm.ui.base.BasePresenter;

public class LoginPresenterImpl<V extends LoginMvpView> extends BasePresenter<V>
        implements LoginPresenter<V> {

    @Inject
    public LoginPresenterImpl(RepositoryManager repositoryManager, CompositeDisposable compositeDisposable) {
        super(repositoryManager, compositeDisposable);
    }

    @Override
    public void login(String login, String password) {
        getCompositeDisposable().add(
                getRepositoryManager().getServiceNetwork().login(login, password)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                response -> {
                                    if (response.isSuccessful()) {
                                        getRepositoryManager().setToken("Bearer " + Objects.requireNonNull(response.body()).getToken());
                                        getMvpView().isSuccessfulLogin();
                                    } else {
                                        getMvpView().badLogin(response.message(), null);
                                    }
                                }
                        )
        );
    }

}
