package kazpost.kz.mobterminal.ui.dbcrud;

import javax.inject.Inject;

import kazpost.kz.mobterminal.data.DataManager;
import kazpost.kz.mobterminal.ui.base.BasePresenter;

/**
 * Created by root on 10/23/17.
 */

public class CrudPresenter<V extends CrudMvpView> extends BasePresenter<V> implements CrudMvpPresenter<V> {

    @Inject
    public CrudPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void saveToDb() {

    }
}
