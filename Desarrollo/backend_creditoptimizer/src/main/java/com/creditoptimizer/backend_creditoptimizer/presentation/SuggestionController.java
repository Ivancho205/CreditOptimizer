package com.creditoptimizer.backend_creditoptimizer.presentation;
import com.creditoptimizer.backend_creditoptimizer.application.SuggestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.creditoptimizer.backend_creditoptimizer.domain.EntitySuggestion;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SuggestionController {
    private final SuggestionService service;

    public SuggestionController(SuggestionService service) {
        this.service = service;
    }

        @GetMapping("/api/products")
        public List<EntitySuggestion> consultar(){
            return service.consultar();
        }
        //3

       @GetMapping("/api/products/{idProduct}")
       public EntitySuggestion consultarById(@PathVariable("idProduct") int idProduct) {
            Optional suggestion = service.consultarById(idProduct);
            if(suggestion.isPresent()){
                return (EntitySuggestion) suggestion.get();
            }
            return null; 
       }

        //4
        @PostMapping("/api/products")
        public String add(@RequestBody EntitySuggestion product) {
            return service.add(product);
        }

        @PutMapping("/api/products/{idProduct}")
        public String modify(@PathVariable("idProduct") int idProduct,@RequestBody EntitySuggestion product){
            return service.modify(idProduct, product);
        }

        @DeleteMapping("/api/products/{idProduct}")
        public String delete ( @PathVariable("idProduct") int idProduct){
            return service.delete(idProduct);
        }
    }