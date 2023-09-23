package com.project2.project2.controller;

import com.project2.project2.model.Articulo;
import com.project2.project2.model.ProyectoTerminal;
import com.project2.project2.model.Revista;
import com.project2.project2.repositories.revistaRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project2.project2.model.Profesor;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    private List<Profesor> listaProfesores = new ArrayList<>();

    public LoginController() {
        // Agrega profesores a la lista
        Profesor profesor1 = new Profesor("Leonardo", "internet","Posgrado", "Leonardo Bustamante");
        Profesor profesor2 = new Profesor("Jhon", "internet" , "Posgrado","Jhon Vargas");
        List<Articulo> articulosInvestigacion1 = generarDatosArticulos1();
        List<ProyectoTerminal> proyectosTerminales1 = generarDatosProyectos1();
        profesor1.setArticulosInvestigacion(articulosInvestigacion1);
        profesor1.setProyectosTerminales(proyectosTerminales1);
        listaProfesores.add(profesor1);

        List<Articulo> articulosInvestigacion2 = generarDatosArticulos2();
        List<ProyectoTerminal> proyectosTerminales2 = generarDatosProyectos2();
        profesor2.setArticulosInvestigacion(articulosInvestigacion2);
        profesor2.setProyectosTerminales(proyectosTerminales2);
        listaProfesores.add(profesor2);

    }

    @GetMapping("/")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        for (Profesor profesor : listaProfesores) {
            if (profesor.getUsuario().equals(username) && profesor.getContrasena().equals(password)) {
                // En caso de validación exitosa, redirige a la página de bienvenida
                Profesor profesorAutenticado = profesor;
                session.setAttribute("profesorAutenticado", profesorAutenticado);
                return "redirect:/bienvenida";
            }
        }
        // En caso de validación fallida, muestra un mensaje de error
        model.addAttribute("error", "Usuario o contraseña incorrectos");
        return "login";
    }

    private List<Articulo> generarDatosArticulos1() {
        List<Articulo> datosArticulos = new ArrayList<>();
        List<Revista> revistas = revistaRepo.buscarTodos();
        for (int i = 1; i <= 5; i++) {
            Articulo articulo = new Articulo();
            articulo.setTitulo("Título " + i);
            articulo.setRevista(revistas.get(1));
            articulo.setEstado("Aceptado");
            datosArticulos.add(articulo);
        }
        return datosArticulos;
    }
    private List<Articulo> generarDatosArticulos2() {
        List<Articulo> datosArticulos = new ArrayList<>();
        List<Revista> revistas = revistaRepo.buscarTodos();
        for (int i = 10; i <= 15; i++) {
            Articulo articulo = new Articulo();
            articulo.setTitulo("Título " + i);
            articulo.setRevista(revistas.get(0));
            articulo.setEstado("Aceptado");
            datosArticulos.add(articulo);
        }
        return datosArticulos;
    }

    private List<ProyectoTerminal> generarDatosProyectos1() {
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
    private List<ProyectoTerminal> generarDatosProyectos2() {
        List<ProyectoTerminal> datosProyectos = new ArrayList<>();
        for (int i = 10; i <= 15; i++) {
            ProyectoTerminal proyecto = new ProyectoTerminal();
            proyecto.setTitulo("Proyecto " + i);
            proyecto.setCantidadAlumnos(i * 2); // Cantidad de alumnos ficticia
            proyecto.setEstado("No Finalizado");
            datosProyectos.add(proyecto);
        }
        return datosProyectos;
    }
}

