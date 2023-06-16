package br.com.uniritter.app1_2023_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.uniritter.app1_2023_1.adapters.Pokemon;
import br.com.uniritter.app1_2023_1.adapters.PokemonAdapter;

public class ProcurarPokemonActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Pokemon> PokemonLista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.procuar_pokemon);

        Button Sair = findViewById(R.id.btn_sair);
        Button btBuscaTodos = findViewById(R.id.btBuscaTodos);
        Group Filtors = findViewById(R.id.Filtros);
        Button Proximo = findViewById(R.id.btn_proximo);

        recyclerView = findViewById(R.id.PokemonRV);

        //configuração do adapte
        PokemonAdapter Pokemon = new PokemonAdapter(PokemonLista);

        //chamarLista
        this.CriarPokemonList();

        //configurar o recyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        //recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(Pokemon);

        Proximo.setOnClickListener(new View.OnClickListener(){
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

    public void CriarPokemonList(){
        Pokemon pokemon = new Pokemon("Charmander","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/1.gif");
        this.PokemonLista.add(pokemon);

        pokemon = new Pokemon("Pikachu","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/25.gif");
        this.PokemonLista.add(pokemon);
    }

}
