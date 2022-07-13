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
        try {
        file = CrearRuta(usuario);
        if (file.exists()) {
                result = false;
            }else {
                result = true;
            } 
        }catch (Exception e) {
            System.out.println("ExisteUsuario");
        }
        return result;
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
 
}
