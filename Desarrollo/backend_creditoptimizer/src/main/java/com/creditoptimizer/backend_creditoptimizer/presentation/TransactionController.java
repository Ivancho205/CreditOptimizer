package com.creditoptimizer.backend_creditoptimizer.presentation;
import com.creditoptimizer.backend_creditoptimizer.application.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.creditoptimizer.backend_creditoptimizer.domain.EntityTransaction;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class TransactionController {
    private final TransactionService service;

    public TransactionController(TransactionService service) {
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

        @GetMapping("/api/products")
        public List<EntityTransaction> consultar(){
            return service.consultar();
        }
        //3

       @GetMapping("/api/products/{idProduct}")
       public EntityTransaction consultarPorId(@PathVariable("idProduct") int idProduct) {
            Optional transaction = service.consultarPorId(idProduct);
            if(transaction.isPresent()){
                return (EntityTransaction) transaction.get();
            }
            return null; 
       }

        //4
        @PostMapping("/api/products")
        public String ingresar(@RequestBody EntityTransaction product) {
            return service.ingresar(product);
        }

        @PutMapping("/api/products/{idProduct}")
        public String modificar(@PathVariable("idProduct") int idProduct,@RequestBody EntityTransaction product){
            return service.modificar(idProduct, product);
        }

        @DeleteMapping("/api/products/{idProduct}")
        public String eliminar ( @PathVariable("idProduct") int idProduct){
            return service.eliminar(idProduct);
        }
    }