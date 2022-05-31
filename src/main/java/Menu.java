import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    Biblioteca biblioteca = new Biblioteca();
    private ArrayList<Usuario> usuariolist = new ArrayList();
    private ArrayList<Biblioteca> bibliotecaArrayList = new ArrayList();
    Scanner teclado = new Scanner(System.in);
    int opcion = 0;

    public void MenuPrincipal() {

        Scanner sn = new Scanner(System.in);
        int opcion = 0;
        try {
            do {
                System.out.println("Mostrar usuarios [1]");
                System.out.println("Agregar usuarios [2]");
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println(getUsuarios());
                        MenuBiblioteca(0);
                        break;
                    case 2:
                        UsuariosTest();
                        break;
                }
            } while (opcion >= 1 && opcion <= 2);

        } catch (Exception e) {
            System.out.println("Ingrese un numero valido");
            System.out.println("-------------------------");
            MenuPrincipal();
        }
    }


    public void MenuUsuarios() {
        System.out.println("0. Uusario 1");
        System.out.println("1. Usuario 2");
        opcion = teclado.nextInt();
        switch (opcion) {
            case 0 -> //Usuario 1
                    MenuBiblioteca(0);
            case 1 -> //Usuario 2
                    MenuBiblioteca(1);
        }
    }

    public void MenuBiblioteca(int n) {
        System.out.println("Mostrar libros [1]");
        System.out.println("Agregar Libro [2]");
        opcion = teclado.nextInt();
        switch (opcion) {
            case 1: //Mostrar Libros
                System.out.println("Mostrar libro:");
                break;
            case 2: //Añadir Libro
                System.out.println("Añadiendo Libro");
                break;
        }
    }

    /* AQUI NO VA CREAR USUARIOS CAMBIAR */


    public void addUsuario(String nombre, String correo, String telefono) {
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setCorreo(correo);
        usuario.setTelefono(telefono);
        usuariolist.add(usuario);
    }

    public void UsuariosTest() {
        addUsuario("Juan", "jorge@gmail.com", "+56948257");
        addUsuario("Pepe", "jorge2@gmail.com", "+56948257");
        addUsuario("Jorge", "jorge3@gmail.com", "+56948257");
    }

    public String getUsuarios() {
        String lista = "";
        for (Usuario usuario : usuariolist) {
            lista += usuario + "\n";
        }
        return lista;
    }
}
