package ar.com.developeando.tusuerte;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                Integer mes, año;

                EditText inputMes = (EditText) findViewById(R.id.inputMes);
                EditText inputAño = (EditText) findViewById(R.id.inputAnio);

                try {
                    mes = Integer.valueOf(inputMes.getText().toString());
                } catch (NumberFormatException e) {
                    inputMes.setError("El valor ingresado no es correcto.");
                }

                try {
                    año = Integer.valueOf(inputAño.getText().toString());
                } catch (NumberFormatException e) {
                    inputAño.setError("El valor ingresado no es correcto.");
                }
            }
        });

    }
}
