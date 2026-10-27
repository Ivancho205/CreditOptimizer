package com.creditoptimizer.backend_creditoptimizer.presentation;
import com.creditoptimizer.backend_creditoptimizer.application.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.creditoptimizer.backend_creditoptimizer.domain.EntityUser;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

       //1

        @GetMapping("/api/users")
        public List<EntityUser> consultar(){
            return service.consultar();
        }
        //2

       @GetMapping("/api/users/{idUser}")
       public EntityUser consultarPorId(@PathVariable("idUser") int idUser) {
            Optional user = service.consultarPorId(idUser);
            if(user.isPresent()){
                return (EntityUser) user.get();
            }
            return null; 
       }

        //3
        @PostMapping("/api/users")
        public String ingresar(@RequestBody EntityUser product) {
            return service.ingresar(product);
        }

        //4
        @PutMapping("/api/users/{idUser}")
        public String modificar(@PathVariable("idUser") int idUser,@RequestBody EntityUser product){
            return service.modificar(idUser, product);
        }

        //5
        @DeleteMapping("/api/users/{idUser}")
        public String eliminar ( @PathVariable("idUser") int idUser){
            return service.eliminar(idUser);
        }
    }