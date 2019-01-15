package ru.specaviagroup.lk.aviacrm.data.network;

import java.util.concurrent.ExecutorCompletionService;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Response;
import ru.specaviagroup.lk.aviacrm.data.models.CheckToken;
import ru.specaviagroup.lk.aviacrm.data.models.RequestLogin;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseInfo;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseToken;

public class ServiceNetworkImp implements ServiceNetwork {

    private static final String TAG = ServiceNetworkImp.class.getSimpleName();
    private static final String ACCEPT_HEADER = "application/json";

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
    public Observable<Response<ResponseToken>> checkToken(String userToken) {
        CheckToken checkToken = new CheckToken();
        try {
            checkToken.setToken(userToken.replaceAll("Bearer ", ""));
        } catch (Exception e){
            checkToken.setToken("");
        }
        return apiMethods.checkToken(ACCEPT_HEADER, checkToken);
    }
}
