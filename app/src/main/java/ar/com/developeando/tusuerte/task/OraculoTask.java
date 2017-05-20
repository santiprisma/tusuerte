package ar.com.developeando.tusuerte.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import ar.com.developeando.tusuerte.iface.Oracleable;
import ar.com.developeando.tusuerte.util.JSONUtil;

/**
 * Created by Alumno on 19/5/2017.
 */

public class OraculoTask extends AsyncTask<String, Void, JSONObject> {
    private final String URL_SERVICIO = "https://zodiaco-android.appspot.com/_ah/api/horoscopoApi/v1/horoscopo/";
    protected Oracleable activity = null;
    protected ProgressDialog dialog = null;

    public OraculoTask(Oracleable activity) {
        this.activity = activity;
    }

    @Override
    protected JSONObject doInBackground(String... params) {
        try {
            return JSONUtil.getObjectFromURL(URL_SERVICIO + "leo"/*params[0]*/);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show((Context) activity, "Procesando", "Espere por favor");
    }

    @Override
    protected void onPostExecute(JSONObject json) {
        dialog.dismiss();
        activity.oracleResponse(json);
    }
}
