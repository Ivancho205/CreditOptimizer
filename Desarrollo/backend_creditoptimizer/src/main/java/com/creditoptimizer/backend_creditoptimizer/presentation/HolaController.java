package com.creditoptimizer.backend_creditoptimizer.presentation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {
    @GetMapping("/hola")
    public String saludo() {
        return "¡Hola mauro como vamos! nuestro servidor de Java esta melo";
    }
}
