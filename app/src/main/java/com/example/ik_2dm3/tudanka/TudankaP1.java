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

public class TudankaP1 extends AppCompatActivity {

    private static final String IDIOMA = "idioma";

    TextView p1, p2;

    private MediaPlayer reproductor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent Lenguaje = getIntent();
        final String LENG;
        LENG =Lenguaje.getStringExtra(IDIOMA);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tudanka_p1);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button =  findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent TudankaP1A = new Intent(getApplicationContext(), TudankaP1A.class);
                if(LENG.equals("Castellano")){
                    TudankaP1A.putExtra(IDIOMA, "Castellano");}else
                    TudankaP1A.putExtra(IDIOMA, "Euskera");
                startActivity(TudankaP1A);
            }
        });



        if(LENG.equals("Castellano")){

            p1 = (TextView) findViewById(R.id.p1titulo);

            p1.setText( R.string.cap1titulo);

            p2 = (TextView) findViewById(R.id.p1texto);

            p2.setText( R.string.cap1texto);

            reproductor = MediaPlayer.create(this, R.raw.cap1);
        } else {
            reproductor = MediaPlayer.create(this,R.raw.eup1);
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
