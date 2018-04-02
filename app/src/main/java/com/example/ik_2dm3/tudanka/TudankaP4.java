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

public class TudankaP4 extends AppCompatActivity {


    private static final String IDIOMA = "idioma";

    TextView p41, p42, p43;

    private MediaPlayer reproductor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent Lenguaje = getIntent();
        final String LENG;
        LENG =Lenguaje.getStringExtra(IDIOMA);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tudanka_p4);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button =  findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent TudankaP4A = new Intent(getApplicationContext(), TudankaP4A.class);
                if(LENG.equals("Castellano")){
                    TudankaP4A.putExtra(IDIOMA, "Castellano");}else
                    TudankaP4A.putExtra(IDIOMA, "Euskera");
                startActivity(TudankaP4A);
            }
        });



        if(LENG.equals("Castellano")){

            p41 = (TextView) findViewById(R.id.p4titulo);

            p41.setText( R.string.cap4titulo);

            p42 = (TextView) findViewById(R.id.p4texto1);

            p42.setText( R.string.cap4texto1);

            p43 = (TextView) findViewById(R.id.p4texto2);

            p43.setText( R.string.cap4texto2);

            reproductor = MediaPlayer.create(this,R.raw.cap4);

        } else{
            reproductor = MediaPlayer.create(this,R.raw.eup4);
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
