package kazpost.kz.mobterminal.data.remote;

import rx.Observable;

/**
 * Created by root on 11/2/17.
 */

public class RemoteDataSourceImpl implements RemoteDataSource {
    private ApiService mApiService;

    public RemoteDataSourceImpl(ApiService mApiService) {
        this.mApiService = mApiService;
    }

    @Override
    public Observable<Login> getLoginData(String username, String password) {
        return mApiService.getLoginData(username, password);
    }
}
