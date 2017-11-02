package kazpost.kz.mobterminal.ui.newlogin;

import kazpost.kz.mobterminal.ui.base.BasePresenter;
import kazpost.kz.mobterminal.ui.base.MvpPresenter;

/**
 * Created by root on 11/2/17.
 */

public interface NewLoginPresenter<V extends NewLoginView> extends MvpPresenter<V> {

    void doLogin(String username, String password);
}
