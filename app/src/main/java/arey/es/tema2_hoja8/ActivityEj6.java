package arey.es.tema2_hoja8;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class ActivityEj6 extends AppCompatActivity {

    public static final String ACTION = "HOLA_MUNDO";
    public static final String TAG = "ActivityEj6";
    public static final String HIDDENMESSAGE = "Hidden_Message";

    private BroadcastReceiverEj6 aBroadcastReceiver = new BroadcastReceiverEj6();
    private EditText editTextActivity6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej6);
        editTextActivity6 = (EditText)findViewById(R.id.editTextActivity6);
    }

    /**
     * Obtenemos el texto del editText, y lo enviamos via broadcast
     * @param v
     */
    public void sendHolaMundoBroadcast(View v) {
        Intent anIntent = new Intent();
        anIntent.setAction(ACTION);
        anIntent.putExtra(HIDDENMESSAGE, editTextActivity6.getText().toString());
        sendBroadcast(anIntent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter anIntentFilter = new IntentFilter();
        anIntentFilter.addAction(ACTION);
        registerReceiver(aBroadcastReceiver, anIntentFilter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(aBroadcastReceiver);
    }

    private class BroadcastReceiverEj6 extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i("TAG", "Hemos recibido el mensaje oculto " + intent.getStringExtra(HIDDENMESSAGE));

            Notification.Builder aNotificationBuilder = new Notification.Builder(context);
            aNotificationBuilder.setContentTitle("Mensaje oculto");
            aNotificationBuilder.setContentText(intent.getStringExtra(HIDDENMESSAGE));
            aNotificationBuilder.setSmallIcon(android.R.drawable.stat_notify_chat);
            Notification aNotification = aNotificationBuilder.build();
            NotificationManager aManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            aManager.notify(0, aNotification);
        }
    }
}


