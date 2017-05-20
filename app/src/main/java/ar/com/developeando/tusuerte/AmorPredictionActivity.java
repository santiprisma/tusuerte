package ar.com.developeando.tusuerte;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Alumno on 19/5/2017.
 */

public class AmorPredictionActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_amor_prediction);

        TextView textView = (TextView) findViewById(R.id.textAmor);
        if (getIntent().getStringExtra("horaculo") != null) {
            textView.setText(getIntent().getStringExtra("horaculo"));
        }
    }
}
