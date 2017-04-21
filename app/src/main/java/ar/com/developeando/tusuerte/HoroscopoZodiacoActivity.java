package ar.com.developeando.tusuerte;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

             //   Signo signo = getSignoZodiaco(dia, mes);
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

    /*private Signo getSignoZodiaco(Integer dia, Integer mes) {
        if ((month == 12 && day >= 22 && day <= 31) || (month ==  1 && day >= 1 && day <= 19))
    }*/
}
