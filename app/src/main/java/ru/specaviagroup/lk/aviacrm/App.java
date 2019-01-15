package ru.specaviagroup.lk.aviacrm;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.ContextWrapper;

import com.pixplicity.easyprefs.library.Prefs;

import java.security.GeneralSecurityException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import ru.specaviagroup.lk.aviacrm.di.component.ApplicationComponent;
import ru.specaviagroup.lk.aviacrm.di.component.DaggerApplicationComponent;
import ru.specaviagroup.lk.aviacrm.di.module.ApplicationModule;

public class App extends Application {

    private ApplicationComponent applicationComponent;

    public static App instance;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
        instance = this;

        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();

    }

    public static App getInstance() {
        return instance;
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
