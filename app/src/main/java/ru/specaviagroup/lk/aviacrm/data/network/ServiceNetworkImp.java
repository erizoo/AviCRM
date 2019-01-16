package ru.specaviagroup.lk.aviacrm.data.network;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Response;
import ru.specaviagroup.lk.aviacrm.data.models.CheckToken;
import ru.specaviagroup.lk.aviacrm.data.models.RequestLogin;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseFacility;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseInfo;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseTrap;

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
    public Observable<List<ResponseFacility>> getFacility(String userToken) {
        return apiMethods.getFacility(userToken, EXPAND_OBJECT);
    }

    @Override
    public Observable<ResponseTrap> getTrapInfo(String userToken, String id) {
        return apiMethods.getTrapInfo(userToken, ACCEPT_HEADER, CONTENT_TYPE, id, EXPAND_TYPE);
    }
}
