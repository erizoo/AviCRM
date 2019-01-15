package ru.specaviagroup.lk.aviacrm.data;


import ru.specaviagroup.lk.aviacrm.data.network.ServiceNetwork;

public interface RepositoryManager {

    ServiceNetwork getServiceNetwork();

    ServicePrefs getServicePrefs();

    void setToken(String token);
}
