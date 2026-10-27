package com.creditoptimizer.backend_creditoptimizer.application;
import com.creditoptimizer.backend_creditoptimizer.domain.EntityUser;
import com.fasterxml.jackson.annotation.JsonTypeInfo.None;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<EntityUser> userList;

    public UserService() {
        userList = new ArrayList<>();

        EntityUser user1 = new EntityUser(1, "Ada", "nos@gmail.com", "administrator", "qwerty");
        EntityUser user2 = new EntityUser(2, "Bdan", "nos2@gmail.com", "user", "qwerty");
        EntityUser user3 = new EntityUser(3, "Cdai", "nos3@gmail.com", "user", "qwerty");
        EntityUser user4 = new EntityUser(4, "Ddani", "nos4@gmail.com", "user","qwerty");
        EntityUser user5 = new EntityUser(5, "Edanaan", "nos5@gmail.com", "user","qwerty");


        userList.addAll(Arrays.asList(user1, user2, user3, user4, user5));

    }


    public List<EntityUser> consultar() {
        return userList;
    }
    public Optional<EntityUser> consultarPorId(int idUser) {
        Optional optional = Optional.empty();
        for (EntityUser user: userList) {
            if(idUser == user.id()){
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }
    public String ingresar(EntityUser user) {
        userList.add(user);
        return "Ingresado con éxito";
    }

    public String modificar(int idUser, EntityUser user) {
        userList =
        userList.stream().map(item->item.id() == user.id() ? user : item).toList();
        return "Modificado con éxito el ID: " + idUser;
    }
    public String eliminar(int idUser) {
        userList =
        userList.stream().map(item->item.id() == idUser ? null : item).toList();
        return "Eliminado con éxito el ID: " + idUser;
    }
}
