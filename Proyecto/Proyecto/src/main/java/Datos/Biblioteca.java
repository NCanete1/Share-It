package Datos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Modelo.Rutas;

public class Biblioteca{
    private String ruta = "Usuarios/";
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

    public List<String> sortGeneroEspecifico(String genero,String usuario) throws IOException
   {     
       FileReader fileReader = new FileReader(ruta + usuario + "/libros.txt");
       BufferedReader bufferedReader = new BufferedReader(fileReader);
       List<String> lines = new ArrayList<String>();
       String line = null;
       while ((line = bufferedReader.readLine()) != null) {
           lines.add(line.toUpperCase().replace("%%", " - "));
           lines.removeIf(s -> !s.contains(genero.toUpperCase()));
       }
       bufferedReader.close();
       Collections.sort(lines, Collator.getInstance());
       return lines;
   }


}
