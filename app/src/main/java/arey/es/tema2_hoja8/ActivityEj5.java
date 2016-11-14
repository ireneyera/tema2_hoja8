package arey.es.tema2_hoja8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityEj5 extends AppCompatActivity {

    public static final String NUMBER = "NUMBER";
    private TextView incomingNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej5);

        incomingNumber = (TextView)findViewById(R.id.incomingCallTextView);

        Intent receivedIntent = getIntent();
        incomingNumber.setText("Está llamando el número de teléfono: " + receivedIntent.getStringExtra(NUMBER));
    }
}
