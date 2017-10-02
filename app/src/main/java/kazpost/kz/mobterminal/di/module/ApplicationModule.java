/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package kazpost.kz.mobterminal.di.module;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import kazpost.kz.mobterminal.data.AppDataManager;
import kazpost.kz.mobterminal.data.DataManager;
import kazpost.kz.mobterminal.data.network.ApiHelper;
import kazpost.kz.mobterminal.data.network.AppApiHelper;
import kazpost.kz.mobterminal.data.network.NetworkService;
import kazpost.kz.mobterminal.data.prefs.AppPreferencesHelper;
import kazpost.kz.mobterminal.data.prefs.PreferencesHelper;
import kazpost.kz.mobterminal.data.realm.RealmHelper;
import kazpost.kz.mobterminal.di.ApplicationContext;
import kazpost.kz.mobterminal.di.DatabaseInfo;
import kazpost.kz.mobterminal.di.PreferenceInfo;
import kazpost.kz.mobterminal.utils.AppConstants;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

import static kazpost.kz.mobterminal.utils.AppConstants.BASE_URL;
import static kazpost.kz.mobterminal.utils.AppConstants.DATABASE_NAME;
import static kazpost.kz.mobterminal.utils.AppConstants.DATABASE_VERSION;

/**
 * Created by janisharali on 27/01/17.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }


    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

//    @Provides
//    @Singleton
//    RealmHelper provideRealmHelper(RealmHelper appRealmHelper) {
//        return appRealmHelper;
//    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return DATABASE_NAME;
    }

    @Provides
    @DatabaseInfo
    Integer provideDatabaseVersion() {
        return DATABASE_VERSION;
    }


    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }


    @Provides
    @Singleton
    Cache provideHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024;
        return new Cache(application.getCacheDir(), cacheSize);
    }


    @Provides
    @Singleton
    OkHttpClient provideOkhttpClient(Cache cache) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addNetworkInterceptor(new StethoInterceptor());
        client.connectTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES);
        client.cache(cache);
        return client.build();
    }


    @Provides
    @Singleton
    NetworkService provideNetworkService(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        
//                .baseUrl("http://172.30.223.25:8088/mobiterminal/Terminal.wsdl/")
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build();

        return retrofit.create(NetworkService.class);
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

}
