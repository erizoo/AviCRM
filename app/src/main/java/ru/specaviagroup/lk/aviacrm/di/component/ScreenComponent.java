package ru.specaviagroup.lk.aviacrm.di.component;

import dagger.Component;
import ru.specaviagroup.lk.aviacrm.di.PerScreen;
import ru.specaviagroup.lk.aviacrm.di.module.ScreenModule;
import ru.specaviagroup.lk.aviacrm.ui.login.LoginActivity;
import ru.specaviagroup.lk.aviacrm.ui.login.SplashActivity;

@PerScreen
@Component(modules = ScreenModule.class, dependencies = ApplicationComponent.class)
public interface ScreenComponent {

    void inject(LoginActivity loginActivity);

    void inject(SplashActivity splashActivity);
}
