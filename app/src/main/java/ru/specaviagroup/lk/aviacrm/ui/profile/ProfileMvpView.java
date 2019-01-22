package ru.specaviagroup.lk.aviacrm.ui.profile;

import java.util.List;

import ru.specaviagroup.lk.aviacrm.data.models.ResponseView;
import ru.specaviagroup.lk.aviacrm.ui.base.MvpView;

public interface ProfileMvpView extends MvpView {

    void getData(List<String> responseView);

    void error(Throwable throwable);
}
