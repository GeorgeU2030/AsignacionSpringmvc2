package com.project2.project2.controller;

import com.project2.project2.model.Articulo;
import com.project2.project2.model.Profesor;
import com.project2.project2.model.ProyectoTerminal;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BienvenidaController {


    @GetMapping("/bienvenida")
    public String mostrarBienvenida(HttpSession session, Model model) {
        // Obtener el objeto profesor almacenado en la sesión
        Profesor profesor = (Profesor) session.getAttribute("profesorAutenticado");

        // Verificar si el profesor está en la sesión
        if (profesor != null) {
            // Agregar el objeto profesor al modelo
            model.addAttribute("profesor", profesor);

            List<Articulo> articulosInvestigacion = profesor.getArticulosInvestigacion();
            List<ProyectoTerminal> proyectosTerminales = profesor.getProyectosTerminales();

            // Agregar los datos al model
            model.addAttribute("articulosInvestigacion", articulosInvestigacion);
            model.addAttribute("proyectosTerminales", proyectosTerminales);

            return "bienvenida";
        } else {
            // Si el profesor no está en la sesión, redirige a la página de inicio de sesión
            return "redirect:/login";
        }
    }



}