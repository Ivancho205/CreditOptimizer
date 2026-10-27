package com.creditoptimizer.backend_creditoptimizer.presentation;
import com.creditoptimizer.backend_creditoptimizer.application.ChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.creditoptimizer.backend_creditoptimizer.domain.EntityChat;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ChatController {
    private final ChatService service;

    public ChatController(ChatService service) {
        this.service = service;
    }

       //1

        @GetMapping("/api/chats")
        public List<EntityChat> consultar(){
            return service.consultar();
        }
        //2

       @GetMapping("/api/chats/{idChat}")
       public EntityChat consultarPorId(@PathVariable("idChat") int idChat) {
            Optional chat = service.consultarPorId(idChat);
            if(chat.isPresent()){
                return (EntityChat) chat.get();
            }
            return null; 
       }

        //3
        @PostMapping("/api/chats")
        public String ingresar(@RequestBody EntityChat product) {
            return service.ingresar(product);
        }

        //4
        @PutMapping("/api/chats/{idChat}")
        public String modificar(@PathVariable("idChat") int idChat,@RequestBody EntityChat product){
            return service.modificar(idChat, product);
        }

        //5
        @DeleteMapping("/api/chats/{idChat}")
        public String eliminar ( @PathVariable("idChat") int idChat){
            return service.eliminar(idChat);
        }
    }