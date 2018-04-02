package com.example.ik_2dm3.tudanka;

import android.content.Intent;
import android.net.ParseException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;


public class MainActivity extends AppCompatActivity {

    private static final String IDIOMA = "idioma";

    boolean reachable;

    JSONObject object;

    private String [] nombre = new String[5];
    private float [] marcador = new float[5];
    private double [] longitud = new double[5];
    private double [] latitud = new double[5];

    Intent intent;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        Intent Lenguaje = getIntent();
        final String LENG;
        LENG =Lenguaje.getStringExtra(IDIOMA);

        super.onCreate(savedInstanceState);

       intent  = new Intent(this, GPSactivity.class);



        if(LENG.equals("Castellano")){
            intent.putExtra(IDIOMA, "Castellano");}else
            intent.putExtra(IDIOMA, "Euskera");

        try {
            isOnlineNet();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    public Boolean isOnlineNet() throws IOException, org.json.simple.parser.ParseException, JSONException {

        try {
            Process p = java.lang.Runtime.getRuntime().exec("ping -c 1 www.google.es");

            int val = p.waitFor();
            reachable = (val == 0);

        } catch (Exception e) {

            e.printStackTrace();
        }

        if (!reachable) {
            InputStream is = getResources().openRawResource(R.raw.file);
            Writer writer = new StringWriter();
            char[] buffer = new char[1024];
            try {
                Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                is.close();
            }

            String jsonString = writer.toString();


            JSONObject jsono = new JSONObject(jsonString);


            JSONArray array = jsono.getJSONArray("myArrayList");



            for (int i = 0; i < array.length(); i++) {

                object = array.getJSONObject(i);

                latitud[i] = object.getDouble("latitud");
                longitud[i] = object.getDouble("longitud");

                marcador[i] = Float.parseFloat(String.valueOf(object.getDouble("marcador")));
                nombre[i] = object.getString("nombre");


            }

            intent.putExtra("latitud", latitud);
            intent.putExtra("marcador", marcador);
            intent.putExtra("nombre", nombre);
            intent.putExtra("longitud", longitud);

            startActivity(intent);

        }else{
            new JSONAsyncTask().execute("http://spinda.nsn.moe/file.json");
        }
        return false;
    }




    class JSONAsyncTask extends AsyncTask<String, Void, Boolean> {





        @Override
        public Boolean doInBackground(String... urls) {

            try {


                //------------------>>
                HttpGet httppost = new HttpGet(urls[0]);
                HttpClient httpclient = new DefaultHttpClient();
                HttpResponse response = httpclient.execute(httppost);

                // StatusLine stat = response.getStatusLine();
                int status = response.getStatusLine().getStatusCode();
                // if connected then access data
                if (status == 200) {
                    HttpEntity entity = response.getEntity();
                    String data = EntityUtils.toString(entity);


                    JSONObject jsono = new JSONObject(data);
                    JSONArray jarray = jsono.getJSONArray("myArrayList");


                    for (int i = 0; i < jarray.length(); i++) {
                        object = jarray.getJSONObject(i);


                        //getting json object values from json array
                        // mar.setNombre(object.getString("nombre"));
                        latitud [i] = object.getDouble("latitud");
                        longitud [i] = object.getDouble("longitud");

                        marcador [i] = Float.parseFloat(String.valueOf(object.getDouble("marcador")));
                        nombre [i] = object.getString("nombre");

                    }





                    intent.putExtra("latitud", latitud);
                    intent.putExtra("marcador",marcador);
                    intent.putExtra("nombre",nombre);
                    intent.putExtra("longitud", longitud);
                    startActivity(intent);

                }


            } catch (ParseException e1) {
                e1.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return false;
        }

        protected void onPostExecute(Boolean result) {

        }
    }

}
