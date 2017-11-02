package kazpost.kz.mobterminal.data;


import kazpost.kz.mobterminal.data.remote.Login;
import rx.Observable;

/**
 * Created by root on 11/2/17.
 */

public interface PlaceHolderRepository {
    Observable<Login> doLogin(String username, String password);
}
