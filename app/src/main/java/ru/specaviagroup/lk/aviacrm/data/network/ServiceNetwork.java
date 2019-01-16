package ru.specaviagroup.lk.aviacrm.data.network;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import retrofit2.Response;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseFacility;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseInfo;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseToken;

public interface ServiceNetwork {

    Observable<Response<ResponseInfo>> login(String login, String password);

    Observable<Response<Void>> checkToken(String userToken);

    Observable<List<ResponseFacility>> getFacility(String userToken);
}
