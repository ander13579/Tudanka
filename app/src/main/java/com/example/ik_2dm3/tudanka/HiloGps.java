package com.example.ik_2dm3.tudanka;


import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

public class HiloGps extends Thread {

    private GPSactivity RA;

    public HiloGps (GPSactivity RA) {

        this.RA = RA;

    }

    public void run() {



        while(this.isAlive()){

            RA.comprobar();

            int timeToBlink = 400;

            try{Thread.sleep(timeToBlink);
            }catch (Exception e) {}


        }


    }



}

