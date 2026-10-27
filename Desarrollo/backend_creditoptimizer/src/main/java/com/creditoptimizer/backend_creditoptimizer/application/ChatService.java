package com.creditoptimizer.backend_creditoptimizer.application;
import com.creditoptimizer.backend_creditoptimizer.domain.EntityChat;
import com.creditoptimizer.backend_creditoptimizer.domain.EntityUser;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ChatService {

    private List<EntityChat> chatList;

    public ChatService() {
        chatList = new ArrayList<>();

        // users
        EntityUser user1 = new EntityUser(1, "Ada", "nos@gmail.com", "administrator", "qwerty");
        EntityUser user2 = new EntityUser(2, "Bdan", "nos2@gmail.com", "user", "qwerty");
 
        // Chats
        EntityChat chat1 = new EntityChat(1, "Chat1", "Analytic", user1);
        EntityChat chat2 = new EntityChat(2, "Chat2", "Fast", user1);
        EntityChat chat3 = new EntityChat(3, "Chat3", "Analytic", user2);
        EntityChat chat4 = new EntityChat(4, "Chat4", "Analytic", user1);
        EntityChat chat5 = new EntityChat(5, "Chat5", "Fast", user2);


        chatList.addAll(Arrays.asList(chat1, chat2, chat3, chat4, chat5));

    }


    public List<EntityChat> consultar() {
        return chatList;
    }
    public Optional<EntityChat> consultarPorId(int idChat) {
        Optional optional = Optional.empty();
        for (EntityChat chat: chatList) {
            if(idChat == chat.id()){
                optional = Optional.of(chat);
                return optional;
            }
        }
        return optional;
    }
    public String ingresar(EntityChat chat) {
        chatList.add(chat);
        return "Ingresado con éxito";
    }

    public String modificar(int idChat, EntityChat chat) {
        chatList =
        chatList.stream().map(item->item.id() == chat.id() ? chat : item).toList();
        return "Modificado con éxito el ID: " + idChat;
    }
    public String eliminar(int idChat) {
        chatList =
        chatList.stream().map(item->item.id() == idChat ? null : item).toList();
        return "Eliminado con éxito el ID: " + idChat;
    }
}
