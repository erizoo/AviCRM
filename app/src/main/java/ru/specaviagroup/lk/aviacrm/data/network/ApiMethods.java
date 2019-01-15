package ru.specaviagroup.lk.aviacrm.data.network;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import ru.specaviagroup.lk.aviacrm.data.ResponseModel.ResponseScan;
import ru.specaviagroup.lk.aviacrm.data.models.CheckToken;
import ru.specaviagroup.lk.aviacrm.data.models.RequestLogin;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseInfo;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseToken;

public interface ApiMethods {

    @POST("oauth2/token")
    Observable<Response<ResponseInfo>> login(@Header ("Accept") String acceptHeader ,
                                             @Body RequestLogin requestLogin);

    @POST("token")
    Observable<Response<ResponseToken>> checkToken(@Header ("Accept") String acceptHeader ,
                                                   @Body CheckToken checkToken);

}
