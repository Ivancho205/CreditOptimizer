package com.creditoptimizer.backend_creditoptimizer.application;
import com.creditoptimizer.backend_creditoptimizer.domain.EntityChat;
import com.creditoptimizer.backend_creditoptimizer.domain.EntitySuggestion;
import com.creditoptimizer.backend_creditoptimizer.domain.EntityUser;
import com.fasterxml.jackson.annotation.JsonTypeInfo.None;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class SuggestionService {

    private List<EntitySuggestion> suggestionList;

    public SuggestionService() {
        suggestionList = new ArrayList<>();

        // users
        EntityUser user1 = new EntityUser(1, "Ada", "nos@gmail.com", "administrator", "qwerty");
        EntityUser user2 = new EntityUser(2, "Bdan", "nos2@gmail.com", "user", "qwerty");
 
   
        // chats
        EntityChat chat2 = new EntityChat(2, "Chat2", "Fast", user1);
        EntityChat chat3 = new EntityChat(3, "Chat3", "Analytic", user2);


        // suggestions
        EntitySuggestion suggestion1 = new EntitySuggestion(1, LocalDate.now(), "Answer", chat3);
        EntitySuggestion suggestion2 = new EntitySuggestion(2, LocalDate.now(), "Answer2", chat3);
        EntitySuggestion suggestion3 = new EntitySuggestion(3, LocalDate.now(), "Answer3", chat2);
        EntitySuggestion suggestion4 = new EntitySuggestion(4, LocalDate.now(), "Answer4", chat3);
        EntitySuggestion suggestion5 = new EntitySuggestion(5, LocalDate.now(), "Answer5", chat3);

        suggestionList.addAll(Arrays.asList(suggestion1, suggestion2, suggestion3, suggestion4, suggestion5));

    }


    public List<EntitySuggestion> consultar() {
        return suggestionList;
    }
    public Optional<EntitySuggestion> consultarPorId(int idSuggestion) {
        Optional optional = Optional.empty();
        for (EntitySuggestion suggestion: suggestionList) {
            if(idSuggestion == suggestion.id()){
                optional = Optional.of(suggestion);
                return optional;
            }
        }
        return optional;
    }
    public String ingresar(EntitySuggestion suggestion) {
        suggestionList.add(suggestion);
        return "Ingresado con éxito";
    }

    public String modificar(int idSuggestion, EntitySuggestion suggestion) {
        suggestionList =
        suggestionList.stream().map(item->item.id() == suggestion.id() ? suggestion : item).toList();
        return "Modificado con éxito el ID: " + idSuggestion;
    }
    public String eliminar(int idSuggestion) {
        suggestionList =
        suggestionList.stream().map(item->item.id() == idSuggestion ? null : item).toList();
        return "Eliminado con éxito el ID: " + idSuggestion;
    }
}
