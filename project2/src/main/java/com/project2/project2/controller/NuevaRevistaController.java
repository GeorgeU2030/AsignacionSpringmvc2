package com.project2.project2.controller;

import com.project2.project2.model.Revista;
import com.project2.project2.repositories.revistaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NuevaRevistaController {
    @Autowired
    private revistaRepo revistaRep;
    public NuevaRevistaController(revistaRepo revistaRep) {
        this.revistaRep = revistaRep;
    }
    @GetMapping("/nueva-revista")
    public String mostrarNuevaRevista() {
        return "nueva_revista";
    }

    @PostMapping("/nueva-revista")
    public String registrarNuevaRevista(@RequestParam String titulo, @RequestParam String isbn, @RequestParam String tipo) {
        // Aquí puedes procesar los datos de la nueva revista
        System.out.println("Título de Revista: " + titulo);
        System.out.println("ISBN: " + isbn);
        System.out.println("Tipo: " + tipo);

        Revista nuevaRevista = new Revista(titulo, isbn, tipo);
        revistaRep.insertar(nuevaRevista);
        // Redirige a la página de "Nuevo Artículo" después de registrar la revista
        return "redirect:/nuevo-articulo";
    }
}

