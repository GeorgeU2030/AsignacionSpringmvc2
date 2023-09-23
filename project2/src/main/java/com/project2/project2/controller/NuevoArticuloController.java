package com.project2.project2.controller;

import com.project2.project2.model.Articulo;
import com.project2.project2.model.Profesor;
import com.project2.project2.model.Revista;
import com.project2.project2.repositories.revistaRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private revistaRepo revistaRepository;

    @GetMapping("/nuevo-articulo")
    public String mostrarNuevoArticulo(Model model) {
        // Aquí puedes cargar las revistas generadas a nivel de código y pasarlas al modelo
        List<Revista> revistas = revistaRepository.buscarTodos();
        model.addAttribute("revistas", revistas);
        Articulo nuevoArticulo = new Articulo();
        model.addAttribute("articulo", nuevoArticulo);

        return "nuevo_articulo";
    }

    @PostMapping("/nuevo-articulo")
    public String registrarNuevoArticulo(@RequestParam String titulo, @RequestParam String  revista, @RequestParam String estado, HttpSession session) {

        Profesor profesorAutenticado = (Profesor) session.getAttribute("profesorAutenticado");
        System.out.println("Título: " + titulo);
        System.out.println("Revista: " + revista);
        System.out.println("Estado: " + estado);

        Articulo nuevoArticulo = new Articulo();
        nuevoArticulo.setTitulo(titulo);
        nuevoArticulo.setEstado(estado);

        nuevoArticulo.setRevista(revistaRepository.obtenerPorISBN(revista));

        profesorAutenticado.getArticulosInvestigacion().add(nuevoArticulo);
        return "redirect:/nuevo-articulo";
    }

    private List<Revista> generarRevistas() {

        List<Revista> revistas = new ArrayList<>();
        revistas.add(new Revista("R1", "ISBN1","Indexada"));
        revistas.add(new Revista("R2", "ISBN2","Indexada"));
        return revistas;
    }
}

