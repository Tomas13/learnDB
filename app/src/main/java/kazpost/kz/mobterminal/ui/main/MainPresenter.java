package kazpost.kz.mobterminal.ui.main;

import javax.inject.Inject;

import kazpost.kz.mobterminal.data.DataManager;
import kazpost.kz.mobterminal.ui.base.BasePresenter;

/**
 * Created by root on 4/12/17.
 */

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V>
        implements MainMvpPresenter<V> {

    @Inject
    public MainPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onSortBtnClicked() {
        getMvpView().openScanActivity();
    }

    @Override
    public void onConfigPrinterBtnClicked() {
        getMvpView().onError("config printer");

    }

    @Override
    public void onCloseCellBtnClicked() {
        getMvpView().openCloseCellActivity();
    }
}
