package arey.es.tema2_hoja8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


public class BroadcastReceiver1Ej1 extends BroadcastReceiver {

    public static final String TAG = "BroadcastReceiver1";

    public BroadcastReceiver1Ej1() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String result = intent.getBooleanExtra("state", false) ? "Estado activado" : "Estado desactivado";
        Log.i(TAG, result);

    }
}
