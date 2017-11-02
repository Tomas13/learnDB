package kazpost.kz.mobterminal.data.network;

import javax.inject.Inject;
import javax.inject.Singleton;

import kazpost.kz.mobterminal.data.network.model.Envelope;
import kazpost.kz.mobterminal.data.network.model.request.RequestEnvelope;
import kazpost.kz.mobterminal.data.remote.Login;
import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by root on 4/12/17.
 */

@Singleton
public class AppApiHelper implements ApiHelper {

    @Inject
    NetworkService networkService;

    @Override
    public Observable<Envelope> doAuthorizeOnServer(RequestEnvelope requestEnvelope) {
        return networkService.requestStateInfoObs(requestEnvelope);
    }

    @Override
    public Observable<Login> doLogin(String username, String password) {
        return networkService.getLoginData(username, password);
    }

    @Inject
    public AppApiHelper() {
    }
    //    @Inject
//    public AppApiHelper(ApiHeader apiHeader) {
//        mApiHeader = apiHeader;
//    }
}
