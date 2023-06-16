package br.com.uniritter.app1_2023_1.services;

import java.util.List;

import br.com.uniritter.app1_2023_1.models.Pokemon;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PokemonApiService {
    @GET("pokemons")
    Call<List<PokemonResult>> getPokemon();
}
