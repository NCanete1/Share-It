package Datos;
import java.util.ArrayList;

public class Usuario {
    private String nombre, correo , telefono;
    private Biblioteca biblioteca;


    public Usuario(String nombre, String correo, String telefono, Biblioteca biblioteca) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.biblioteca= biblioteca;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "correo:"+ this.correo+ "\n telefono: " + this.telefono;
    }
}
