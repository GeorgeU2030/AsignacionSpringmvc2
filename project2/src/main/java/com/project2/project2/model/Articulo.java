package com.project2.project2.model;

public class Articulo {
        private String titulo;
        private Revista revista;
        private String estado;

        // Getters y setters...

    public Articulo(){

    }
    public Articulo(String titulo, Revista revista, String estado) {
        this.titulo = titulo;
        this.revista = revista;
        this.estado = estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Revista getRevista() {
        return revista;
    }

    public void setRevista(Revista revista) {
        this.revista = revista;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
