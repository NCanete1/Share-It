package Datos;
import java.util.ArrayList;

import Modelo.Rutas;

public class Biblioteca{
    private ArrayList<Libro> listlibro;

    public Biblioteca() {
        this.listlibro = new ArrayList<Libro>();
    }

    public ArrayList<Libro> getListlibro() {
        return listlibro;
    }
    public void setListlibro(ArrayList<Libro> listlibro) {
        this.listlibro = listlibro;
    }

    public void AñadirLibro(String user,String titulo, String autor, String genero) {
        this.listlibro.add(new Libro(titulo, autor, genero));
        Rutas rutas = new Rutas();
        rutas.AddLibrosBiblioteca(user,titulo, autor, genero);
    }

    public String getLibros(){
        String lista= "";
        for(Libro libro: listlibro){
            lista += libro;
        }
        return lista;
    }


}
