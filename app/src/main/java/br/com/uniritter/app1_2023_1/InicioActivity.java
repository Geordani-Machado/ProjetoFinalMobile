package br.com.uniritter.app1_2023_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class InicioActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

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

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("second_login", true);
        editor.apply();

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        String isName = sharedPreferences.getString("pokemon_name","");
        String isUrl = sharedPreferences.getString("pokemon_url","");


        if(!isName.isEmpty()){
            PokemonName.setText(isName);
        }else{
            PokemonName.setText(name);
        }

        if(!isUrl.isEmpty()){
            Glide.with(this)
                    .load(isUrl)
                    .into(Image);
        }else {
            Glide.with(this)
                    .load(Url)
                    .into(Image);
        }

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                sharedPreferences = PreferenceManager.getDefaultSharedPreferences(InicioActivity.this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("second_login", false);
                editor.apply();
            }
        });

    }
}
