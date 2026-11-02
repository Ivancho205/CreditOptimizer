package com.creditoptimizer.backend_creditoptimizer.presentation;
import com.creditoptimizer.backend_creditoptimizer.application.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.creditoptimizer.backend_creditoptimizer.domain.EntityUser;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
       public EntityUser consultarById(@PathVariable("idUser") int idUser) {
            Optional user = service.consultarById(idUser);
            if(user.isPresent()){
                return (EntityUser) user.get();
            }
            return null; 
       }

        //3
        @PostMapping("/api/users")
        public String add(@RequestBody EntityUser product) {
            return service.add(product);
        }

        //4
        @PutMapping("/api/users/{idUser}")
        public String modify(@PathVariable("idUser") int idUser,@RequestBody EntityUser product){
            return service.modify(idUser, product);
        }

        //5
        @DeleteMapping("/api/users/{idUser}")
        public String delete ( @PathVariable("idUser") int idUser){
            return service.delete(idUser);
        }
    }