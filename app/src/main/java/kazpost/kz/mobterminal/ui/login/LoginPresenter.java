package kazpost.kz.mobterminal.ui.login;

import android.util.Log;

import javax.inject.Inject;

import kazpost.kz.mobterminal.data.DataManager;
import kazpost.kz.mobterminal.data.network.model.Envelope;
import kazpost.kz.mobterminal.data.network.model.request.AuthRequestBody;
import kazpost.kz.mobterminal.data.network.model.request.AuthRequestData;
import kazpost.kz.mobterminal.data.network.model.request.RequestEnvelope;
import kazpost.kz.mobterminal.ui.base.BasePresenter;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by root on 4/12/17.
 */

public class LoginPresenter<V extends LoginMvpView> extends BasePresenter<V> implements LoginMvpPresenter<V> {

    private static final String TAG = "LoginPresenter";

    @Inject
    public LoginPresenter(DataManager dataManager) {
        super(dataManager);
    }


    @Override
    public void onLoginCodeScan() {
        showPin();
    }

    @Override
    public void onLoginBtnClicked(String barcode, String pin) {

        getMvpView().showLoading();


        RequestEnvelope requestEnvelope = new RequestEnvelope();
        AuthRequestBody authRequestBody = new AuthRequestBody();
        AuthRequestData authRequestData = new AuthRequestData();
        authRequestData.setUserBarcode(barcode);
        authRequestData.setUserPin(pin);
        authRequestBody.setAuthRequestData(authRequestData);

        requestEnvelope.setAuthRequestBody(authRequestBody);


        Observable<Envelope> observable = getDataManager().doAuthorizeOnServer(requestEnvelope);

        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        envelope -> {
                            Envelope.ResponseInfo responseInfo = envelope.getBody().getAuthorizeResponse().getResponseInfo();


                            if (responseInfo.getResponseCode().equals("0")) {

                                String responseGenTime = responseInfo.getResponseGenTime();
                                String sessioId = envelope.getBody().getAuthorizeResponse().getSessionId();

                                getMvpView().onErrorToast(responseGenTime);

                                getDataManager().saveSessionId(sessioId);

                            } else {
                                Log.d(TAG, "throwable " + responseInfo.getResponseText());

                                getMvpView().onErrorToast(responseInfo.getResponseText());
                            }

                            getMvpView().hideLoading();
                        },
                        throwable -> {
                            Log.d(TAG, "throwable " + throwable.getMessage());

                            getMvpView().onErrorToast(throwable.getMessage());
                            getMvpView().hideLoading();
                        });

    }


    private void showPin() {
        getMvpView().showPinEditText();
    }

}
