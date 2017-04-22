package ar.com.developeando.tusuerte;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import ar.com.developeando.tusuerte.model.Signo;

/**
 * Created by Alumno on 21/4/2017.
 */

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        // Obtenemos el intent
        Signo signo = (Signo) getIntent().getSerializableExtra("signo");

        // Ponemos el nombre del signo
        TextView textSigno = (TextView) findViewById(R.id.textSigno);
        textSigno.setText(signo.getNombre());

        // La imagen del signo
        ImageView imgSigno = (ImageView) findViewById(R.id.imgSigno);
        imgSigno.setImageResource(signo.getImagen());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_name);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_resultado, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemEmail:
                return true;

            case R.id.itemSMS:
                return true;

            case R.id.itemCompartir:
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
