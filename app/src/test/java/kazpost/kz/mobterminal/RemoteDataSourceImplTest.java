package kazpost.kz.mobterminal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import kazpost.kz.mobterminal.data.remote.ApiService;
import kazpost.kz.mobterminal.data.remote.RemoteDataSource;
import kazpost.kz.mobterminal.data.remote.RemoteDataSourceImpl;
import rx.Observable;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by root on 11/2/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class RemoteDataSourceImplTest {
    @Mock
    private ApiService mMockApiService;
    private RemoteDataSource mRemoteDataSource;

    @Before
    public void setUp() throws Exception {
        mRemoteDataSource = new RemoteDataSourceImpl(mMockApiService);
    }

    @Test
    public void testLoginSuccess() throws Exception {
        mRemoteDataSource.getLoginData("username", "password");
        verify(mMockApiService, times(1)).getLoginData("username", "password");
    }

    @Test(expected = Exception.class)
    public void testLoginFailed() throws Exception {
        when(mRemoteDataSource.getLoginData("username", "password"))
                .thenReturn(Observable.error(new Throwable("error")));
        mRemoteDataSource.getLoginData("username", "password").toBlocking().first();
    }
}
