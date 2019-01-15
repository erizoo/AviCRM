package ru.specaviagroup.lk.aviacrm.di.component;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import ru.specaviagroup.lk.aviacrm.App;
import ru.specaviagroup.lk.aviacrm.data.RepositoryManager;
import ru.specaviagroup.lk.aviacrm.di.ApplicationContext;
import ru.specaviagroup.lk.aviacrm.di.module.ApiModule;
import ru.specaviagroup.lk.aviacrm.di.module.ApplicationModule;

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {

    void inject(App application);

    @ApplicationContext
    Context context();

    RepositoryManager getRepositoryManager();

}

