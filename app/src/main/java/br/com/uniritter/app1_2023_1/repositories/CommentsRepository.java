package br.com.uniritter.app1_2023_1.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.uniritter.app1_2023_1.models.Comments;

public class CommentsRepository {
    private Map<Integer, Comments> usersMap;

    //implementação do design Pattern Songleton
    private static CommentsRepository instance = null;


    // altera o construtor para private -> Singleton
    private CommentsRepository() {
        this.usersMap = new HashMap<>();
    }

    //implementação do Singleton
    public static CommentsRepository getInstance() {
        if (instance == null) {
            instance = new CommentsRepository();
        }
        return instance;
    }


    //inclui um obj User no Repositorio / Map
    public void addComments(Comments comments) {
        //falta lançar uma exceção para tratamento -> throws
        if (comments != null) {
            this.usersMap.put(comments.getId(), comments);
        }
    }

    // retorna se um obj Album está presento no Mapa
    public boolean contains(Comments albums) {
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
    public Collection<Comments> getAlbums() {
        return this.usersMap.values();
    }
}
