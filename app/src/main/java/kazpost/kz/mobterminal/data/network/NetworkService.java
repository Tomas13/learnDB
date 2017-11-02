package kazpost.kz.mobterminal.data.network;

import kazpost.kz.mobterminal.data.network.model.Envelope;
import kazpost.kz.mobterminal.data.network.model.request.RequestEnvelope;
import kazpost.kz.mobterminal.data.remote.Login;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by root on 4/18/17.
 */

public interface NetworkService {

    @POST("mobiterminal/Terminal.wsdl")
    @Headers("Content-Type: text/xml")
    Observable<Envelope> requestStateInfoObs(@Body RequestEnvelope requestEnvelope);


    @GET("login")
    Observable<Login> getLoginData(@Query("username") String username,
                                   @Query("password") String password);
}
