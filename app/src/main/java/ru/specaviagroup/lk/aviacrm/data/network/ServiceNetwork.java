package ru.specaviagroup.lk.aviacrm.data.network;

import io.reactivex.Observable;
import retrofit2.Response;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseInfo;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseToken;

public interface ServiceNetwork {

    Observable<Response<ResponseInfo>> login(String login, String password);

    Observable<Response<Void>> checkToken(String userToken);
}
