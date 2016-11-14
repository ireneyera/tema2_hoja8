package arey.es.tema2_hoja8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityEj3 extends AppCompatActivity {

    private TextView batteryLevel;
    private ImageView batteryIcon;
    private BroadcastReceiverEj3 batteryBR = new BroadcastReceiverEj3();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej3);

        batteryLevel = (TextView)findViewById(R.id.batteryLevelTextView);
        batteryIcon = (ImageView)findViewById(R.id.batteryIconimageView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter anIntentFilter = new IntentFilter();
        anIntentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        this.registerReceiver(batteryBR, anIntentFilter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(batteryBR);
    }

    /** En la clase BatteryManager se obtienen los Extras definidos para ACTION_BATTERY_CHANGED
     *
     */
    private class BroadcastReceiverEj3 extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            batteryLevel.setText("El nivel de la batería es " + level);
            batteryIcon.setImageResource(intent.getIntExtra(BatteryManager.EXTRA_ICON_SMALL,0));
        }
    }
}
