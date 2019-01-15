package ru.specaviagroup.lk.aviacrm.di.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.specaviagroup.lk.aviacrm.App;
import ru.specaviagroup.lk.aviacrm.data.ServicePrefs;
import ru.specaviagroup.lk.aviacrm.data.ServicePrefsImpl;
import ru.specaviagroup.lk.aviacrm.data.RepositoryManager;
import ru.specaviagroup.lk.aviacrm.data.RepositoryManagerImpl;
import ru.specaviagroup.lk.aviacrm.di.ApplicationContext;

@Module
public class ApplicationModule {

    private final App application;

    public ApplicationModule(App application) {
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    @Provides
    App provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    RepositoryManager provideRepositoryManager(RepositoryManagerImpl repositoryManager) {
        return repositoryManager;
    }

    @Provides
    @Singleton
    ServicePrefs provideServicePrefs(ServicePrefsImpl servicePrefs) {
        return servicePrefs;
    }

}

