package kazpost.kz.mobterminal.data.remote;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by quanlt on 19/01/2017.
 */

public interface ApiService {
    @GET("login")
    Observable<Login> getLoginData( @Query("username") String username,
                                    @Query("password") String password);

//    @GET("comments")
//    Observable<List<Comment>> getComments(@Query("userId") int userId);
//
//    @GET("photos?_limit=20")
//    Observable<List<Photo>> getPhotos(@Query("userId") int userId);

    class Creator {

        public static Retrofit newRetrofitInstance() {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build();


            return new Retrofit.Builder()
                    .baseUrl("http://someurl")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(client)
                    .build();

        }

    }
}
