package kazpost.kz.mobterminal;

import kazpost.kz.mobterminal.data.PlaceHolderRepository;
import kazpost.kz.mobterminal.data.remote.Login;
import kazpost.kz.mobterminal.data.remote.RemoteDataSource;
import rx.Observable;

/**
 * Created by root on 11/2/17.
 */

public class PlaceHolderReposityImpl implements PlaceHolderRepository {
    private RemoteDataSource mRemoteDataSource;

    public PlaceHolderReposityImpl(RemoteDataSource mRemoteDataSource) {
        this.mRemoteDataSource = mRemoteDataSource;
    }

    @Override
    public Observable<Login> doLogin(String username, String password) {
        return mRemoteDataSource.getLoginData(username, password);
    }
}
