package com.project2.project2.repositories;

import com.project2.project2.model.Revista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class revistaRepo {

    private static List<Revista> revistas= new ArrayList<Revista>();
    static {
        revistas.add(new Revista("Semana","2067890","IDX"));
        revistas.add(new Revista("Tecnologias","304567890","IDX"));

    }

    public static List<Revista> buscarTodos() {
        System.out.println(" ===>> "+revistas.get(0).getTitulo());
        return revistas;
    }

    public void insertar(Revista revista) {
        revistas.add(revista);
    }

    public Revista obtenerPorISBN(String isbn) {
        System.out.println(isbn);
        return revistas.stream()
                .filter(r -> r.getIsbn().equalsIgnoreCase(isbn))
                .findFirst()
                .orElse(null); // Devuelve null si no se encuentra ninguna coincidencia
    }
}
