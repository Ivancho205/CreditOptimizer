package com.creditoptimizer.backend_creditoptimizer.application;
import com.creditoptimizer.backend_creditoptimizer.domain.Entitycreditoptimizer;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class Libreriaservice {

    private final List<Entitycreditoptimizer> datos = new ArrayList<>();
    public List<Entitycreditoptimizer> consultar() {
        return datos;
    }
    public Entitycreditoptimizer consultarPorId(int idLibreria) {
        return new Entitycreditoptimizer(String.valueOf(idLibreria), "Librería Consultada");
    }
    public String ingresar(Entitycreditoptimizer libreria) {
        datos.add(libreria);
        return "Ingresado con éxito";
    }

    public String modificar(int idLibreria, Entitycreditoptimizer libreria) {
        return "Modificado con éxito el ID: " + idLibreria;
    }
    public String eliminar(int idLibreria) {
        return "Eliminado con éxito el ID: " + idLibreria;
    }
}
