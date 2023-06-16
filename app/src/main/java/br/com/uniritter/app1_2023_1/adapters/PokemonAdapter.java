package br.com.uniritter.app1_2023_1.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import br.com.uniritter.app1_2023_1.R;
import br.com.uniritter.app1_2023_1.models.Pokemon;
import br.com.uniritter.app1_2023_1.services.PokemonResult;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.MyViewHolder> {
    private Context context;

    private List<PokemonResult> listaPokemons;

    public PokemonAdapter(List<PokemonResult> lista){
        this.listaPokemons = lista;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.procuar_pokemon_card, parent, false);
        return new MyViewHolder(itemLista);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        PokemonResult pokemon = listaPokemons.get(position);
        holder.PokemonName.setText(pokemon.getNome());


        Glide.with(holder.PokemonImg)
                .load(pokemon.getUrl())
                .into(holder.PokemonImg);


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
