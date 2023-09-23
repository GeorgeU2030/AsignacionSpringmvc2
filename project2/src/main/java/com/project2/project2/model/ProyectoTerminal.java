package com.project2.project2.model;

public class ProyectoTerminal {

    private String titulo;
    private int cantidadAlumnos;
    private String estado;

    public ProyectoTerminal(){

    }
    public ProyectoTerminal(String titulo, int cantidadAlumnos, String estado) {
        this.titulo = titulo;
        this.cantidadAlumnos = cantidadAlumnos;
        this.estado = estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCantidadAlumnos() {
        return cantidadAlumnos;
    }

    public void setCantidadAlumnos(int cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
