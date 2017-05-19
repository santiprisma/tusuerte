package ar.com.developeando.tusuerte;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import ar.com.developeando.tusuerte.model.Signo;

/**
 * Created by Alumno on 11/4/2017.
 */

public class HoroscopoChinoActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horoscopo_chino);

        Button btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText inputAnio = (EditText) findViewById(R.id.inputAnio);
        try {
            Integer anio = Integer.valueOf(inputAnio.getText().toString());

            if (validateAnio(anio)) {
                Signo signo = getSignoChino(anio);

                if (signo.getNombre() != null) {
                    // Iniciamos la vista del resultado
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.putExtra("signo", signo);
                    startActivity(intent);
                    finish();
                }
            } else {
                Toast.makeText(this, "El año "+ anio +" no es válido", Toast.LENGTH_SHORT).show();
            }

            inputAnio.setText("");

        } catch (NumberFormatException e) {
            inputAnio.setError("El valor debe ser númerico.");
        }
    }

    private Boolean validateAnio(Integer anio) {
        return anio >= 0 && anio <= 2017;
    }

    private Signo getSignoChino(Integer anio) {
        Signo signo = new Signo();

        switch (anio % 12) {
            case 0:
                signo.setNombre(getString(R.string.mono));
                signo.setImagen(R.drawable.mono);
                break;

            case 1:
                signo.setNombre(getString(R.string.gallo));
                signo.setImagen(R.drawable.gallo);
                break;

            case 2:
                signo.setNombre(getString(R.string.perro));
                signo.setImagen(R.drawable.perro);
                break;

            case 3:
                signo.setNombre(getString(R.string.cerdo));
                signo.setImagen(R.drawable.cerdo);
                break;

            case 4:
                signo.setNombre(getString(R.string.rata));
                signo.setImagen(R.drawable.rata);
                break;

            case 5:
                signo.setNombre(getString(R.string.buey));
                signo.setImagen(R.drawable.buey);
                break;

            case 6:
                signo.setNombre(getString(R.string.tigre));
                signo.setImagen(R.drawable.tigre);
                break;

            case 7:
                signo.setNombre(getString(R.string.conejo));
                signo.setImagen(R.drawable.conejo);
                break;

            case 8:
                signo.setNombre(getString(R.string.dragon));
                signo.setImagen(R.drawable.dragon);
                break;

            case 9:
                signo.setNombre(getString(R.string.serpiente));
                signo.setImagen(R.drawable.serpiente);
                break;

            case 10:
                signo.setNombre(getString(R.string.caballo));
                signo.setImagen(R.drawable.caballo);
                break;

            case 11:
                signo.setNombre(getString(R.string.oveja));
                signo.setImagen(R.drawable.oveja);
                break;
        }

        return signo;
    }
}
