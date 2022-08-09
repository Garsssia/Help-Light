package com.example.lmv2;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button onoff;
    private Button sos;
    private Button blink;

    boolean hascameraFlash = false;
    boolean flashOn = false;
    boolean issoson = false;
    boolean isblinkon = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onoff = findViewById(R.id.ram);
        // Localizamos como se llama el primer botón, del activity_main.xml, se puede ver pinchando en el y viendo el parámetro id
        sos = findViewById(R.id.ram2);
        blink = findViewById(R.id.ram3);


       // ram = findViewById(R.id.ram);
        // Lo mismo para el SOS y el blink



        onoff.setOnClickListener(this);
        sos.setOnClickListener(this);
        blink.setOnClickListener(this);


        //sam.setOnContextClickListener(this);
        //ram.setOnClickListener(this);

        // escuchamos cuando se pulsa uno de los botones y en el metodo Onclick decimos que pasa si se pulsa uno de ellos

        hascameraFlash = getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        // ahora debemos de asegurarnos que el teléfono tiene flash

        // No funcionan correctamente los botones ni los toasts de función no disponible

    }

    public void onClick(View v){

        switch (v.getId()){
            case R.id.ram:
                if(hascameraFlash){
                    if(flashOn || issoson || issoson){
                        flashLightOff();
                        flashOn = false;
                        issoson = false;
                        isblinkon = false;
                    }
                    else{
                        flashLightOn();
                        flashOn = true;

                    }
                }
                else{
                    Toast.makeText(this, "Linterna no disponible", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.ram2:
                if(hascameraFlash){
                    if(flashOn || issoson || issoson){
                        flashLightOff();
                        flashOn = false;
                        issoson = false;
                        isblinkon = false;
                    }
                    else{
                        sosOn();

                    }
                }
                else{
                    Toast.makeText(this, "Linterna no disponible", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.ram3:
                if(hascameraFlash){
                    if(flashOn || issoson || issoson){
                        flashLightOff();
                        flashOn = false;
                        issoson = false;
                        isblinkon = false;
                    }
                    else{
                        blinkOn();
                        blinkOn();
                        blinkOn();
                        blinkOn();

                        }
                }
                else{
                    Toast.makeText(this, "Linterna no disponible", Toast.LENGTH_SHORT).show();
                }
                break;



            default:
                break;

        }

    }

    private void flashLightOn() {
        CameraManager cameraManager = null; // context permite el acceso a los recursos de android
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        }

        String cameraId = null;

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                cameraId = cameraManager.getCameraIdList()[0]; // ni perra de que hace, investigar
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                cameraManager.setTorchMode(cameraId, true);
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

    }

    private void sosOn() {  // NO FUNCIONA OK
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        String cameraId = null;
        try {
            cameraId = cameraManager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                cameraManager.setTorchMode(cameraId, true);
                Thread.sleep(250);
                cameraManager.setTorchMode(cameraId, false);
                Thread.sleep(250);
                cameraManager.setTorchMode(cameraId, true);
                Thread.sleep(250);
                cameraManager.setTorchMode(cameraId, false);
                Thread.sleep(250);
                cameraManager.setTorchMode(cameraId, true);
                Thread.sleep(250);
                cameraManager.setTorchMode(cameraId, false);
                Thread.sleep(250);
                // S
                cameraManager.setTorchMode(cameraId, true);
                Thread.sleep(750);
                cameraManager.setTorchMode(cameraId, false);
                Thread.sleep(250);
                cameraManager.setTorchMode(cameraId, true);
                Thread.sleep(750);
                cameraManager.setTorchMode(cameraId, false);
                Thread.sleep(250);
                cameraManager.setTorchMode(cameraId, true);
                Thread.sleep(750);
                cameraManager.setTorchMode(cameraId, false);
                Thread.sleep(250);
                // O
                cameraManager.setTorchMode(cameraId, true);
                Thread.sleep(250);
                cameraManager.setTorchMode(cameraId, false);
                Thread.sleep(250);
                cameraManager.setTorchMode(cameraId, true);
                Thread.sleep(250);
                cameraManager.setTorchMode(cameraId, false);
                Thread.sleep(250);
                cameraManager.setTorchMode(cameraId, true);
                Thread.sleep(250);
                cameraManager.setTorchMode(cameraId, false);
                Thread.sleep(250);
                // S
                cameraManager.setTorchMode(cameraId, false);
                // endword
                Thread.sleep(1750);

            }
        } catch (CameraAccessException | InterruptedException e) {
            e.printStackTrace();
        }
        Toast.makeText(MainActivity.this, "SOS Emitido", Toast.LENGTH_LONG).show();

    }

    private void flashLightOff() {
        CameraManager cameraManager = null; // context permite el acceso a los recursos de android
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        }

        String cameraId = null;

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                cameraId = cameraManager.getCameraIdList()[0]; // ni perra de que hace, investigar
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                cameraManager.setTorchMode(cameraId, false);
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

    }

    private void blinkOn() {
        CameraManager cameraManager = null; // context permite el acceso a los recursos de android
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        }

        String cameraId = null;

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                cameraId = cameraManager.getCameraIdList()[0]; // ni perra de que hace, investigar
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

        try {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                cameraManager.setTorchMode(cameraId, true);
                Thread.sleep(750);
                cameraManager.setTorchMode(cameraId, false);
                Thread.sleep(250);
                cameraManager.setTorchMode(cameraId, true);
                Thread.sleep(750);
                cameraManager.setTorchMode(cameraId, false);
                Thread.sleep(250);

            }
        } catch (CameraAccessException | InterruptedException e) {
            e.printStackTrace();
        }


    }


    private void featurenotdeveloped() {
        Toast.makeText(MainActivity.this, "No disponible", Toast.LENGTH_LONG).show();  // imprime por pantalla que no está lista
    }
}
