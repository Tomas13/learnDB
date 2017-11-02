package kazpost.kz.mobterminal.data;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import kazpost.kz.mobterminal.data.db.DbHelper;
import kazpost.kz.mobterminal.data.network.ApiHelper;
import kazpost.kz.mobterminal.data.network.model.Envelope;
import kazpost.kz.mobterminal.data.network.model.request.RequestEnvelope;
import kazpost.kz.mobterminal.data.prefs.PreferencesHelper;
import kazpost.kz.mobterminal.data.remote.Login;
import kazpost.kz.mobterminal.di.ApplicationContext;
import rx.Observable;

/**
 * Created by root on 4/12/17.
 */

@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";
    private final DbHelper dbHelper;
    private final Context mContext;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;


    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          DbHelper mDbHelper,
                          PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper) {
        mContext = context;
        dbHelper = mDbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }


    public Context getmContext() {
        return mContext;
    }


    public PreferencesHelper getmPreferencesHelper() {
        return mPreferencesHelper;
    }

    @Override
    public rx.Observable<Envelope> doAuthorizeOnServer(RequestEnvelope requestEnvelope) {
        return mApiHelper.doAuthorizeOnServer(requestEnvelope);
    }

    @Override
    public Observable<Login> doLogin(String username, String password) {
        return mApiHelper.doLogin(username, password);
    }

    @Override
    public void saveSessionId(String sessionId) {
        mPreferencesHelper.saveSessionId(sessionId);
    }
}
