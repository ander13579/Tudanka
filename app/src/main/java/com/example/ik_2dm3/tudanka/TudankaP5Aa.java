package com.example.ik_2dm3.tudanka;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TudankaP5Aa extends AppCompatActivity {


    private static final String IDIOMA = "idioma";

    private EditText caja1, caja2, caja3, caja4, caja5, caja6;
    private ImageView juego;

    TextView p52, p53, p54, p55, p56, p57;

    private MediaPlayer reproductor;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent Lenguaje = getIntent();
        final String LENG;
        LENG =Lenguaje.getStringExtra(IDIOMA);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tudanka_p5_aa);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

            juego = findViewById(R.id.crucigrama);
            juego.setImageResource(R.drawable.cr);
            caja1 = (EditText) findViewById(R.id.r1);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Azkena = new Intent(getApplicationContext(), Azkena.class);
                if(LENG.equals("Castellano")){
                    Azkena.putExtra(IDIOMA, "Castellano");
                    botonmostrarEspañol();
                }else {
                    Azkena.putExtra(IDIOMA, "Euskera");
                    botonmostrarEuskera();
                }
                startActivity(Azkena);
            }
        });

        if(LENG.equals("Castellano")){

            p52 = (TextView) findViewById(R.id.p5aatexto1);

            p52.setText( R.string.cap5aatexto1);

            p53 = (TextView) findViewById(R.id.p5aatexto2);

            p53.setText( R.string.cap5aatexto2);

            p54 = (TextView) findViewById(R.id.p5aatexto3);

            p54.setText( R.string.cap5aatexto3);

            p55 = (TextView) findViewById(R.id.p5aatexto4);

            p55.setText( R.string.cap5aatexto4);

            p56 = (TextView) findViewById(R.id.p5aatexto5);

            p56.setText( R.string.cap5aatexto5);

            p57 = (TextView) findViewById(R.id.p5aatexto6);

            p57.setText( R.string.cap5aatexto6);


            reproductor = MediaPlayer.create(this,R.raw.cap5a);

        } else{
            reproductor = MediaPlayer.create(this,R.raw.eup5aa);
        }
        reproductor.setLooping(false);
        reproductor.start();
    }

    public void botonmostrarEspañol() {
        Button bottonMostrar = (Button) findViewById(R.id.nombre);
        bottonMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            String respuesta1 = null;
            respuesta1 = caja1.getText().toString();

            if (respuesta1.compareTo("txorierri" )  == 0){
                respuesta1 = "txorierri";
                juego.setImageResource(R.drawable.cr1);

                caja2 = (EditText) findViewById(R.id.r2);
                String respuesta2 = null;
                respuesta2 = caja2.getText().toString();

                if (respuesta2.compareTo("Durango") == 0) {
                    respuesta2 = "Durango";
                    juego.setImageResource(R.drawable.cr2);

                    caja3 = (EditText) findViewById(R.id.r3);
                    String respuesta3 = null;
                    respuesta3 = caja3.getText().toString();

                    if (respuesta3.compareTo("Arkupea") == 0) {
                        respuesta3 = "Arkupea";
                        juego.setImageResource(R.drawable.cr3);

                        caja4 = (EditText) findViewById(R.id.r4);
                        String respuesta4 = null;
                        respuesta4 = caja4.getText().toString();

                        if (respuesta4.compareTo("Fuente") == 0) {
                            respuesta4 = "Fuente";
                            juego.setImageResource(R.drawable.cr4);

                            caja4 = (EditText) findViewById(R.id.r5);
                            String respuesta5 = null;
                            respuesta5 = caja5.getText().toString();

                            if (respuesta5.compareTo("Ciudad") == 0) {
                                respuesta5 = "Ciudad";
                                juego.setImageResource(R.drawable.cr5);

                                caja4 = (EditText) findViewById(R.id.r6);
                                String respuesta6 = null;
                                respuesta6 = caja6.getText().toString();

                                if (respuesta6.compareTo("Acero") == 0) {
                                    respuesta6 = "Acero";
                                    juego.setImageResource(R.drawable.cr4);

                                } else {
                                    Context context = getApplicationContext();
                                    CharSequence text = "NO AS RELLENADO EL PUNTO ANTERIOR";
                                    int duration = Toast.LENGTH_LONG;
                                    Toast toast = Toast.makeText(context, text, duration);
                                    toast.show();

                                    respuesta6 = null;
                                }
                            } else {
                                Context context = getApplicationContext();
                                CharSequence text = "NO AS RELLENADO EL PUNTO ANTERIOR";
                                int duration = Toast.LENGTH_LONG;
                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();

                                respuesta5 = null;
                            }

                        } else {
                            Context context = getApplicationContext();
                            CharSequence text = "NO AS RELLENADO EL PUNTO ANTERIOR";
                            int duration = Toast.LENGTH_LONG;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();

                            respuesta4 = null;
                        }

                    } else {
                        Context context = getApplicationContext();
                        CharSequence text = "NO AS RELLENADO EL PUNTO ANTERIOR";
                        int duration = Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();

                        respuesta3 = null;
                    }

                } else {
                    Context context = getApplicationContext();
                    CharSequence text = "NO AS RELLENADO EL PUNTO ANTERIOR";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    respuesta2 = null;
                }

            } else {
                Context context = getApplicationContext();
                CharSequence text = "MAL VUELVE A INTENTARLO";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                respuesta1 = null;
            }
            }
        });
    }

    public void botonmostrarEuskera() {
        Button bottonMostrar = (Button) findViewById(R.id.nombre);
        bottonMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            String respuesta1 = null;
            respuesta1 = caja1.getText().toString();

            if (respuesta1.compareTo("txorierri") == 0) {
                respuesta1 = "txorierri";
                juego.setImageResource(R.drawable.cr1);

                caja2 = (EditText) findViewById(R.id.r2);
                String respuesta2 = null;
                respuesta2 = caja2.getText().toString();

                if (respuesta2.compareTo("Durango") == 0) {
                    respuesta2 = "Durango";
                    juego.setImageResource(R.drawable.cr2);

                    caja3 = (EditText) findViewById(R.id.r3);
                    String respuesta3 = null;
                    respuesta3 = caja3.getText().toString();

                    if (respuesta3.compareTo("Arkupea") == 0) {
                        respuesta3 = "Arkupea";
                        juego.setImageResource(R.drawable.cr3);

                        caja4 = (EditText) findViewById(R.id.r4);
                        String respuesta4 = null;
                        respuesta4 = caja4.getText().toString();

                        if (respuesta4.compareTo("Iturria") == 0) {
                            respuesta4 = "Iturria";
                            juego.setImageResource(R.drawable.cr4);

                            caja4 = (EditText) findViewById(R.id.r5);
                            String respuesta5 = null;
                            respuesta5 = caja5.getText().toString();

                            if (respuesta5.compareTo("Hiribildua") == 0) {
                                respuesta5 = "Hiribildua";
                                juego.setImageResource(R.drawable.cr5);

                                caja4 = (EditText) findViewById(R.id.r6);
                                String respuesta6 = null;
                                respuesta6 = caja6.getText().toString();

                                if (respuesta6.compareTo("Altzairua") == 0) {
                                    respuesta6 = "Altzairua";
                                    juego.setImageResource(R.drawable.cr4);

                                } else {
                                    Context context = getApplicationContext();
                                    CharSequence text = "AURREKO PUNTUA BETE BEHAR DUZU";
                                    int duration = Toast.LENGTH_LONG;
                                    Toast toast = Toast.makeText(context, text, duration);
                                    toast.show();

                                    respuesta6 = null;
                                }
                            } else {
                                Context context = getApplicationContext();
                                CharSequence text = "AURREKO PUNTUA BETE BEHAR DUZU";
                                int duration = Toast.LENGTH_LONG;
                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();

                                respuesta5 = null;
                            }

                        } else {
                            Context context = getApplicationContext();
                            CharSequence text = "AURREKO PUNTUA BETE BEHAR DUZU";
                            int duration = Toast.LENGTH_LONG;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();

                            respuesta4 = null;
                        }

                    } else {
                        Context context = getApplicationContext();
                        CharSequence text = "AURREKO PUNTUA BETE BEHAR DUZU";
                        int duration = Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();

                        respuesta3 = null;
                    }

                } else {
                    Context context = getApplicationContext();
                    CharSequence text = "AURREKO PUNTUA BETE BEHAR DUZU";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    respuesta2 = null;
                }

            } else {
                Context context = getApplicationContext();
                CharSequence text = "TXARTO DAGO";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                respuesta1 = null;
            }
            }
        });
    }


}
