package kazpost.kz.mobterminal.ui.dbcrud


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kazpost.kz.mobterminal.R
import kazpost.kz.mobterminal.ui.base.BaseFragment
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
class CrudKotlinFragment : BaseFragment(), CrudMvpView {


    fun newInstance(): CrudKotlinFragment {
        return this
    }

    @Inject
    internal var presenter: CrudPresenter<CrudMvpView>? = null

    override fun onErrorToast(msg: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_crud_kotlin, container, false)

        retainInstance = true

        presenter?.onAttach(this)
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("CrudKot", "Oncreate")
    }

}// Required empty public constructor
