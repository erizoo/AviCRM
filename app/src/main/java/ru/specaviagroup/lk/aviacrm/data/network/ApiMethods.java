package ru.specaviagroup.lk.aviacrm.data.network;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import ru.specaviagroup.lk.aviacrm.data.ResponseModel.ResponseScan;
import ru.specaviagroup.lk.aviacrm.data.models.CheckToken;
import ru.specaviagroup.lk.aviacrm.data.models.RequestLogin;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseFacility;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseInfo;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseToken;

public interface ApiMethods {

    // получение токена
    @POST("oauth2/token")
    Observable<Response<ResponseInfo>> login(@Header ("Accept") String acceptHeader ,
                                             @Body RequestLogin requestLogin);

    // проверка токена
    @POST("token")
    Observable<Response<Void>> checkToken(@Header ("Accept") String acceptHeader ,
                                                   @Body CheckToken checkToken);

    // получение объектов
    @GET("revizor")
    Observable<List<ResponseFacility>> getFacility(@Header("Authorization") String userToken,
                                                   @Query("expand") String object);
}
