package ar.com.developeando.tusuerte;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import ar.com.developeando.tusuerte.model.Signo;

/**
 * Created by Alumno on 21/4/2017.
 */

public class ResultActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        // Obtenemos el intent
        Signo signo = (Signo) getIntent().getSerializableExtra("signo");

        TextView textSigno = (TextView) findViewById(R.id.textSigno);
        textSigno.setText(signo.getNombre());
    }
}
