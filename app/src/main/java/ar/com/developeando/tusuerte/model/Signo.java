package ar.com.developeando.tusuerte.model;

import android.widget.ImageView;

/**
 * Created by Alumno on 11/4/2017.
 */

public class Signo {
    private String nombre;
    private ImageView imagen;

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
    }
    public ImageView getImagen() {

        return imagen;
    }
}
