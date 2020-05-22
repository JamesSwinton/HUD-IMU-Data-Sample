package com.zebra.jamesswinton.hudimudatasample;

import android.app.Application;

import com.symbol.zebrahud.ZebraHud;

public class App extends Application {

    // Debugging
    private static final String TAG = "ApplicationClass";

    // Constants
    public static final ZebraHud mZebraHud = new ZebraHud();

    // Private Variables


    // Public Variables


    @Override
    public void onCreate() {
        super.onCreate();

        // Init HUD
        mZebraHud.init(this);
    }



    @Override
    public void onTerminate() {
        super.onTerminate();

        // De Init HUD
        mZebraHud.deinit(this);
    }
}
