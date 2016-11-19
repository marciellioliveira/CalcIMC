package br.com.tecgirl.calcimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton imgDmulher, imgDhomem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgDmulher = (ImageButton) findViewById(R.id.imgDmulher);
        imgDhomem = (ImageButton) findViewById(R.id.imgDhomem);

        imgDmulher.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,CalcActivity.class);
                intent.putExtra("sexo", "feminino");
                startActivity(intent);
            }
        });

        imgDhomem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,CalcActivity.class);
                intent.putExtra("sexo", "masculino");
                startActivity(intent);
            }
        });

        }
    }
}
