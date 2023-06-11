package br.com.uniritter.app1_2023_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;

public class ProcurarPokemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.procuar_pokemon);

        Button Sair = findViewById(R.id.btn_sair);
        Button btBuscaTodos = findViewById(R.id.btBuscaTodos);
        Group Filtors = findViewById(R.id.Filtros);

        Sair.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        btBuscaTodos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (Filtors.getVisibility() == View.VISIBLE) {
                    Filtors.setVisibility(View.GONE);
                } else {
                    Filtors.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}
