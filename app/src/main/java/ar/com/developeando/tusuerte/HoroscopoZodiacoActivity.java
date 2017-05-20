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

import java.util.Calendar;
import java.util.GregorianCalendar;

import ar.com.developeando.tusuerte.model.Signo;

/**
 * Created by Alumno on 21/4/2017.
 */

public class HoroscopoZodiacoActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horoscopo_zodiaco);

        Button btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer dia = -1;
                Integer mes = -1;

                EditText inputDia = (EditText) findViewById(R.id.inputDia);
                EditText inputMes = (EditText) findViewById(R.id.inputMes);

                try {
                    dia = Integer.valueOf(inputDia.getText().toString());
                } catch (NumberFormatException e) {
                    inputDia.setError("El valor ingresado no es correcto.");
                }

                try {
                    mes = Integer.valueOf(inputMes.getText().toString());
                } catch (NumberFormatException e) {
                    inputMes.setError("El valor ingresado no es correcto.");
                }

                // Validamos la fecha
                try {
                    validateDate(dia, mes);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "La fecha ingresada no es correcta.", Toast.LENGTH_SHORT).show();
                } finally {
                    inputDia.setText("");
                    inputMes.setText("");
                }

                // Obtenemos el signo
                Signo signo = getSignoZodiaco(dia, mes);

                if (signo.getNombre() != null) {
                    // Iniciamos la vista del resultado
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.putExtra("signo", signo);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void validateDate(Integer dia, Integer mes) throws Exception {
        Calendar current = Calendar.getInstance();
        Calendar c = new GregorianCalendar();
        c.setLenient(false);
        c.set(current.get(Calendar.YEAR), mes - 1, dia);
        c.getTime();
    }

    private Signo getSignoZodiaco(Integer dia, Integer mes) {
        Signo signo = new Signo();

        if ((mes == 12 && dia >= 22 && dia <= 31) || (mes ==  1 && dia >= 1 && dia <= 19)) {
            signo.setNombre(getString(R.string.capricornio));
            signo.setImagen(R.drawable.capricornio);
            signo.setKey("capricornio");
        }
        else if ((mes ==  1 && dia >= 20 && dia <= 31) || (mes ==  2 && dia >= 1 && dia <= 17)) {
            signo.setNombre(getString(R.string.acuario));
            signo.setImagen(R.drawable.acuario);
            signo.setKey("acuario");
        }
        else if ((mes ==  2 && dia >= 18 && dia <= 29) || (mes ==  3 && dia >= 1 && dia <= 19)) {
            signo.setNombre(getString(R.string.piscis));
            signo.setImagen(R.drawable.piscis);
            signo.setKey("piscis");
        }
        else if ((mes ==  3 && dia >= 20 && dia <= 31) || (mes ==  4 && dia >= 1 && dia <= 19)) {
            signo.setNombre(getString(R.string.aries));
            signo.setImagen(R.drawable.aries);
            signo.setKey("aries");
        }
        else if ((mes ==  4 && dia >= 20 && dia <= 30) || (mes ==  5 && dia >= 1 && dia <= 20)) {
            signo.setNombre(getString(R.string.tauro));
            signo.setImagen(R.drawable.tauro);
            signo.setKey("tauro");
        }
        else if ((mes ==  5 && dia >= 21 && dia <= 31) || (mes ==  6 && dia >= 1 && dia <= 20)) {
            signo.setNombre(getString(R.string.geminis));
            signo.setImagen(R.drawable.geminis);
            signo.setKey("geminis");
        }
        else if ((mes ==  6 && dia >= 21 && dia <= 30) || (mes ==  7 && dia >= 1 && dia <= 22)) {
            signo.setNombre(getString(R.string.cancer));
            signo.setImagen(R.drawable.cancer);
            signo.setKey("cancer");
        }
        else if ((mes ==  7 && dia >= 23 && dia <= 31) || (mes ==  8 && dia >= 1 && dia <= 22)) {
            signo.setNombre(getString(R.string.leo));
            signo.setImagen(R.drawable.leo);
            signo.setKey("leo");
        }
        else if ((mes ==  8 && dia >= 23 && dia <= 31) || (mes ==  9 && dia >= 1 && dia <= 22)) {
            signo.setNombre(getString(R.string.virgo));
            signo.setImagen(R.drawable.virgo);
            signo.setKey("virgo");
        }
        else if ((mes ==  9 && dia >= 23 && dia <= 30) || (mes == 10 && dia >= 1 && dia <= 22)) {
            signo.setNombre(getString(R.string.libra));
            signo.setImagen(R.drawable.libra);
            signo.setKey("libra");
        }
        else if ((mes == 10 && dia >= 23 && dia <= 31) || (mes == 11 && dia >= 1 && dia <= 21)) {
            signo.setNombre(getString(R.string.escorpio));
            signo.setImagen(R.drawable.escorpio);
            signo.setKey("escorpio");
        }
        else if ((mes == 11 && dia >= 22 && dia <= 30) || (mes == 12 && dia >= 1 && dia <= 21)) {
            signo.setNombre(getString(R.string.sagitario));
            signo.setImagen(R.drawable.sagitario);
            signo.setKey("sagitario");
        }

        return signo;
    }
}
