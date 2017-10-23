package kazpost.kz.mobterminal.ui.dbcrud;

import kazpost.kz.mobterminal.di.PerActivity;
import kazpost.kz.mobterminal.ui.base.MvpPresenter;

@PerActivity
public interface CrudMvpPresenter<V extends CrudMvpView> extends MvpPresenter<V> {
    void saveToDb();
}