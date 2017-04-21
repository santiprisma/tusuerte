package ar.com.developeando.tusuerte;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Alumno on 21/4/2017.
 */

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button btnCalcular = (Button) findViewById(R.id.btnCalcular);
        Button btnChino = (Button) findViewById(R.id.btnChino);
        btnChino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HoroscopoChinoActivity.class);
                startActivity(intent);
            }
        });

/*        boton .setOnClickListener(new OnClickListener() {
            protected void onClick(View c) {
            }
        };*/
    }
}
