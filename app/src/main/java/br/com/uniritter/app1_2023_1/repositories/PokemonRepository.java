package br.com.uniritter.app1_2023_1.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.uniritter.app1_2023_1.models.Pokemon;

public class PokemonRepository {
    private Map<Integer, Pokemon> usersMap;

    //implementação do design Pattern Songleton
    private static PokemonRepository instance = null;


    // altera o construtor para private -> Singleton
    private PokemonRepository() {
        this.usersMap = new HashMap<>();
    }

    //implementação do Singleton
    public static PokemonRepository getInstance() {
        if (instance == null) {
            instance = new PokemonRepository();
        }
        return instance;
    }


    //inclui um obj User no Repositorio / Map
    public void addAlbum(Pokemon pokemon) {
        //falta lançar uma exceção para tratamento -> throws
        if (pokemon != null) {
            this.usersMap.put(pokemon.getId(), pokemon);
        }
    }

    // retorna se um obj Album está presento no Mapa
    public boolean contains(Pokemon pokemon) {
        return this.usersMap.containsValue(pokemon);
    }

    /*
        Nome Método:
        Parametros: nome - objetivo
        Retoro: o que deve retornar

        comportamento:

     */
    // retorna se um obj está presente no Mapa por sei id
    public boolean contains(Integer id) {
        return this.usersMap.containsKey(id);
    }

    // retorna uma Collection com todos os usuários
    public Collection<Pokemon> getAlbums() {
        return this.usersMap.values();
    }
}
