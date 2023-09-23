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

            List<Articulo> articulosInvestigacion = generarDatosArticulos();

            // Generar datos ficticios para los proyectos terminales
            List<ProyectoTerminal> proyectosTerminales = generarDatosProyectos();

            // Agregar los datos al model
            model.addAttribute("articulosInvestigacion", articulosInvestigacion);
            model.addAttribute("proyectosTerminales", proyectosTerminales);

            return "bienvenida";
        } else {
            // Si el profesor no está en la sesión, redirige a la página de inicio de sesión
            return "redirect:/login";
        }
    }

    // Método para generar datos ficticios para los artículos de investigación
    private List<Articulo> generarDatosArticulos() {
        List<Articulo> datosArticulos = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Articulo articulo = new Articulo();
            articulo.setTitulo("Título " + i);
            articulo.setNombreRevista("Revista " + i);
            articulo.setCategoria("Indexada");
            articulo.setEstado("Aceptado");
            datosArticulos.add(articulo);
        }
        return datosArticulos;
    }

    // Método para generar datos ficticios para los proyectos terminales
    private List<ProyectoTerminal> generarDatosProyectos() {
        List<ProyectoTerminal> datosProyectos = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            ProyectoTerminal proyecto = new ProyectoTerminal();
            proyecto.setTitulo("Proyecto " + i);
            proyecto.setCantidadAlumnos(i * 2); // Cantidad de alumnos ficticia
            proyecto.setEstado("Finalizado");
            datosProyectos.add(proyecto);
        }
        return datosProyectos;
    }
}