package kazpost.kz.mobterminal.ui.dbcrud;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import kazpost.kz.mobterminal.R;
import kazpost.kz.mobterminal.ui.base.BaseFragment;
import kazpost.kz.mobterminal.ui.login.LoginActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class CrudFragment extends BaseFragment implements CrudMvpView{

    @Inject
    CrudPresenter<CrudMvpView> presenter;

    public CrudFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_crud, container, false);

        getBaseActivity().getActivityComponent().inject(this);

        presenter.onAttach(this);


        setRetainInstance(true);
        return view;
    }

    @Override
    public void onErrorToast(String msg) {

    }

    public static Fragment newInstance() {
        return new CrudFragment();
    }
}
