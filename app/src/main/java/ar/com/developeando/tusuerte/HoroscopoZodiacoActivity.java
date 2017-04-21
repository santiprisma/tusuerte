package ar.com.developeando.tusuerte;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
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
                TextView textSigno = (TextView) findViewById(R.id.textSigno);

                // Borramos el resultado
                textSigno.setText("");

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
                    inputDia.setText("");
                    inputMes.setText("");
                }

                // Obtenemos el signo
                Signo signo = getSignoZodiaco(dia, mes);

                if (signo.getNombre() != null) {
                    // Lo mostramos
                    textSigno.setText("Tu signo es: " + signo.getNombre());

                    // Iniciamos la vista del resultado
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.putExtra("signo", signo);
                    startActivity(intent);
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
            signo.setNombre("Capricornio");
        }
        else if ((mes ==  1 && dia >= 20 && dia <= 31) || (mes ==  2 && dia >= 1 && dia <= 17)) {
            signo.setNombre("Acuario");
        }
        else if ((mes ==  2 && dia >= 18 && dia <= 29) || (mes ==  3 && dia >= 1 && dia <= 19)) {
            signo.setNombre("Piscis");
        }
        else if ((mes ==  3 && dia >= 20 && dia <= 31) || (mes ==  4 && dia >= 1 && dia <= 19)) {
            signo.setNombre("Aries");
        }
        else if ((mes ==  4 && dia >= 20 && dia <= 30) || (mes ==  5 && dia >= 1 && dia <= 20)) {
            signo.setNombre("Tauro");
        }
        else if ((mes ==  5 && dia >= 21 && dia <= 31) || (mes ==  6 && dia >= 1 && dia <= 20)) {
            signo.setNombre("Géminis");
        }
        else if ((mes ==  6 && dia >= 21 && dia <= 30) || (mes ==  7 && dia >= 1 && dia <= 22)) {
            signo.setNombre("Cancer");
        }
        else if ((mes ==  7 && dia >= 23 && dia <= 31) || (mes ==  8 && dia >= 1 && dia <= 22)) {
            signo.setNombre("Leo");
        }
        else if ((mes ==  8 && dia >= 23 && dia <= 31) || (mes ==  9 && dia >= 1 && dia <= 22)) {
            signo.setNombre("Virgo");
        }
        else if ((mes ==  9 && dia >= 23 && dia <= 30) || (mes == 10 && dia >= 1 && dia <= 22)) {
            signo.setNombre("Libra");
        }
        else if ((mes == 10 && dia >= 23 && dia <= 31) || (mes == 11 && dia >= 1 && dia <= 21)) {
            signo.setNombre("Escorpio");
        }
        else if ((mes == 11 && dia >= 22 && dia <= 30) || (mes == 12 && dia >= 1 && dia <= 21)) {
            signo.setNombre("Sagitario");
        }

        return signo;
    }
}
