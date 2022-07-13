package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import Datos.Libro;

public class Biblioteca {
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

    public void AñadirLibro(String user, String titulo, String autor, String genero) {
        this.listlibro.add(new Libro(titulo, autor, genero));
        AddLibrosBiblioteca(user, titulo, autor, genero);
    }

    public String getLibros() {
        String lista = "";
        for (Libro libro : listlibro) {
            lista += libro;
        }
        return lista;
    }

    public boolean estaVacio(File file) {
        return file.length() == 0;
    }

    public void AddLibrosBiblioteca(String usuario, String titulo, String autor, String genero) {
        try {
            usuario = usuario.toLowerCase().replace(" ", "");
            File file = new File(ruta + usuario + "/libros.txt");
            FileWriter fw = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fw);
            Libro libro = new Libro(titulo, autor, genero);
            String contenido = libro.toString();
            if (!estaVacio(file)) {
                pw.println((contenido));
            } else {
                pw.println((contenido));
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> leerLibros(String usuario) {
        List<String> lines = new ArrayList<String>();
        try {
            Scanner s = new Scanner(new File(ruta + usuario + "/libros.txt"));
            while (s.hasNext()) {
                lines.add(s.next().toUpperCase().replace("%%", " - "));
            }
            s.close();
        } catch (Exception e) {
        }
        return lines;
    }

    public List<String> filtrarGenero(String genero, String usuario) {
        List<String> lines = new ArrayList<String>();
        try {
            FileReader fileReader = new FileReader(ruta + usuario + "/libros.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line.toUpperCase().replace("%%", " - "));
                lines.removeIf(s -> !s.contains(genero.toUpperCase()));
            }
            bufferedReader.close();
            Collections.sort(lines, Collator.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

    public List<String> buscarLibro(String genero, String libro, String autor) {
        List<String> lines = null;
        List<String> gente = null;
        int tamaño=0;
        try {
            String ruta = "Usuarios/";
            String[] pathnames;
            File f = new File(ruta);
            pathnames = f.list();
            lines = new ArrayList<String>();
            gente = new ArrayList<String>();
            for (String pathname : pathnames) {
                tamaño= lines.size();
                FileReader fileReader = new FileReader(ruta + pathname + "/libros.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    lines.add(line.toUpperCase().replace("%%", " - "));
                    lines.removeIf(s -> !s.contains(genero.toUpperCase()));
                    lines.removeIf(s -> !s.contains(libro.toUpperCase()));
                    lines.removeIf(s -> !s.contains(autor.toUpperCase()));
                }
                bufferedReader.close();
                Collections.sort(lines, Collator.getInstance());
                if(lines.size()>tamaño){
                    gente.add(pathname);
                }
        }
        } catch (Exception e) {
        }
        return gente;
    }

    public List<String> conversionNombre(List<String> a){
        List<String> gente = null;
        gente = new ArrayList<String>();
        Rutas rs= new Rutas();
        for(String as: a){
            gente.add(rs.LeerUsuario(as,1));
        }
        return gente;
    }

    public void borrarLibro(String genero, String libro, String autor, String usuario) throws IOException {
        String ubicacion = ruta + usuario + "/libros.txt";
        List<String> list = null;
        try {
            File f = new File(ubicacion);
            list = new ArrayList<String>();
            FileReader fileReader = new FileReader(ubicacion);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line.toUpperCase());
                list.removeIf(s -> s
                        .contains(genero.toUpperCase() + "%%" + libro.toUpperCase() + "%%" + autor.toUpperCase()));
            }
            bufferedReader.close();
            Collections.sort(list, Collator.getInstance());
            FileWriter fw = new FileWriter(f, true);
            PrintWriter pw = new PrintWriter(fw);
            String contenido;
            BufferedWriter bw = new BufferedWriter(new FileWriter(ubicacion));
            bw.write("");
            bw.close();
            for (int i = 0; i < list.size(); i++) {
                contenido = list.get(i);
                if (!estaVacio(f)) {
                    pw.println((contenido));
                } else {
                    pw.println((contenido));
                }
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
