package ar.com.developeando.tusuerte;

import android.app.Activity;
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
            TextView textSigno = (TextView) findViewById(R.id.textSigno);
            Signo signo;

            if (validateAnio(anio)) {
                signo = getSignoZodiaco(anio);
                textSigno.setText("Tu signo es "+ signo.getNombre());
                textSigno.setVisibility(View.VISIBLE);
                signo.getImagen().setVisibility(View.VISIBLE);
            } else {
                Toast.makeText(this, "El año "+ anio +" no es válido", Toast.LENGTH_SHORT).show();
                textSigno.setVisibility(View.INVISIBLE);
            }

            inputAnio.setText("");

        } catch (NumberFormatException e) {
            inputAnio.setError("El valor debe ser númerico.");
        }
    }

    private Boolean validateAnio(Integer anio) {
        return anio >= 0 && anio <= 2017;
    }

    private Signo getSignoZodiaco(Integer anio) {
        Signo signo = new Signo();
        signo.setImagen((ImageView) findViewById(R.id.imgSigno));

        switch (anio % 12) {
            case 0:
                signo.setNombre("mono");
                signo.getImagen().setImageResource(R.drawable.mono);
                break;

            case 1:
                signo.setNombre("gallo");
                signo.getImagen().setImageResource(R.drawable.gallo);
                break;

            case 2:
                signo.setNombre("perro");
                signo.getImagen().setImageResource(R.drawable.perro);
                break;

            case 3:
                signo.setNombre("cerdo");
                signo.getImagen().setImageResource(R.drawable.cerdo);
                break;

            case 4:
                signo.setNombre("rata");
                signo.getImagen().setImageResource(R.drawable.rata);
                break;

            case 5:
                signo.setNombre("buey");
                signo.getImagen().setImageResource(R.drawable.buey);
                break;

            case 6:
                signo.setNombre("tigre");
                signo.getImagen().setImageResource(R.drawable.tigre);
                break;

            case 7:
                signo.setNombre("conejo");
                signo.getImagen().setImageResource(R.drawable.conejo);
                break;

            case 8:
                signo.setNombre("dragon");
                signo.getImagen().setImageResource(R.drawable.dragon);
                break;

            case 9:
                signo.setNombre("serpiente");
                signo.getImagen().setImageResource(R.drawable.serpiente);
                break;

            case 10:
                signo.setNombre("caballo");
                signo.getImagen().setImageResource(R.drawable.caballo);
                break;

            case 11:
                signo.setNombre("oveja");
                signo.getImagen().setImageResource(R.drawable.oveja);
                break;
        }

        return signo;
    }
}
