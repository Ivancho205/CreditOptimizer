package com.creditoptimizer.backend_creditoptimizer.presentation;
import com.creditoptimizer.backend_creditoptimizer.application.Libreriaservice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.creditoptimizer.backend_creditoptimizer.domain.Entitycreditoptimizer;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HolaController {
    private final Libreriaservice service;

    public HolaController(Libreriaservice service) {
        this.service = service;
    }

        //1
        @GetMapping("/")
        public Map<String, String> inicio () {
            Map<String, String> respuesta = new HashMap<>();
            respuesta.put("mensaje", "API CreditOptimizer IUPB funcionando");
            return respuesta;
        }
        //2

        @GetMapping("/api/librerias")
        public List<Entitycreditoptimizer> consultar(){
            return service.consultar();
        }
        //3

       @GetMapping("/api/librerias/{idLibreria}")
       public Entitycreditoptimizer consultarPorId(@PathVariable("idLibreria") int idLibreria) {
        return service.consultarPorId(idLibreria);
       }

        //4
        @PostMapping("/api/librerias")
        public String ingresar(@RequestBody Entitycreditoptimizer libreria) {
            return service.ingresar(libreria);
        }

        @PutMapping("/api/librerias/{idLibreria}")
        public String modificar(@PathVariable("idLibreria") int idLibreria,@RequestBody Entitycreditoptimizer libreria){
            return service.modificar(idLibreria, libreria);
        }

        @DeleteMapping("/api/librerias/{idLibreria}")
        public String eliminar ( @PathVariable("idLibreria") int idLibreria){
            return service.eliminar(idLibreria);
        }
    }