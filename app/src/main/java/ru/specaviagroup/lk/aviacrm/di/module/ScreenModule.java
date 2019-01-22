package ru.specaviagroup.lk.aviacrm.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;


import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import ru.specaviagroup.lk.aviacrm.di.ActivityContext;
import ru.specaviagroup.lk.aviacrm.di.PerScreen;
import ru.specaviagroup.lk.aviacrm.ui.login.LoginMvpView;
import ru.specaviagroup.lk.aviacrm.ui.login.LoginPresenter;
import ru.specaviagroup.lk.aviacrm.ui.login.LoginPresenterImpl;
import ru.specaviagroup.lk.aviacrm.ui.login.SplashMvpView;
import ru.specaviagroup.lk.aviacrm.ui.login.SplashPresenter;
import ru.specaviagroup.lk.aviacrm.ui.login.SplashPresenterImpl;
import ru.specaviagroup.lk.aviacrm.ui.main.MainMvpView;
import ru.specaviagroup.lk.aviacrm.ui.main.MainPresenter;
import ru.specaviagroup.lk.aviacrm.ui.main.MainPresenterImpl;
import ru.specaviagroup.lk.aviacrm.ui.profile.ProfileMvpView;
import ru.specaviagroup.lk.aviacrm.ui.profile.ProfilePresenter;
import ru.specaviagroup.lk.aviacrm.ui.profile.ProfilePresenterImpl;
import ru.specaviagroup.lk.aviacrm.ui.trap.TrapMvpView;
import ru.specaviagroup.lk.aviacrm.ui.trap.TrapPresenter;
import ru.specaviagroup.lk.aviacrm.ui.trap.TrapPresenterImpl;

@Module
public class ScreenModule {

    private final AppCompatActivity activity;

    public ScreenModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return activity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return activity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @PerScreen
    LoginPresenter<LoginMvpView> provideLoginPresenter(LoginPresenterImpl<LoginMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerScreen
    SplashPresenter<SplashMvpView> provideSplashPresenter(SplashPresenterImpl<SplashMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerScreen
    MainPresenter<MainMvpView> provideMainPresenter(MainPresenterImpl<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerScreen
    TrapPresenter<TrapMvpView> provideTrapPresenter(TrapPresenterImpl<TrapMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerScreen
    ProfilePresenter<ProfileMvpView> provideProfilePresenter(ProfilePresenterImpl<ProfileMvpView> presenter) {
        return presenter;
    }
}
