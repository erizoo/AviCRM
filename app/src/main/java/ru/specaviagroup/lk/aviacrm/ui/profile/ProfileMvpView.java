package ru.specaviagroup.lk.aviacrm.ui.profile;

import java.util.List;

import ru.specaviagroup.lk.aviacrm.data.ResponseModel.ResponsePoint;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseHandBook;
import ru.specaviagroup.lk.aviacrm.ui.base.MvpView;

public interface ProfileMvpView extends MvpView {

    void getData(List<String> responseView);

    void error(Throwable throwable);

    void getPoint(List<ResponsePoint> responsePoint);

    void saveFlyActive(boolean responseSaveFlyActiveResponse);

    void errorSave();

    void getPreparation(List<ResponseHandBook> responseHandBook);

    void getObjects(List<ResponseHandBook> responseHandBooks);
}
