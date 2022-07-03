package GUI;

import java.util.ArrayList;
import java.util.Scanner;

import Datos.*;
import Modelo.*;


public class MenuAntiguo {
    Biblioteca biblioteca = new Biblioteca();
    Rutas project = new Rutas();
    private ArrayList<Usuario> usuariolist = new ArrayList();
    private ArrayList<Biblioteca> bibliotecaArrayList = new ArrayList();
    Scanner teclado = new Scanner(System.in);
    int opcion = 0;

    public void MenuPrincipal() {

        Scanner sn = new Scanner(System.in);
        int opcion = 0;
        try {
            do {
                System.out.println("Bienvenido!");
                System.out.println("---------------");
                System.out.println("Mostrar usuarios [1]");
                System.out.println("Agregar usuarios [2]");
                System.out.println("Ingresar como... [3]");
                System.out.println("---------------");
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1:
                        project.MostrarBibliotecaUsuarios();
                        break;
                    case 2:
                        String nuevouser= teclado.nextLine();
                        project.LibreriaUsuario(nuevouser);
                        break;
                    case 3:
                        System.out.println("Introduzca el nombre del usuario a entrar: ");
                        String user= teclado.nextLine();
                        MenuBiblioteca(user);
                        break;
                    default:
                        System.out.println("Ingrese un numero valido");
                        System.out.println("-------------------------");
                }
            } while (!(opcion >=1 && opcion<=3));

        } catch (Exception e) {
            System.out.println("Ingrese un numero valido");
            System.out.println("-------------------------");
            MenuPrincipal();
        }
    }

    public void MenuUsuarios() {
        System.out.println("1. Usuario 1");
        System.out.println("2. Usuario 2");
        opcion = teclado.nextInt();
        switch (opcion) {
            case 1 -> //Usuario 1
                    MenuBiblioteca("usuario 1");
            case 2 -> //Usuario 2
                    MenuBiblioteca("usuario 2");
        }
    }

    public void MenuBiblioteca(String Usuario) {
        do {
            System.out.println("Mostrar libros de Usuarios [1]");
            System.out.println("Agregar Libro [2]");
            System.out.println("Buscar Libro [3]");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1: //Mostrar Libros
                    System.out.println("Mostrando libros Usuario:");
                    project.LeerBiblioteca(Usuario);
                    break;
                case 2: //Añadir Libro
                    System.out.println("Añadiendo Libro");
                    project.AddLibrosBiblioteca(Usuario);
                    break;
                case 3:
                    String libro = teclado.nextLine();
                    project.BuscarLibro(libro);
                    break;
            }
        }while (!(opcion >=1 && opcion<=3));
    }
}
