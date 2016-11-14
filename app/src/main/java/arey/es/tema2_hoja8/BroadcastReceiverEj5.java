package arey.es.tema2_hoja8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

public class BroadcastReceiverEj5 extends BroadcastReceiver {

    public static final String TAG = "BroadcastReceiver5";
    public BroadcastReceiverEj5() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
       // El "EXTRA_INCOMING_NUMBER" contiene el número de teléfono que nos está llamando
        String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
        Log.i(TAG, "Está llamando el número de teléfono " + incomingNumber);

        // Creamos un intent nuevo para ejecutar la nueva activity, y la llamamos
        // Utilizamos el "context" recibido para hacer la llamada
        Intent anIntent = new Intent(context, ActivityEj5.class);
        anIntent.putExtra(ActivityEj5.NUMBER, incomingNumber);
        // Debemos indicar de forma explícita que queremos que Android cree una nueva activity.
        anIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(anIntent);

    }
}
