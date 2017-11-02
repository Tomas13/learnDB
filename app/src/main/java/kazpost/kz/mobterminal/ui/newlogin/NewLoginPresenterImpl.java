package kazpost.kz.mobterminal.ui.newlogin;

import javax.inject.Inject;

import kazpost.kz.mobterminal.data.DataManager;
import kazpost.kz.mobterminal.data.remote.Login;
import kazpost.kz.mobterminal.ui.base.BasePresenter;
import kazpost.kz.mobterminal.utils.EspressoIdlingResource;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by root on 11/2/17.
 */

public class NewLoginPresenterImpl<V extends NewLoginView> extends BasePresenter<V> implements NewLoginPresenter<V> {

    @Inject
    public NewLoginPresenterImpl(DataManager mDataManager) {
        super(mDataManager);
    }

    @Override
    public void doLogin(String username, String password) {
        getMvpView().showLoading();
        Observable<Login> observable = getDataManager().doLogin(username, password);

        getMvpView().hideLoading();

        observable.subscribe(login -> getMvpView().showLoginStatus(login));

/*
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(login -> {
                    EspressoIdlingResource.increment();
                    getMvpView().showLoginStatus(login);
                }, throwable -> {
                    EspressoIdlingResource.decrement();
                    getMvpView().onErrorToast(throwable.getMessage());
                });
*/
    }
}
