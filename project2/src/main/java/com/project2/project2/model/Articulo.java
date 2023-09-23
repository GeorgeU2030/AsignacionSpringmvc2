package com.project2.project2.model;

public class Articulo {
        private String titulo;
        private String nombreRevista;
        private String categoria;
        private String estado;

        // Getters y setters...

    public Articulo(){

    }
    public Articulo(String titulo, String nombreRevista, String categoria, String estado) {
        this.titulo = titulo;
        this.nombreRevista = nombreRevista;
        this.categoria = categoria;
        this.estado = estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombreRevista() {
        return nombreRevista;
    }

    public void setNombreRevista(String nombreRevista) {
        this.nombreRevista = nombreRevista;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
