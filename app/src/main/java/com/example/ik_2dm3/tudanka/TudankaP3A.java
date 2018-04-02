package com.example.ik_2dm3.tudanka;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TudankaP3A extends AppCompatActivity {
    private static final String IDIOMA = "idioma";


    private Button img1;
    private Button img2;
    private Button img3;
    private Button img4;
    private Button corregir;
    private Button zuzendu;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;

    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    ImageView image5;
    ImageView image6;
    ImageView image7;

    ImageView imag1;
    ImageView imag2;
    ImageView imag3;
    ImageView imag4;
    ImageView imag5;
    ImageView imag6;
    ImageView imag7;


    private String opcion1;
    private String opcion2;
    private String opcion3;
    private String opcion4;


    private String memoria = "";

    public boolean siguiente = false;


    public boolean valorSeleccionado= false; //variable para saber el ultimo valor escogido

    private MediaPlayer reproductor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent Lenguaje = getIntent();
        final String LENG;
        LENG =Lenguaje.getStringExtra(IDIOMA);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tudanka_p3a);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if(LENG.equals("Castellano")){
            iniciarCartas();
            agregarEventosCartas();

            corregir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if(btn2.getText() == opcion2 && btn3.getText() == opcion3 && btn4.getText() == opcion1 && btn5.getText() == opcion4){

                        Context context = getApplicationContext();
                        CharSequence text = "MUY BIEN!!";
                        int duration = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        siguiente = true;

                        corregir.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent TudankaP4 = new Intent(getApplicationContext(), MainActivity.class);
                                if (LENG.equals("Castellano")) {
                                    TudankaP4.putExtra(IDIOMA, "Castellano");
                                } else
                                    TudankaP4.putExtra(IDIOMA, "Euskera");
                                startActivity(TudankaP4);
                            }
                        });


                    } else {
                        memoria = "";
                        btn2.setText(memoria);
                        btn3.setText(memoria);
                        btn4.setText(memoria);
                        btn5.setText(memoria);

                        Context context = getApplicationContext();
                        CharSequence text = "MAL VUELVE A INTENTARLO";
                        int duration = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        siguiente = false;
                    }

                }
            });

           // reproductor = MediaPlayer.create(this,R.raw.);

        } else {
            iniciarCartasEuskera();
            agregarEventosCartasEuskera();
            zuzendu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(btn2.getText() == opcion2 && btn3.getText() == opcion3 && btn4.getText() == opcion1 && btn5.getText() == opcion4){

                        Context context = getApplicationContext();
                        CharSequence text = "OSO ONDO!!";
                        int duration = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        siguiente = true;
                        zuzendu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent MainActivity = new Intent(getApplicationContext(), MainActivity.class);
                                if (LENG.equals("Castellano")) {
                                    MainActivity.putExtra(IDIOMA, "Castellano");
                                } else
                                    MainActivity.putExtra(IDIOMA, "Euskera");
                                startActivity(MainActivity);
                            }
                        });

                    } else {
                        memoria = "";
                        btn2.setText(memoria);
                        btn3.setText(memoria);
                        btn4.setText(memoria);
                        btn5.setText(memoria);

                        Context context = getApplicationContext();
                        CharSequence text = "TXARTO DAGO";
                        int duration = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        siguiente = false;

                    }

                }
            });

         //   reproductor = MediaPlayer.create(this,R.raw.eup3a);

        }

      //  reproductor.setLooping(false);
      //  reproductor.start();
    }
    private void iniciarCartas(){

        img1 = findViewById(R.id.img1);
        img1.setText("AGENTE DE 1º GRADO");
        img2 = findViewById(R.id.img2);
        img2.setText("PROYECTO DE NORMALIZACION");
        img3 = findViewById(R.id.img3);
        img3.setText("ECONOMISTA");
        img4 = findViewById(R.id.img4);
        img4.setText("ALCALDE");
        corregir = findViewById(R.id.boton);
        corregir.setText("CORREGIR");
        btn2 = findViewById(R.id.btn2);
        //  btn2.setText("AGENTE DE 1º GRADO");
        btn3 = findViewById(R.id.btn3);
        // btn3.setText("PROYECTO DE NORMALIZACION");
        btn4 = findViewById(R.id.btn4);
        // btn4.setText("ECONOMISTA");
        btn5 = findViewById(R.id.btn5);
        //btn5.setText("ALCALDE");
        imag1 = findViewById(R.id.tw1);
        imag1.setImageResource(R.drawable.imag1);
        imag2 = findViewById(R.id.tw2);
        imag2.setImageResource(R.drawable.imag2);
        imag3 = findViewById(R.id.tw3);
        imag3.setImageResource(R.drawable.imag3);
        imag4 = findViewById(R.id.tw4);
        imag4.setImageResource(R.drawable.imag4);
        imag5 = findViewById(R.id.tw5);
        imag5.setImageResource(R.drawable.imag5);
        imag6 = findViewById(R.id.tw6);
        imag6.setImageResource(R.drawable.imag6);
        imag7 = findViewById(R.id.tw7);
        imag7.setImageResource(R.drawable.imag7);

        opcion1 = "AGENTE DE 1º GRADO";
        opcion2 = "PROYECTO DE NORMALIZACION";
        opcion3 = "ECONOMISTA";
        opcion4 = "ALCALDE";
    }

    private void agregarEventosCartas() {
            img1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    memoria = opcion1;

                    valorSeleccionado = true;

                }
            });

            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    memoria = opcion2;

                    valorSeleccionado = true;
                }
            });

            img3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    memoria = opcion3;

                    valorSeleccionado = true;
                }
            });

            img4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    memoria = opcion4;

                    valorSeleccionado = true;

                }
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btn2.setText(memoria);
                    valorSeleccionado = false;

                }
            });

            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btn3.setText(memoria);
                    valorSeleccionado = false;
                }
            });

            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btn4.setText(memoria);
                    valorSeleccionado = false;
                }
            });

            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btn5.setText(memoria);

                    valorSeleccionado = false;
                }
            });

    }


    private void iniciarCartasEuskera() {

        //carga todas las vistas a la clase para manejar
        img1 = findViewById(R.id.img1);
        img1.setText("1. MAILAKO AGENTEA");
        img2 = findViewById(R.id.img2);
        img2.setText("EUSKARAREN NORMALKUNTZA");
        img3 = findViewById(R.id.img3);
        img3.setText("EKONOMILARIA");
        img4 = findViewById(R.id.img4);
        img4.setText("ALKATEA");
        zuzendu = findViewById(R.id.boton);
        zuzendu.setText("ZUZENDU");
        btn2 = findViewById(R.id.btn2);
       // btn2.setText("1. MAILAKO AGENTEA");
        btn3 = findViewById(R.id.btn3);
       // btn3.setText("EUSKARAREN NORMALKUNTZA");
        btn4 = findViewById(R.id.btn4);
       // btn4.setText("EKONOMILARIA");
        btn5 = findViewById(R.id.btn5);
       // btn5.setText("ALKATEA");
        image1 = findViewById(R.id.tw1);
        image1.setImageResource(R.drawable.image1);
        image2 = findViewById(R.id.tw2);
        image2.setImageResource(R.drawable.image2);
        image3 = findViewById(R.id.tw3);
        image3.setImageResource(R.drawable.image3);
        image4 = findViewById(R.id.tw4);
        image4.setImageResource(R.drawable.image4);
        image5 = findViewById(R.id.tw5);
        image5.setImageResource(R.drawable.image5);
        image6 = findViewById(R.id.tw6);
        image6.setImageResource(R.drawable.image6);
        image7 = findViewById(R.id.tw7);
        image7.setImageResource(R.drawable.image7);

        opcion1 = "1. MAILAKO AGENTEA";
        opcion2 = "EUSKARAREN NORMALKUNTZA";
        opcion3 = "EKONOMILARIA";
        opcion4 = "ALKATEA";

    }



    private void agregarEventosCartasEuskera() {
            img1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    memoria = opcion1;

                    valorSeleccionado = true;

                }
            });

            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    memoria = opcion2;

                    valorSeleccionado = true;
                }
            });

            img3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    memoria = opcion3;

                    valorSeleccionado = true;
                }
            });

            img4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    memoria = opcion4;

                    valorSeleccionado = true;

                }
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btn2.setText(memoria);
                    valorSeleccionado = false;

                }
            });

            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btn3.setText(memoria);
                    valorSeleccionado = false;
                }
            });

            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btn4.setText(memoria);
                    valorSeleccionado = false;
                }
            });

            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btn5.setText(memoria);

                    valorSeleccionado = false;
                }
            });

    }


}
