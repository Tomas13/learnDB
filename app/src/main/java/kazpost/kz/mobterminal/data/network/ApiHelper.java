package kazpost.kz.mobterminal.data.network;

import kazpost.kz.mobterminal.data.network.model.Envelope;
import kazpost.kz.mobterminal.data.network.model.request.RequestEnvelope;
import kazpost.kz.mobterminal.data.remote.Login;
import rx.Observable;

/**
 * Created by root on 4/12/17.
 */

public interface ApiHelper {

    Observable<Envelope> doAuthorizeOnServer(RequestEnvelope requestEnvelope);

    Observable<Login> doLogin(String username, String password);
}
