package Modelo;
public class Libro {
    private String titulo, autor , genero;

    public Libro() {
        this.titulo = "";
        this.autor = "";
        this.genero = "";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return this.titulo+", "+this.autor+", "+this.genero;
    }
}

