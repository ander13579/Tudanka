package com.example.ik_2dm3.tudanka;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TudankaP2 extends AppCompatActivity {

    private static final String IDIOMA = "idioma";

    TextView p21, p22, p23, p24, p25, p26, p27;

    private MediaPlayer reproductor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent Lenguaje = getIntent();
        final String LENG;
        LENG =Lenguaje.getStringExtra(IDIOMA);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tudanka_p2);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button =  findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent TudankaP2A = new Intent(getApplicationContext(), TudankaP2A.class);
                if(LENG.equals("Castellano")){
                    TudankaP2A.putExtra(IDIOMA, "Castellano");}else
                    TudankaP2A.putExtra(IDIOMA, "Euskera");
                startActivity(TudankaP2A);
            }
        });



        if(LENG.equals("Castellano")){

            p21 = (TextView) findViewById(R.id.p2titulo);

            p21.setText( R.string.cap2titulo);

            p22 = (TextView) findViewById(R.id.p2texto1);

            p22.setText( R.string.cap2texto1);

            p23 = (TextView) findViewById(R.id.p2texto2);

            p23.setText( R.string.cap2texto2);

            p24 = (TextView) findViewById(R.id.p2texto3);

            p24.setText( R.string.cap2texto3);

            p25 = (TextView) findViewById(R.id.p2texto4);

            p25.setText(R.string.cap2texto4);

            p26 =(TextView) findViewById(R.id.p2texto5);

            p26.setText(R.string.cap2texto5);

            p27 =(TextView) findViewById(R.id.p2texto6);

            p27.setText(R.string.cap2texto6);

            reproductor = MediaPlayer.create(this,R.raw.cap2);

        } else {
            reproductor = MediaPlayer.create(this, R.raw.eup2);
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
