package br.com.uniritter.app1_2023_1.services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIs {
    String BASE_URL = "http://localhost:3000/";

    @GET("pokemons")
    Call<List<PokemonResult>> getPokemons();
}
