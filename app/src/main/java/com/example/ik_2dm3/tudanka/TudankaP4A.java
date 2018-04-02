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

public class TudankaP4A extends AppCompatActivity {

    private static final String IDIOMA = "idioma";

    TextView p41;

    private MediaPlayer reproductor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent Lenguaje = getIntent();
        final String LENG;
        LENG =Lenguaje.getStringExtra(IDIOMA);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tudanka_p4a);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button =  findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent TudankaP4Aa = new Intent(getApplicationContext(), TudankaP4Aa.class);
                if(LENG.equals("Castellano")){
                    TudankaP4Aa.putExtra(IDIOMA, "Castellano");}else
                    TudankaP4Aa.putExtra(IDIOMA, "Euskera");
                startActivity(TudankaP4Aa);
            }
        });



        if(LENG.equals("Castellano")){

            p41 = (TextView) findViewById(R.id.p4atexto1);

            p41.setText( R.string.caa4texto1);

            reproductor = MediaPlayer.create(this,R.raw.cap4a);

        } else{
            reproductor = MediaPlayer.create(this,R.raw.eup4a);
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
