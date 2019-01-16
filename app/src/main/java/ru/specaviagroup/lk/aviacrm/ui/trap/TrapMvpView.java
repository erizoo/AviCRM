package ru.specaviagroup.lk.aviacrm.ui.trap;

import ru.specaviagroup.lk.aviacrm.data.models.ResponseTrap;
import ru.specaviagroup.lk.aviacrm.ui.base.MvpView;

public interface TrapMvpView extends MvpView {
    
    void getData(ResponseTrap responseTrap);

    void error(Throwable throwable);
}
