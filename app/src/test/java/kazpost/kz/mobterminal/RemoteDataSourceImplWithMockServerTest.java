package kazpost.kz.mobterminal;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kazpost.kz.mobterminal.data.remote.ApiService;
import kazpost.kz.mobterminal.data.remote.Login;
import kazpost.kz.mobterminal.data.remote.RemoteDataSource;
import kazpost.kz.mobterminal.data.remote.RemoteDataSourceImpl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

import static junit.framework.Assert.assertEquals;

/**
 * Created by root on 11/2/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class RemoteDataSourceImplWithMockServerTest {
    private RemoteDataSource mRemoteDataSource;
    private MockWebServer server = new MockWebServer();

    @Before
    public void setUp() throws Exception {
        String url = server.url("/").toString();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        mRemoteDataSource = new RemoteDataSourceImpl(apiService);
    }

    public static Login getLoginData(String json, Gson gson) {
        Type userType = new TypeToken<Login>() {
        }.getType();
        return gson.fromJson(json, userType);
    }


    @Test
    public void testDoLoginSuccess() throws Exception {
        server.enqueue(new MockResponse().setBody("{\"id\":\"1\", \"success\":\"true\"}"));
        Observable<Login> result = mRemoteDataSource.getLoginData("username", "password");
        Login actual = result.toBlocking().first();
        Login expected = getLoginData("{\"id\":\"1\", \"success\":\"true\"}", new Gson());
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getSuccess(), actual.getSuccess());
    }

    @Test(expected = RuntimeException.class)
    public void testDoLoginFail() {
        server.enqueue(new MockResponse().setResponseCode(404).setBody("Generic Error"));
        Observable result = mRemoteDataSource.getLoginData("user", "pswd");
        result.toBlocking().first();
    }
}
