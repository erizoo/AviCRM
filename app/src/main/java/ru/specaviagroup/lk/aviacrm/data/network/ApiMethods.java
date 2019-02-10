package ru.specaviagroup.lk.aviacrm.data.network;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.specaviagroup.lk.aviacrm.data.ResponseModel.ResponsePoint;
import ru.specaviagroup.lk.aviacrm.data.models.CheckToken;
import ru.specaviagroup.lk.aviacrm.data.models.RequestLogin;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseFacility;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseHandBook;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseInfo;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseSaveFlyActive;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseTrap;
import ru.specaviagroup.lk.aviacrm.data.request.RequestFlyActive;

public interface ApiMethods {

    // получение токена
    @POST("oauth2/token")
    Observable<Response<ResponseInfo>> login(@Header ("Accept") String acceptHeader,
                                             @Body RequestLogin requestLogin);

    // проверка токена
    @POST("token")
    Observable<Response<Void>> checkToken(@Header("Accept") String acceptHeader,
                                                   @Body CheckToken checkToken);

    // получение объектов
    @GET("revizor")
    Observable<Response<List<ResponseFacility>>> getFacility(@Header("Authorization") String userToken,
                                                   @Query("expand") String object);

    @GET("trap/{id}")
    Observable<ResponseTrap> getTrapInfo(@Header("Authorization") String userToken,
                                         @Header("Accept") String acceptHeader,
                                         @Header("Content-Type") String contentType,
                                         @Path("id") String id,
                                         @Query(value = "expand", encoded = true) String type);

    @GET("fields/{id}")
    Observable<List<String>> getView(@Header("Authorization") String userToken,
                                     @Path("id") Integer objectId);

    @GET("fly-active/{id}")
    Observable<List<ResponsePoint>> getPoints(@Header("Authorization") String userToken,
                                              @Path("id") Integer objectId);

    @POST("worksheet/{id}")
    Observable<Response<ResponseSaveFlyActive>> saveFlyActive(@Header("Authorization") String userToken,
                                                              @Body RequestFlyActive requestFlyActive,
                                                              @Path("id") int objectId);
    @GET("get-pesticides/{id}")
    Observable<List<ResponseHandBook>> getPreparation(@Header("Authorization") String userToken,
                                                      @Path("id") int id);

    @GET("fly-control-active/{id}")
    Observable<List<ResponseHandBook>> getObjects(@Header("Authorization") String userToken,
                                                  @Path("id") int id);

    @GET("fly-control-prof")
    Observable<List<ResponseHandBook>> getActions(@Header("Authorization") String userToken);

    @GET("get-all-pest")
    Observable<List<ResponseHandBook>> getAllPets(@Header("Authorization") String userToken);

    @GET("plots-rec/{id}")
    Observable<List<ResponseHandBook>> getAreas(@Header("Authorization") String userToken,
                                                @Path("id") int id);
}
