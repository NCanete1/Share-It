package Datos;

public class Usuario {
    private String rut,nombre, correo;
    private int telefono;
    private Biblioteca biblioteca;
   

    public Usuario(String rut, String nombre, String correo, int telefono, Biblioteca biblioteca) {
        this.rut = rut;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.biblioteca = biblioteca;
    }


    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return this.nombre+ "\n" +this.correo+ "\n" + this.telefono + "\n" +this.biblioteca;
    }
}
