package kazpost.kz.mobterminal.ui.digitalcitizen;

import android.content.Intent;

/**
 * Created by root on 11/3/17.
 */

class Main2Presenter {
    private Main2Activity view;

    public Main2Presenter(Main2Activity view) {
        this.view = view;
    }

    public void openOrganization(int i) {
        Intent intent = null;
        switch (i) {
            case 0:
                intent = new Intent(view, DrugStoreActivity.class);
                break;
            case 1:
                intent = new Intent(view, HospitalActivity.class);
                break;

            default:
                intent = new Intent(view, DrugStoreActivity.class);
                break;
//            case 2:
//                intent = new Intent(view, DentintsActivity.class);
//                break;
//            case 3:
//                intent = new Intent(view, ClinicsActivity.class);
//                break;
        }

        view.showOrganization(intent);
    }
}
