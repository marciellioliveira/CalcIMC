package br.com.tecgirl.calcimc;

import android.content.Intent;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity {

    EditText etPeso, etAltura;
    TextView tvPeso, tvAltura,tvResultado, tvPesoIdeal,tvMostraPesoIdeal;
    Button btCalcular;

    double peso, altura;
    String sexo;

    CalcImc cIMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        cIMC = new CalcImc();

        etPeso = (EditText) findViewById(R.id.etPeso);
        etAltura = (EditText) findViewById(R.id.etAltura);

        tvPeso = (TextView) findViewById(R.id.tvPeso);
        tvAltura = (TextView) findViewById(R.id.tvAltura);

        btCalcular = (Button) findViewById(R.id.btCalcular);

        peso = Double.parseDouble(etPeso.getText().toString());
        altura = Double.parseDouble(etAltura.getText().toString());

        Intent intent = getIntent();

        sexo = intent.getStringExtra("sexo");

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double imc = cIMC.getImc(peso, altura);

                String status = cIMC.statusImc(imc, sexo);

                tvResultado.setText(String.valueOf(imc));

                double pesoIdeal = cIMC.getPesoIdeal(altura, imc);

                tvMostraPesoIdeal.setText(String.valueOf(pesoIdeal));



            }
        });
    }
}
