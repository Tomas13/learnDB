package kazpost.kz.mobterminal.ui.digitalcitizen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import kazpost.kz.mobterminal.R;

public class DrugStoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drug_store);

        getSupportActionBar().setTitle("DrugStore");
    }
}
