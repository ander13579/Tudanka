package com.example.ik_2dm3.tudanka;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Azkena extends AppCompatActivity {


    private static final String IDIOMA = "idioma";

    TextView p51;

    private MediaPlayer reproductor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azkena);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Intent Lenguaje = getIntent();
        final String LENG;
        LENG =Lenguaje.getStringExtra(IDIOMA);


        if(LENG.equals("Castellano")){

            p51 = (TextView) findViewById(R.id.p5atexto);

            p51.setText( R.string.caa5texto);

            reproductor = MediaPlayer.create(this,R.raw.cap5a);

        } else{
            reproductor = MediaPlayer.create(this,R.raw.eup5a);
        }
        reproductor.setLooping(false);
        reproductor.start();

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(reproductor.isPlaying()){
            reproductor.stop();
            reproductor.release();
        }
        Toast.makeText(this, "onDestry", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        reproductor.start();
    }

    @Override
    protected  void onPause(){
        super.onPause();
        reproductor.pause();
    }
}