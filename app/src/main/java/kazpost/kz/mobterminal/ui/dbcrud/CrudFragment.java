package kazpost.kz.mobterminal.ui.dbcrud;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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

        view.findViewById(R.id.floatingActionButton).setOnClickListener(view1 -> fab());
        setRetainInstance(true);
        return view;
    }

    public void fab(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Message")
                .setPositiveButton("Fire?", (dialog, id) -> {
                    // FIRE ZE MISSILES!
                    Toast.makeText(getBaseActivity().getApplicationContext(), "Hello", Toast.LENGTH_SHORT).show();

                });

        builder.create().show();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("CrudFrag", "onCreate");
    }

    @Override
    public void onErrorToast(String msg) {

    }

    public static Fragment newInstance() {
        return new CrudFragment();
    }
}
