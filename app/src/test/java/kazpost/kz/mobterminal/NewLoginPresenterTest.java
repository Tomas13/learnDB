package kazpost.kz.mobterminal;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import kazpost.kz.mobterminal.data.DataManager;
import kazpost.kz.mobterminal.data.remote.Login;
import kazpost.kz.mobterminal.ui.newlogin.NewLoginPresenterImpl;
import kazpost.kz.mobterminal.ui.newlogin.NewLoginView;
import rx.Observable;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by root on 11/2/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class NewLoginPresenterTest {
    @Mock
    NewLoginView mNewLoginView;

    @Mock
    DataManager mDataManager;

    private NewLoginPresenterImpl mNewLoginPresenter;

    @Rule
    public final RxSchedulerOverrideRule rule = new RxSchedulerOverrideRule();

    @Before
    public void setUp() throws Exception{
        mNewLoginPresenter = new NewLoginPresenterImpl(mDataManager);
        mNewLoginPresenter.onAttach(mNewLoginView);
    }

    @Test
    public void testDoLoginSuccess() throws Exception{
//        Login expected = "{\"id\":\"1\", \"success\":\"true\"}";
        Login expected = new Login();
        expected.setId(1);
        expected.setSuccess(true);
        when(mDataManager.doLogin("username", "password")).thenReturn(Observable.just(expected));

        mNewLoginPresenter.doLogin("username", "password");

        verify(mDataManager).doLogin("username", "password");
        verify(mNewLoginView).showLoading();
        verify(mNewLoginView).hideLoading();
        verify(mNewLoginView, times(0)).onErrorToast(anyString());
        verify(mNewLoginView).showLoginStatus(expected);
    }


    @Test
    public void testDoLoginError() throws Exception {
        when(mDataManager.doLogin("Rafa", "password")).thenReturn(Observable.error(new Throwable("my error")));
        mNewLoginPresenter.doLogin("Rafa", "password");

        verify(mDataManager).doLogin("Rafa", "password");
        verify(mNewLoginView).showLoading();
        verify(mNewLoginView, times(0)).showLoginStatus(any());
        verify(mNewLoginView).hideLoading();
        verify(mNewLoginView).onErrorToast("my error");

    }

}
