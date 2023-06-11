package br.com.uniritter.app1_2023_1.services;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.uniritter.app1_2023_1.models.Pokemon;



public class PokemonService {

    //cria objeto User apartir de um JSON - trasendo informaçoes da api
    public static Pokemon pokemonFromJson(JSONObject json) {
        Pokemon pokemon = null;
        try {
            pokemon = new Pokemon(
                    json.getInt("id"),
                    json.getString("nome"),
                    json.getInt("idade"),
                    json.getInt("vida")
                    );

        } catch (JSONException e) {
            System.out.println("erro no Json. Fogo no parquinho "+e.getMessage());
        }
        return pokemon;
    }

    //buscar todos os users no servidor REST
    public static void getPokemonbyIDouName(String idName, Context contexto, ServiceDone callback) {

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                "https://pokeapi.co/api/v2/pokemon/" + idName + "", null,
                response -> {
                    System.out.println("recebi o retorno!");
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject json = response.getJSONObject(i);
                             //Pokemon.AddPokemon( );
                        } catch (JSONException e) {
                            System.out.println("Nenhum Pokemon encontrado com esse nome ou ID !"+e.getMessage());
                        }
                    }
                    if (callback != null) {
                        callback.onServiceDone();
                    }
                },
                error->{
                    Toast.makeText(contexto, "Ocorreu uma falha na requisição "+error.getMessage(), Toast.LENGTH_LONG).show();
                });


        RequestQueue queue = Volley.newRequestQueue(contexto);
        System.out.println("antes de ir para a queue");
        queue.add(request);
        System.out.println("depois de ir para a queue");
    }

    public static void findPokeFrend(){

    }



}
