package kazpost.kz.mobterminal.ui.draw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;

import butterknife.BindView;
import butterknife.ButterKnife;
import kazpost.kz.mobterminal.R;

public class DrawingActivity extends AppCompatActivity {

    @BindView(R.id.simpleDrawingView1)
    SimpleDrawingView simpleDrawingView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);
        ButterKnife.bind(this);

    }


}
