package br.com.tecgirl.calcimc;

import android.content.Intent;
import android.net.Uri;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class CalcActivity extends AppCompatActivity {

    EditText etPeso, etAltura;
    TextView tvPeso, tvAltura, tvResultado, tvMostraPesoIdeal, tvMostraStatus;
    Button btCalcular;

    double peso, altura;
    String sexo;

    CalcImc cIMC;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        cIMC = new CalcImc();

        etPeso = (EditText) findViewById(R.id.etPeso);
        etAltura = (EditText) findViewById(R.id.etAltura);

        tvPeso = (TextView) findViewById(R.id.tvPeso);
        tvAltura = (TextView) findViewById(R.id.tvAltura);

        tvResultado = (TextView) findViewById(R.id.tvResultado);
        tvMostraPesoIdeal = (TextView) findViewById(R.id.tvMostraPesoIdeal);
        tvMostraStatus = (TextView) findViewById(R.id.tvMostraStatus);

        btCalcular = (Button) findViewById(R.id.btCalcular);

        Intent intent = getIntent();

        sexo = intent.getStringExtra("sexo");

        tvMostraStatus.setText(sexo);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                peso = Double.parseDouble(etPeso.getText().toString());
                altura = Double.parseDouble(etAltura.getText().toString());

                double imc = cIMC.getImc(peso, altura);

                String status = cIMC.statusImc(imc,sexo);

                tvMostraStatus.setText(status);

                tvResultado.setText(String.valueOf(imc));

                double pesoIdeal = cIMC.getPesoIdeal(altura,imc);

                tvMostraPesoIdeal.setText(String.valueOf(pesoIdeal));



            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Calc Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
