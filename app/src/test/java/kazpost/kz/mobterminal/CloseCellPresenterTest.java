package kazpost.kz.mobterminal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import kazpost.kz.mobterminal.data.DataManager;
import kazpost.kz.mobterminal.ui.closecell.CloseCellMvpView;
import kazpost.kz.mobterminal.ui.closecell.CloseCellPresenter;

import static org.mockito.Mockito.verify;

/**
 * Created by root on 11/3/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class CloseCellPresenterTest {

    @Mock
    CloseCellMvpView closeCellMvpView;

    @Mock
    DataManager dataManager;

    private CloseCellPresenter closeCellPresenter;

    @Before
    public void setUp(){
        closeCellPresenter=new CloseCellPresenter(dataManager);
        closeCellPresenter.onAttach(closeCellMvpView);
    }

    @Test
    public void testOpenPrintActivity(){
        closeCellPresenter.openPrintActivity();
        verify(closeCellMvpView).openPrintActivity();
    }
}
