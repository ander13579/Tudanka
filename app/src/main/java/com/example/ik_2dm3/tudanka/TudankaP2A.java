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

public class TudankaP2A extends AppCompatActivity {
    private static final String IDIOMA = "idioma";

    TextView p21, p22;

    private MediaPlayer reproductor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent Lenguaje = getIntent();
        final String LENG;
        LENG =Lenguaje.getStringExtra(IDIOMA);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tudanka_p2a);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button =  findViewById(R.id.button);
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



        if(LENG.equals("Castellano")){


            p21 = (TextView) findViewById(R.id.p2atexto1);

            p21.setText( R.string.caa2texto1);

            p22 = (TextView) findViewById(R.id.p2atexto2);

            p22.setText( R.string.caa2texto2);

            reproductor = MediaPlayer.create(this, R.raw.cap2a);

        } else{
            reproductor = MediaPlayer.create(this,R.raw.eup2a);

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
