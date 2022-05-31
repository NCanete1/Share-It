import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    int opcion=0;
    Biblioteca biblioteca= new Biblioteca();
    private ArrayList<Usuario> usuariolist = new ArrayList();
    private ArrayList<Biblioteca> bibliotecaArrayList= new ArrayList();
    Scanner teclado= new Scanner(System.in);
    public void MenuPrincipal(){
        do {
            try {
                System.out.println("0. Mostrar Usuarios");
                System.out.println("1.Añadir Usuario");
                opcion = teclado.nextInt();
                switch (opcion) {
                    case 0: //Mostrar Usuarios
                        System.out.println(getUsuarios());
                        MenuBiblioteca(0);
                        break;
                    case 1: //Crear Usuario
                        UsuariosTest();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error en MenuPrincipal");
            }
        }while (opcion!=-1);
    }
    public void MenuUsuarios (){
        System.out.println("0. Uusario 1");
        System.out.println("1. Usuario 2");
        opcion= teclado.nextInt();
        switch (opcion) {
            case 0 -> //Usuario 1
                    MenuBiblioteca(0);
            case 1 -> //Usuario 2
                    MenuBiblioteca(1);
        }
    }
    public void MenuBiblioteca(int n){
        System.out.println("0. Mostrar libros");
        System.out.println("1. Añadir Libro");
        opcion= teclado.nextInt();
        switch (opcion) {
            case 0: //Mostrar Libros
                System.out.println("Mostrar libro:");
                System.out.println(usuariolist.get(n).getBibliotecas().get(n).getLibros());
                break;
            case 1: //Añadir Libro
                System.out.println("Añadiendo Libro");

                break;
        }
    }

    /* AQUI NO VA CREAR USUARIOS CAMBIAR */


     public void addUsuario(String nombre, String correo, String telefono){
         Usuario usuario= new Usuario();
         usuario.setNombre(nombre);
         usuario.setCorreo(correo);
         usuario.setTelefono(telefono);
         usuario.setBibliotecas(bibliotecaArrayList);
         usuariolist.add(usuario);
    }

    public void UsuariosTest(){
        addUsuario("Juan","jorge@gmail.com","+56948257");
        addUsuario("Pepe","jorge2@gmail.com","+56948257");
        addUsuario("Jorge","jorge3@gmail.com","+56948257");
    }

    public String getUsuarios(){
        String lista= "";
        for(Usuario usuario: usuariolist){
            lista += usuario+ "\n";
        }
        return lista;
    }

}
