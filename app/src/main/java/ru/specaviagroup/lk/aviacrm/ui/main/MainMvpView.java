package ru.specaviagroup.lk.aviacrm.ui.main;

import java.util.List;

import ru.specaviagroup.lk.aviacrm.data.models.ResponseFacility;
import ru.specaviagroup.lk.aviacrm.ui.base.MvpView;

public interface MainMvpView extends MvpView {

    void getData(List<ResponseFacility> responseFacilities);

    void error();
}
