package kazpost.kz.mobterminal.ui.newlogin;

import kazpost.kz.mobterminal.data.remote.Login;
import kazpost.kz.mobterminal.ui.base.MvpView;

/**
 * Created by root on 11/2/17.
 */

public interface NewLoginView extends MvpView{
    void showLoginStatus(Login expected);
}
