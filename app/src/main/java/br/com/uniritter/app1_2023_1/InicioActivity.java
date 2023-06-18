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

import br.com.uniritter.app1_2023_1.models.Pokemon;
import br.com.uniritter.app1_2023_1.services.PokemonApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InicioActivity extends AppCompatActivity {

    private void saveData(String id, String nome, int idade, int vida, String img){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://seu-servidor.com/") // Substitua pela URL do seu servidor
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokemonApiService apiService = retrofit.create(PokemonApiService.class);

        Pokemon pokemon = new Pokemon(nome, img, idade,vida);

        Call<Void> call = apiService.savePokemon(pokemon);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    // Dados salvos com sucesso
                } else {
                    // Tratar erro de requisição
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // Tratar erro de conexão
            }
        });
    }


    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);

        ImageView Image = findViewById(R.id.PokemonImg);
        Button btnSair = findViewById(R.id.btn_sair);

        TextView PokemonName = findViewById(R.id.PokemonName);
        TextView PokemonLevel = findViewById(R.id.Pokemon_Level);
        TextView PokemonVida = findViewById(R.id.Pokemon_vida);


        String name = getIntent().getStringExtra("Name");
        String Url = getIntent().getStringExtra("Url");
        String vida = getIntent().getStringExtra("Vida");
        String level = getIntent().getStringExtra("level");

        //Item em tela - Botoes de ação para brincar e alimentar o pokemon
        ImageView bola = findViewById(R.id.Item_bola);
        ImageView bala = findViewById(R.id.Item_bala);
        ImageView tiglela = findViewById(R.id.Item_tigela);

        PokemonName.setText(name);
        PokemonLevel.setText(level);
        PokemonVida.setText(vida);

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

        //criando evento para quando o usuario clica no item para alimentar ou brincar com o pokemon
        bola.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });

        bala.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });

        tiglela.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });


    }
}
