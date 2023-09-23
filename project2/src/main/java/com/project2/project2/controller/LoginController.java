package com.project2.project2.controller;

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
        listaProfesores.add(new Profesor("Leonardo", "internet","Posgrado", "Leonardo Bustamante"));
        listaProfesores.add(new Profesor("Jhon", "internet" , "Posgrado","Jhon Arias"));
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
}

