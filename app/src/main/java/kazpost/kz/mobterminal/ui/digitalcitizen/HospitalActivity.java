package kazpost.kz.mobterminal.ui.digitalcitizen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kazpost.kz.mobterminal.R;

public class HospitalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);

        getSupportActionBar().setTitle("Hospital");
    }
}
