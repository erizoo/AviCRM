package ru.specaviagroup.lk.aviacrm.data;

import javax.inject.Inject;

import ru.specaviagroup.lk.aviacrm.data.network.ServiceNetwork;

public class RepositoryManagerImpl implements RepositoryManager {

    private ServiceNetwork serviceNetwork;
    private ServicePrefs servicePrefs;

    @Inject
    RepositoryManagerImpl(ServiceNetwork serviceNetwork, ServicePrefs servicePrefs) {
        this.serviceNetwork = serviceNetwork;
        this.servicePrefs = servicePrefs;
    }

    @Override
    public ServiceNetwork getServiceNetwork() {
        return serviceNetwork;
    }

    @Override
    public ServicePrefs getServicePrefs() {
        return servicePrefs;
    }

    @Override
    public void setToken(String token) {
        servicePrefs.saveToken(token);
    }
}
