package com.creditoptimizer.backend_creditoptimizer.presentation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class startController {

        //1
        @GetMapping("/")
        public Map<String, String> inicio () {
            Map<String, String> respuesta = new HashMap<>();
            respuesta.put("mensaje", "API CreditOptimizer IUPB funcionando");
            return respuesta;
        }
    }