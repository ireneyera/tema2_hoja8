package arey.es.tema2_hoja8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;

public class BroadcastReceiverEj2 extends BroadcastReceiver {

    public static final String TAG = "BATTERYLEVEL";
    public BroadcastReceiverEj2() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
        Log.i(TAG, "El nivel de la batería es " + level);
    }
}
