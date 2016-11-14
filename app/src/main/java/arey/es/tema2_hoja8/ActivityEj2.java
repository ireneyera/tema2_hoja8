package arey.es.tema2_hoja8;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityEj2 extends AppCompatActivity {

    private BroadcastReceiverEj2 receiverPower = new BroadcastReceiverEj2();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej2);
    }

    /**
     * Solicitamos obtener los datos cuando la Activity comienza
     */
    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter anIntentFilter = new IntentFilter();
        anIntentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        this.registerReceiver(receiverPower, anIntentFilter);
    }

    /**
     * Anulamos la subscripción cuando la Activity es pausada
     */
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiverPower);
    }


}
