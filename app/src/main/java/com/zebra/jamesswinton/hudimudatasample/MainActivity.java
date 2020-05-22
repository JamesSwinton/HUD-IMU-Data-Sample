package com.zebra.jamesswinton.hudimudatasample;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.symbol.zebrahud.ImuData;
import com.symbol.zebrahud.ZebraHud;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    // Debugging
    private static final String TAG = "MainActivity";

    // Variables
    private ZebraHud mZebraHud = App.mZebraHud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mZebraHud.onStart(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Start HUD
        if (mZebraHud != null) {
            mZebraHud.onResume(this, mZebraHudEventsListener);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mZebraHud != null) {
            mZebraHud.onPause(this);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mZebraHud.onStop(this, true);
    }

    private ZebraHud.EventListener mZebraHudEventsListener = new ZebraHud.EventListener() {
        @Override
        public void onConnected(Boolean connected) {
            Log.i(TAG, "HUD " + (connected ? "Connected" : "Disconnected"));

            // Verify Connection State
            if (connected) {
                // Start Collecting IMU Data
                mZebraHud.startImu(new ZebraHud.ImuListener() {
                    @Override
                    public void onImuData(ImuData imuData) {
                        Log.i(TAG, "Received IMU Data");

                        // Accelerometer Data
                        Log.i(TAG, "Accelerometer Data - " + String.format(Locale.UK,
                                "X: %f, Y: %f, Z: %f", imuData.getA().get(0),
                                imuData.getA().get(1), imuData.getA().get(2)));

                        // Gyroscope Data
                        Log.i(TAG, "Gyroscope Data - " + String.format(Locale.UK,
                                "X: %f, Y: %f, Z: %f", imuData.getG().get(0),
                                imuData.getG().get(1), imuData.getG().get(2)));

                        // Magnetometer Data
                        Log.i(TAG, "Magnetometer Data - " + String.format(Locale.UK,
                                "X: %f, Y: %f, Z: %f", imuData.getM().get(0),
                                imuData.getM().get(1), imuData.getM().get(2)));

                        // Quaternion Data
                        Log.i(TAG, "Quaternion Vector Data - " + String.format(Locale.UK,
                                "X: %f, Y: %f, Z: %f, W: %f",
                                imuData.getQ().get(0), imuData.getQ().get(1), imuData.getQ().get(2),
                                imuData.getQ().get(3)));

                        // Temp Data
                        Log.i(TAG, "Temp Data - " + String.format(Locale.UK,
                                "Temp: %f", imuData.getT()));
                    }
                });
            } else {
                // Stop Collecting IMU Data
                mZebraHud.stopImu();
            }
        }

        @Override
        public void onImageUpdated(byte[] bytes) {
            Log.i(TAG, "ImageUpdated");
        }

        @Override
        public void onCameraImage(Bitmap bitmap) {
            Log.i(TAG, "Image Captured");
        }
    };
}
