package ru.specaviagroup.lk.aviacrm.di.component;

import dagger.Component;
import ru.specaviagroup.lk.aviacrm.di.PerScreen;
import ru.specaviagroup.lk.aviacrm.di.module.ScreenModule;
import ru.specaviagroup.lk.aviacrm.ui.login.LoginActivity;
import ru.specaviagroup.lk.aviacrm.ui.login.SplashActivity;
import ru.specaviagroup.lk.aviacrm.ui.main.MainActivity;
import ru.specaviagroup.lk.aviacrm.ui.trap.TrapActivity;

@PerScreen
@Component(modules = ScreenModule.class, dependencies = ApplicationComponent.class)
public interface ScreenComponent {

    void inject(LoginActivity activity);

    void inject(SplashActivity activity);

    void inject(MainActivity activity);

    void inject(TrapActivity trapActivity);
}
