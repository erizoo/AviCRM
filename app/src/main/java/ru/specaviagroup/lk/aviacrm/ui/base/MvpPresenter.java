package ru.specaviagroup.lk.aviacrm.ui.base;

import io.reactivex.disposables.CompositeDisposable;
import ru.specaviagroup.lk.aviacrm.data.RepositoryManager;

public interface MvpPresenter<V> {

    void onAttach(V mvpView);

    void onDetach();

    void onDestroy();

    CompositeDisposable getCompositeDisposable();

    V getMvpView();

    RepositoryManager getRepositoryManager();

}
