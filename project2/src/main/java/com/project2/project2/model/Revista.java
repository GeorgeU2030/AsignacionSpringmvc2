package com.project2.project2.model;

public class Revista {
    private String titulo;
    private String isbn;
    private String tipo;

    public Revista(String titulo, String isbn, String tipo) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
