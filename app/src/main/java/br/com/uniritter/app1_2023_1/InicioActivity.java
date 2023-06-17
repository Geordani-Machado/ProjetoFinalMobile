package br.com.uniritter.app1_2023_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class InicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);

        ImageView Image = findViewById(R.id.PokemonImg);
        Button btnSair = findViewById(R.id.btn_sair);

        TextView PokemonName = findViewById(R.id.PokemonName);


        String name = getIntent().getStringExtra("Name");
        String Url = getIntent().getStringExtra("Url");

        PokemonName.setText(name);

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });


        Glide.with(this)
                .load(Url)
                .into(Image);


    }
}
