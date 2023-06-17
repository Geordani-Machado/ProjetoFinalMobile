package br.com.uniritter.app1_2023_1.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import br.com.uniritter.app1_2023_1.InicioActivity;
import br.com.uniritter.app1_2023_1.ProcurarPokemonActivity;
import br.com.uniritter.app1_2023_1.R;
import br.com.uniritter.app1_2023_1.models.Pokemon;
import br.com.uniritter.app1_2023_1.services.PokemonResult;
import android.app.Activity;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.MyViewHolder> {

    private SharedPreferences sharedPreferences;
    private Context context;


    private List<PokemonResult> listaPokemons;

    public PokemonAdapter(List<PokemonResult> lista, SharedPreferences sharedPreferences){

        this.listaPokemons = lista;
        this.sharedPreferences = sharedPreferences;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.procuar_pokemon_card, parent, false);
        return new MyViewHolder(itemLista);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        PokemonResult pokemon = listaPokemons.get(position);
        holder.PokemonName.setText(pokemon.getNome());


        Glide.with(holder.PokemonImg)
                .load(pokemon.getUrl())
                .into(holder.PokemonImg);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("API", "Clicou no pokemon na posição:  " + position + "/n"
                        + "Nome do pokemon: " + listaPokemons.get(position).getNome() + "/n"
                        + "Url do pokemon" + listaPokemons.get(position).getUrl() + "/n"
                );

                Intent intent = new Intent(v.getContext(), InicioActivity.class);
                intent.putExtra("Name",listaPokemons.get(position).getNome());
                intent.putExtra("Url",listaPokemons.get(position).getUrl());

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("pokemon_name", listaPokemons.get(position).getNome());
                editor.putString("pokemon_url", listaPokemons.get(position).getUrl());
                editor.apply();

                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaPokemons.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView PokemonImg;
        TextView PokemonName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            PokemonImg = itemView.findViewById(R.id.Poke_img);
            PokemonName = itemView.findViewById(R.id.Poke_name);

        }

    }
}

