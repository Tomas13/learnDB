package kazpost.kz.mobterminal.data.remote;

import rx.Observable;

/**
 * Created by quanlt on 19/01/2017.
 */

public interface RemoteDataSource {

    Observable<Login> getLoginData(String username, String password);

/*    Observable<List<User>> getUsers();
    
    Observable<List<Comment>> getComments(int userId);

    Observable<List<Photo>> getPhotos(int userId);*/
}
