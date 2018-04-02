package com.example.ik_2dm3.tudanka;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.WHITE;

public class TudankaP4Aa extends AppCompatActivity {

        private static final String IDIOMA = "idioma";

        private LinearLayout cs ;
        private Mycanvas pintar;

        public Canvas dd;
        Paint paint = new Paint();



        @Override
        protected void onCreate(Bundle savedInstanceState) {

            Intent Lenguaje = getIntent();
            final String LENG;
            LENG =Lenguaje.getStringExtra(IDIOMA);

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tudanka_p4_aa);
            cs = findViewById(R.id.canvasL);


            pintar = new Mycanvas(this);


            cs.addView(pintar);

            Button borrador = findViewById(R.id.borrador);
            Button flecha = findViewById(R.id.flecha);

            borrador.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View Mycanvas) {
                    cs.clearAnimation();

                }

            });



            Button button =  findViewById(R.id.flecha);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent MainActivity = new Intent(getApplicationContext(), MainActivity.class);
                    if(LENG.equals("Castellano")){
                        MainActivity.putExtra(IDIOMA, "Castellano");}else
                        MainActivity.putExtra(IDIOMA, "Euskera");
                    startActivity(MainActivity);
                }
            });



        }




        private class Mycanvas extends View{
            private float x = 50;
            private float y = 50;
            String accion = "nada";
            Path path = new Path ();




            public Mycanvas(Context context) {
                super(context);
            }



            public void onDraw(Canvas canvas ) {

                canvas.drawColor(WHITE);

                paint.setAntiAlias(true);

                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(10);
                paint.setColor(BLACK);

                if(accion == "down"){
                    path.moveTo(x,y);
                }

                if (accion == "move"){
                    path.lineTo(x,y);
                }
                canvas.drawPath(path, paint);



            }


            public boolean onTouchEvent(MotionEvent evento) {


                int axion = evento.getAction();
                x = evento.getX();
                y = evento.getY();

                if (axion == MotionEvent.ACTION_DOWN){
                    accion = "down";
                }
                if (axion == MotionEvent.ACTION_MOVE){
                    accion = "move";
                }
                invalidate();
                return true;
            }
        }

    }

