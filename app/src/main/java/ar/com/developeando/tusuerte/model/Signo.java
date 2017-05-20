package ar.com.developeando.tusuerte.model;

import android.widget.ImageView;

import java.io.Serializable;

/**
 * Created by Alumno on 11/4/2017.
 */

public class Signo implements Serializable {
    private String nombre;
    private int imagen;
    private String key;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
    public int getImagen() {
        return imagen;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
