package ar.com.developeando.tusuerte;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Alumno on 11/4/2017.
 */

public class MainActivity extends Activity implements View.OnClickListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        Button btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText inputAnio = (EditText) findViewById(R.id.inputAnio);
        Integer anio = Integer.valueOf(inputAnio.getText().toString());

        if (validateAnio(anio)) {
            Toast.makeText(this, "El año "+ anio +" es válido y tu signo es "+ getSignoZodiaco(anio), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "El año "+ anio +" no es válido", Toast.LENGTH_SHORT).show();
        }


    }

    private Boolean validateAnio(Integer anio) {
        return anio >= 0 || anio <= 2017;
    }

    private String getSignoZodiaco(Integer anio) {
        switch (anio % 12) {
            case 0:
                return "mono";

            case 1:
                return "gallo";

            case 2:
                return "perro";

            case 3:
                return "cerdo";

            case 4:
                return "rata";

            case 5:
                return "buey";

            case 6:
                return "tigre";

            case 7:
                return "conejo";

            case 8:
                return "dragon";

            case 9:
                return "serpiente";

            case 10:
                return "caballo";

            case 11:
                return "oveja";
        }

        return "?";
    }
}
