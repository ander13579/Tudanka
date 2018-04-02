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

public class TudankaP3 extends AppCompatActivity {
    private static final String IDIOMA = "idioma";

    TextView p31, p32, p33, p34;

    private MediaPlayer reproductor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent Lenguaje = getIntent();
        final String LENG;
        LENG =Lenguaje.getStringExtra(IDIOMA);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tudanka_p3);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button =  findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent TudankaP3A = new Intent(getApplicationContext(), TudankaP3A.class);
                if(LENG.equals("Castellano")){
                    TudankaP3A.putExtra(IDIOMA, "Castellano");}else
                    TudankaP3A.putExtra(IDIOMA, "Euskera");
                startActivity(TudankaP3A);
            }
        });



        if(LENG.equals("Castellano")){


            p31 = (TextView) findViewById(R.id.p3titulo);

            p31.setText( R.string.cap3titulo);

            p32 = (TextView) findViewById(R.id.p3texto1);

            p32.setText( R.string.cap3texto1);

            p33 = (TextView) findViewById(R.id.p3texto2);

            p33.setText( R.string.cap3texto2);

            p34 = (TextView) findViewById(R.id.p3texto3);

            //p34.setText(R.string.);

            reproductor = MediaPlayer.create(this,R.raw.cap3);

        } else{
            reproductor = MediaPlayer.create(this,R.raw.eup3);
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
