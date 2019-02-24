package ru.specaviagroup.lk.aviacrm.data.network;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import retrofit2.Response;
import ru.specaviagroup.lk.aviacrm.data.ResponseModel.ResponsePoint;
import ru.specaviagroup.lk.aviacrm.data.models.CheckToken;
import ru.specaviagroup.lk.aviacrm.data.models.RequestAll;
import ru.specaviagroup.lk.aviacrm.data.models.RequestLogin;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseAction;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseFacility;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseInfo;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseHandBook;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseSaveFlyActive;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseTrap;
import ru.specaviagroup.lk.aviacrm.data.request.RequestFlyActive;

public class ServiceNetworkImp implements ServiceNetwork {

    private static final String TAG = ServiceNetworkImp.class.getSimpleName();
    private static final String ACCEPT_HEADER = "application/json";
    private static final String EXPAND_OBJECT = "object";
    private static final String EXPAND_TYPE= "type,box";
    private static final String CONTENT_TYPE= "application/json; charset=UTF-8";

    private ApiMethods apiMethods;

    @Inject
    public ServiceNetworkImp(ApiMethods apiMethods) {
        this.apiMethods = apiMethods;
    }


    @Override
    public Observable<Response<ResponseInfo>> login(String login, String password) {
        RequestLogin requestLogin = new RequestLogin();
        requestLogin.setLogin(login);
        requestLogin.setPassword(password);
        requestLogin.setClientId("testclient");
        requestLogin.setClientSecret("testpass");
        requestLogin.setType("password");
        return apiMethods.login(ACCEPT_HEADER, requestLogin);
    }

    @Override
    public Observable<Response<Void>> checkToken(String userToken) {
        CheckToken checkToken = new CheckToken();
        try {
            checkToken.setToken(userToken.replaceAll("Bearer ", ""));
        } catch (Exception e){
            checkToken.setToken("");
        }
        return apiMethods.checkToken(ACCEPT_HEADER, checkToken);
    }

    @Override
    public Observable<Response<List<ResponseFacility>>> getFacility(String userToken) {
        return apiMethods.getFacility(userToken, EXPAND_OBJECT);
    }

    @Override
    public Observable<ResponseTrap> getTrapInfo(String userToken, String id) {
        return apiMethods.getTrapInfo(userToken, ACCEPT_HEADER, CONTENT_TYPE, id, EXPAND_TYPE);
    }

    @Override
    public Observable<List<String>> getView(String userToken, Integer objectId) {
        return apiMethods.getView(userToken, objectId);
    }

    @Override
    public Observable<List<ResponsePoint>> getPoints(String userToken, Integer objectId) {
        return apiMethods.getPoints(userToken, objectId);
    }

    @Override
    public Observable<Response<ResponseSaveFlyActive>> saveFlyActive(String userToken, RequestFlyActive requestFlyActive, int objectId) {
        return apiMethods.saveFlyActive(userToken, requestFlyActive, objectId);
    }

    @Override
    public Observable<List<ResponseHandBook>> getPreparation(String userToken, int id) {
        return apiMethods.getPreparation(userToken, id);
    }

    @Override
    public Observable<List<ResponseHandBook>> getObjects(String userToken, int id) {
        return apiMethods.getObjects(userToken, id);
    }

    @Override
    public Observable<List<ResponseHandBook>> getActions(String userToken) {
        return apiMethods.getActions(userToken);
    }

    @Override
    public Observable<List<ResponseHandBook>> getAllPets(String userToken) {
        return apiMethods.getAllPets(userToken);
    }

    @Override
    public Observable<List<ResponseHandBook>> getAreas(String userToken, int id) {
        return apiMethods.getAreas(userToken, id);
    }

    @Override
    public Observable<Response<ResponseSaveFlyActive>> saveAll(String userToken, RequestAll requestAll, int id) {
        return apiMethods.saveAll(userToken, requestAll, id);
    }
}
