package br.com.uniritter.app1_2023_1;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import br.com.uniritter.app1_2023_1.adapters.PokemonAdapter;
import br.com.uniritter.app1_2023_1.models.Pokemon;
import br.com.uniritter.app1_2023_1.services.PokemonApiService;
import br.com.uniritter.app1_2023_1.services.PokemonResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProcurarPokemonActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<PokemonResult> PokemonLista = new ArrayList<>();

    public static final String BASE_URL = "http://192.168.146.237:3000/";

    // Create interceptor

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.procuar_pokemon);

        Button Sair = findViewById(R.id.btn_sair);
        Button btBuscaTodos = findViewById(R.id.btBuscaTodos);
        Group Filtors = findViewById(R.id.Filtros);
        Button Proximo = findViewById(R.id.btn_proximo);

        recyclerView = findViewById(R.id.PokemonRV);

        //chamarLista
        this.CriarPokemonList();

        //configurar o recyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        //recyclerView.setHasFixedSize(true);
        //recyclerView.setAdapter(Pokemon);

        Proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), InicioActivity.class));
            }
        });

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

    public void CriarPokemonList() {


        //Criar uma instancia do Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Criar uma instância do serviço da API
        PokemonApiService apiService = retrofit.create(PokemonApiService.class);

        // Fazer a solicitação GET
        Call<List<PokemonResult>> call = apiService.getPokemon();
        call.enqueue(new Callback<List<PokemonResult>>() {

            public void onResponse(@NonNull Call<List<PokemonResult>> call, @NonNull Response<List<PokemonResult>> response) {
                if (response.isSuccessful()) {
                    List<PokemonResult> pokemonList = response.body();
                    assert pokemonList != null;
                    for (PokemonResult pokemon : pokemonList) {
                        Log.d(TAG, "Nome: " + pokemon.getNome() + ", URL: " + pokemon.getUrl());
                        PokemonResult nonsmoker = new PokemonResult(pokemon.getNome(),pokemon.getUrl());
                        PokemonLista.add(nonsmoker);
                        Log.d(TAG, "PokeLista: " + PokemonLista);
                    }
                    //configuração do adapte
                    PokemonAdapter Pokemon = new PokemonAdapter(PokemonLista);
                    recyclerView.setAdapter(Pokemon);

                } else {
                    Log.e("API", "Falha na solicitação: " + response.code());
                }
            }

            public void onFailure(@NonNull Call<List<PokemonResult>> call, @NonNull Throwable t) {
                Log.e("API", "Erro na solicitação: " + t.getMessage());
            }

        });
    }

}
