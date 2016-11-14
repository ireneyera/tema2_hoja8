package arey.es.tema2_hoja8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityEj4 extends AppCompatActivity {

    private BroadcastReceiverEj4 batteryBroadcastReceiver = new BroadcastReceiverEj4();

    private boolean currentlyEnabled = false;

    private Button enableButton;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej4);

        // Modificaremos el texto del botón para reflejar el estado
        enableButton = (Button)findViewById(R.id.enableReceiver);

        resultado = (TextView)findViewById(R.id.resultadoEj4TextView);
    }


    /**
     * Independientemente de que se haya pulsado, deshabilitamos al salir de la activity
     */
    @Override
    protected void onStop() {
        super.onStop();
        if (currentlyEnabled) {
            unregisterReceiver(batteryBroadcastReceiver);
        }
    }

    public void enableDisable(View v) {
        if (currentlyEnabled) {
            unregisterReceiver(batteryBroadcastReceiver);
            currentlyEnabled = false;
            enableButton.setText("Habilitar");
        } else {
            IntentFilter anIntentFilter = new IntentFilter();
            // Debemos verificar dos acciones: que se conecte a la carga y se desconecte
            anIntentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            anIntentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
            registerReceiver(batteryBroadcastReceiver, anIntentFilter);
            currentlyEnabled = true;
            enableButton.setText("Deshabilitar");
        }
    }

    private class BroadcastReceiverEj4 extends BroadcastReceiver {

        // Incluimos en "resultado" si se está cargando o no el dispositivo
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().toString().equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                resultado.setText("El dispositivo se está cargando");
            } else if (intent.getAction().toString().equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                resultado.setText("El dispositivo se ha desenchufado");
            }
        }
    }
}
