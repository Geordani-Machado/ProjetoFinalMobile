package br.com.uniritter.app1_2023_1.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.uniritter.app1_2023_1.models.Albums;

public class HabilidadesRepository {
    private Map<Integer, Albums> usersMap;

    //implementação do design Pattern Songleton
    private static HabilidadesRepository instance = null;


    // altera o construtor para private -> Singleton
    private HabilidadesRepository() {
        this.usersMap = new HashMap<>();
    }

    //implementação do Singleton
    public static HabilidadesRepository getInstance() {
        if (instance == null) {
            instance = new HabilidadesRepository();
        }
        return instance;
    }


    //inclui um obj User no Repositorio / Map
    public void addAlbum(Albums albums) {
        //falta lançar uma exceção para tratamento -> throws
        if (albums != null) {
            this.usersMap.put(albums.getId(), albums);
        }
    }

    // retorna se um obj Album está presento no Mapa
    public boolean contains(Albums albums) {
        return this.usersMap.containsValue(albums);
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
    public Collection<Albums> getAlbums() {
        return this.usersMap.values();
    }
}
