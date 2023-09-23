package com.project2.project2.model;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
    private String usuario;
    private String contrasena;
    private String gradoAcademico;
    private String nombreCompleto;
    private List<Articulo> articulosInvestigacion = new ArrayList<>();
    private List<ProyectoTerminal> proyectosTerminales = new ArrayList<>();

    private List<ProyectoTerminal> revistas = new ArrayList<>();


    public Profesor(String usuario, String contrasena, String gradoAcademico, String nombreCompleto) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.gradoAcademico = gradoAcademico;
        this.nombreCompleto = nombreCompleto;
        this.articulosInvestigacion = new ArrayList<>();
        this.proyectosTerminales = new ArrayList<>();
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getGradoAcademico() {
        return gradoAcademico;
    }

    public void setGradoAcademico(String gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public List<Articulo> getArticulosInvestigacion() {
        return articulosInvestigacion;
    }

    public void setArticulosInvestigacion(List<Articulo> articulosInvestigacion) {
        this.articulosInvestigacion = articulosInvestigacion;
    }

    public List<ProyectoTerminal> getProyectosTerminales() {
        return proyectosTerminales;
    }

    public void setProyectosTerminales(List<ProyectoTerminal> proyectosTerminales) {
        this.proyectosTerminales = proyectosTerminales;
    }



}
