package ar.com.developeando.tusuerte;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import ar.com.developeando.tusuerte.iface.Oracleable;
import ar.com.developeando.tusuerte.model.Signo;
import ar.com.developeando.tusuerte.task.OraculoTask;

/**
 * Created by Alumno on 21/4/2017.
 */

public class ResultActivity extends AppCompatActivity implements Oracleable {

    Signo signo = null;
    protected String amor;
    protected String salud;
    protected String dinero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        // Obtenemos el intent
        signo = (Signo) getIntent().getSerializableExtra("signo");

        // Ponemos el nombre del signo
        TextView textSigno = (TextView) findViewById(R.id.textSigno);
        textSigno.setText(signo.getNombre());

        // La imagen del signo
        ImageView imgSigno = (ImageView) findViewById(R.id.imgSigno);
        imgSigno.setImageResource(signo.getImagen());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_name);

        OraculoTask task = new OraculoTask(this);
        task.execute(signo.getNombre());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_resultado, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;

        switch (item.getItemId()) {
            case R.id.itemEmail:
                intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_EMAIL, "");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Mi horóscopo");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                return true;

            case R.id.itemSMS:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("sms:1234"));  // This ensures only SMS apps respond
                intent.putExtra("sms_body", "Mi signo es: "+ signo.getNombre());
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }

                return true;

            case R.id.itemCompartir:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                return true;

            case R.id.itemAmor:
                intent = new Intent(getApplicationContext(), AmorPredictionActivity.class);
                intent.putExtra("horaculo", amor);
                startActivity(intent);
                return true;

            case R.id.itemSalud:
                intent = new Intent(getApplicationContext(), AmorPredictionActivity.class);
                intent.putExtra("horaculo", salud);
                startActivity(intent);
                return true;

            case R.id.itemDinero:
                intent = new Intent(getApplicationContext(), AmorPredictionActivity.class);
                intent.putExtra("horaculo", dinero);
                startActivity(intent);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public void oracleResponse(JSONObject object) {
        try {
            amor = object.getString("amor");
            dinero = object.getString("dinero");
            salud = object.getString("salud");
        } catch (JSONException e) {
            amor = salud = dinero = "Error al cargar el oraculo.";
        }
    }
}
