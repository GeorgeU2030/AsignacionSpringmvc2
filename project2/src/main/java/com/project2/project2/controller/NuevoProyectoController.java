package com.project2.project2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NuevoProyectoController {

    @GetMapping("/nuevo-proyecto")
    public String mostrarNuevoProyecto() {
        return "nuevo_proyecto";
    }

    @PostMapping("/nuevo-proyecto")
    public String registrarNuevoProyecto(@RequestParam String titulo, @RequestParam int cantidadAlumnos, @RequestParam String estado) {
        // Aquí puedes procesar los datos de la nueva revista
        System.out.println("Título del Proyecto: " + titulo);
        System.out.println("Cantidad de Alumnos: " + cantidadAlumnos);
        System.out.println("Estado: " + estado);

        // Redirige a la página de "Nuevo Artículo" después de registrar la revista
        return "redirect:/bienvenida/nuevo-articulo";
    }
}

