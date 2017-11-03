package kazpost.kz.mobterminal.ui.digitalcitizen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import kazpost.kz.mobterminal.R;
import kazpost.kz.mobterminal.ui.base.BaseActivity;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.lv_main2)
    ListView lvMain2;

    String[] items = {"Аптеки", "Больницы", "Стоматология", "Поликлиники"};

    Main2Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle("Hello");

        presenter = new Main2Presenter(this);

        ScheduleListAdapter arrayAdapter = new ScheduleListAdapter(getApplicationContext(),
                items);

        lvMain2.setAdapter(arrayAdapter);
        lvMain2.setOnItemClickListener((adapterView, view, i, l) -> {
            presenter.openOrganization(i);
        });

    }


    public void showOrganization(Intent i) {
        startActivity(i);
    }
}
