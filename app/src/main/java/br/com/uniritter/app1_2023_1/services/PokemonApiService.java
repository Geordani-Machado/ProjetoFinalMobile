package br.com.uniritter.app1_2023_1.services;

import br.com.uniritter.app1_2023_1.models.Pokemon;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PokemonApiService {
    @GET("pokemon")
    Call<Pokemon> getPokemon();
}
