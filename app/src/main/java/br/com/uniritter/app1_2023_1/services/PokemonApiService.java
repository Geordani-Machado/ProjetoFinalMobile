package br.com.uniritter.app1_2023_1.services;

import java.util.List;

import br.com.uniritter.app1_2023_1.models.Pokemon;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PokemonApiService {
    @GET("pokemons")
    Call<List<PokemonResult>> getPokemon();

    @POST("pokemon") // Substitua pelo endpoint adequado no seu servidor
    Call<Void> savePokemon(@Body Pokemon pokemon);

}
