package ru.specaviagroup.lk.aviacrm.data.network;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import retrofit2.Response;
import ru.specaviagroup.lk.aviacrm.data.ResponseModel.ResponsePoint;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseAction;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseFacility;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseInfo;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseHandBook;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseSaveFlyActive;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseTrap;
import ru.specaviagroup.lk.aviacrm.data.request.RequestFlyActive;

public interface ServiceNetwork {

    Observable<Response<ResponseInfo>> login(String login, String password);

    Observable<Response<Void>> checkToken(String userToken);

    Observable<Response<List<ResponseFacility>>> getFacility(String userToken);

    Observable<ResponseTrap> getTrapInfo(String userToken, String id);

    Observable<List<String>> getView(String userToken, Integer objectId);

    Observable<List<ResponsePoint>> getPoints(String userToken, Integer objectId);

    Observable<Response<ResponseSaveFlyActive>> saveFlyActive(String userToken, RequestFlyActive requestFlyActive, int objectId);

    Observable<List<ResponseHandBook>> getPreparation(String userToken, int id);

    Observable<List<ResponseHandBook>> getObjects(String userToken, int id);

    Observable<List<ResponseHandBook>> getActions(String userToken);

    Observable<List<ResponseHandBook>> getAllPets(String userToken);
}
