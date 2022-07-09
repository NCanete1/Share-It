package Modelo;

import Datos.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Scanner;

public class Rutas {
    Scanner teclado = new Scanner(System.in);
    private String ruta = "Usuarios/";
    private File file;

    public File CrearRuta(String user) {

        try {
            String usuario = user.toLowerCase().replace(" ", "");
            String rutausuario;
            rutausuario = ruta + usuario+"/";
            Path path = Paths.get(rutausuario);
            Files.createDirectories(path);
            return new File(rutausuario);
        } catch (Exception e) {
            System.out.println("Exception Error (CrearLibreria)");
        }
        return new File("");
    }

    public void CrearDatos(String user, String password, String nombre, String correo, int telefono) {
        try {
            user = user.toLowerCase().replace(" ", "");
            File file = new File(ruta + user + "/datos.txt");
            FileWriter fw = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fw);
            Usuario usuario = new Usuario(password, user, nombre, correo, telefono);
            ;
            String contenido = usuario.toString();
            pw.println((contenido));
            pw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CambiarDatos(String user, String password, String nombre, String correo, int telefono) {
        try {
            user = user.toLowerCase().replace(" ", "");
            File file = new File(ruta + user + "/datos.txt");
            FileWriter fw = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fw);
            Usuario usuario = new Usuario(password, user, nombre, correo, telefono);
            String contenido = usuario.toString();
            pw.println((contenido));
            pw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean ExisteUsuario(String usuario) {
        boolean result = false;
        file = CrearRuta(usuario);
        if (file.exists()) {
            try {
                result = false;
            } catch (Exception e) {
                System.out.println("Exception Error (Existencia del Usuario.)");
            }
        } else {
            result = true;
        }
        return result;
    }

    public void CrearBibliotecaUsuario(String usuario) {
        file = CrearRuta(usuario);
        // Verifica que el archivo existe o no.
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                System.out.println("Exception Error (CrearBibliotecaUsuario.)");
            }
        }
    }


    public String LeerUsuario(String user, int n) {
        String linea = "";
        try {
            linea = Files.readAllLines(Paths.get(ruta + user + "/datos.txt")).get(n);
        } catch (IOException e) {
            System.out.println(e);
        }
        return linea;
    }

    public void LeerBiblioteca(String user) {
        String texto = "";
        try {
            BufferedReader bf = new BufferedReader(new FileReader(ruta + user + ".txt"));
            String bfRead, temp = "";
            while ((bfRead = bf.readLine()) != null) {
                temp = (temp + bfRead + "\n");
            }
            texto = temp;
        } catch (Exception e) {
            System.out.println("Error Exception (Leer)");
        }
        System.out.println(texto);
    }

    public String addLibro(String titulo, String autor, String genero) {
        if (autor.equals("")) {
            autor = "DESCONOCIDO";
        }
        String genre = teclado.nextLine();
        if (genre.equals("")) {
            genre = "DESCONOCIDO";
        }
        /*
         * Biblioteca biblioteca = new Biblioteca(biblioteca.getListlibro());
         * biblioteca.AñadirLibro(titulo.toUpperCase(),autor.toUpperCase(),genre.
         * toUpperCase());
         */
        return "biblioteca.getLibros()";
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
            Libro libro= new Libro(titulo,autor, genero);
            String contenido = libro.toString();
            if(!estaVacio(file)){
                pw.println(("\n"+contenido));
            }else{
                pw.println((contenido));
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void MostrarBibliotecaUsuarios() {
        try {
            File file = new File(ruta);
            File[] files = file.listFiles();
            for (File value : files) {
                System.out.println(value.getName().replace(".txt", ""));
            }
        } catch (Exception e) {
            System.out.println("Error exception (MostrarUsuarios)");
        }
    }

    public String BuscarLibroUsuario(String usuario, String nombrelibro) {
        usuario = usuario.toLowerCase().replace(" ", "").replace(".txt", "");
        String libro = nombrelibro.toLowerCase();
        String encontrado = "";
        try {
            BufferedReader bf = new BufferedReader(new FileReader(ruta + usuario + ".txt"));
            String bfRead, temp;
            while ((bfRead = bf.readLine()) != null) {
                temp = (bfRead).toLowerCase();
                if (temp.contains(libro)) {
                    encontrado = encontrado + temp + "\n";
                }
            }
        } catch (Exception e) {
            System.out.println("Error Exception(BuscarLibroUsuario)");
        }
        return encontrado;
    }

    public void MostrarBuscarLibroUsuario(String usuario, String nombrelibro) {
        if ((BuscarLibroUsuario(usuario, nombrelibro).equals(""))) {
            System.out.println("El Usuario introducion no posee ningun libro de nombre: " + nombrelibro);
        } else {
            System.out.println(nombrelibro + " encontrados en " + usuario + ": ");
            System.out.println("----------------");
            System.out.println((BuscarLibroUsuario(usuario, nombrelibro)));
        }
    }

    public void BuscarLibro(String libro) {
        try {
            File file = new File(ruta);
            File[] files = file.listFiles();
            for (File value : files) {
                if (!BuscarLibroUsuario((value.getName()), libro).equals("")) {
                    System.out.println(value.getName().replace(".txt", ", Tiene en su biblioteca:"));
                    System.out.println(BuscarLibroUsuario((ruta + value.getName()), libro));
                }
            }
        } catch (Exception e) {
            System.out.println("Error exception (Buscar Libro)");
        }
    }
}
