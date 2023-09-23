package com.project2.project2.controller;

import com.project2.project2.model.Revista;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NuevoArticuloController {

    @GetMapping("/nuevo-articulo")
    public String mostrarNuevoArticulo(Model model) {
        // Aquí puedes cargar las revistas generadas a nivel de código y pasarlas al modelo
        List<Revista> revistas = generarRevistas();
        model.addAttribute("revistas", revistas);
        return "nuevo_articulo";
    }

    @PostMapping("/nuevo-articulo")
    public String registrarNuevoArticulo(@RequestParam String titulo, @RequestParam String revista, @RequestParam String estado) {
        // Aquí puedes procesar los datos del nuevo artículo
        System.out.println("Título: " + titulo);
        System.out.println("Revista: " + revista);
        System.out.println("Estado: " + estado);

        // Redirige nuevamente a la página de "Nuevo Artículo"
        return "redirect:/bienvenida/nuevo-articulo";
    }

    private List<Revista> generarRevistas() {
        // Aquí puedes generar las revistas a nivel de código
        List<Revista> revistas = new ArrayList<>();
        revistas.add(new Revista("R1", "ISBN1","Indexada"));
        revistas.add(new Revista("R2", "ISBN2","Indexada"));
        // Agrega más revistas según sea necesario
        return revistas;
    }
}

