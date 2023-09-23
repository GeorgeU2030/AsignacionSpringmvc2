package com.project2.project2.controller;

import com.project2.project2.model.Articulo;
import com.project2.project2.model.Profesor;
import com.project2.project2.model.ProyectoTerminal;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NuevoProyectoController {

    @GetMapping("/nuevo-proyecto")
    public String mostrarNuevoProyecto(Model model) {
        ProyectoTerminal nuevoProyecto = new ProyectoTerminal();
        model.addAttribute("proyecto", nuevoProyecto);
        return "nuevo_proyecto";
    }

    @PostMapping("/nuevo-proyecto")
    public String registrarNuevoProyecto(@RequestParam String titulo, @RequestParam int cantidadAlumnos, @RequestParam String estado, HttpSession session) {
        Profesor profesorAutenticado = (Profesor) session.getAttribute("profesorAutenticado");
        System.out.println("Título del Proyecto: " + titulo);
        System.out.println("Cantidad de Alumnos: " + cantidadAlumnos);
        System.out.println("Estado: " + estado);

        ProyectoTerminal nuevoProyecto = new ProyectoTerminal();
        nuevoProyecto.setTitulo(titulo);
        nuevoProyecto.setEstado(estado);
        nuevoProyecto.setCantidadAlumnos(cantidadAlumnos);

        profesorAutenticado.getProyectosTerminales().add(nuevoProyecto);
        return "redirect:/bienvenida";
    }
}

