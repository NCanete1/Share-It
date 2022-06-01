import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Project2 {
    Scanner teclado= new Scanner(System.in);
    private String ruta= "Biblioteca/";
    private String rutausuario= "Biblioteca/usuario1.txt";
    private File file;

    public File CrearRuta(String user){
        try {
            String usuario = user.toLowerCase().replace(" ","");
            rutausuario= "Biblioteca/"+ usuario +".txt";
            return new File(usuario);
        }catch (Exception e){
            System.out.println("Exception Error (CrearLibreria)");
        }
        return new File("");
    }

    public void LibreriaUsuario(String usuario) {
                file = CrearRuta(usuario);
                // Verifica que el archivo existe o no.
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (Exception e) {
                        System.out.println("Exception Error (Libreria Usuario.)");
                    }
                }
        }

    public void LeerBiblioteca(String user){
        String texto= "";
        try {
            BufferedReader bf= new BufferedReader(new FileReader(ruta+user+".txt"));
            String bfRead,temp="";
            while ((bfRead = bf.readLine()) != null){
                temp = (temp + bfRead + "\n");
            }
            texto = temp;
        }catch (Exception e){
            System.out.println("Error Exception (Leer)");
        }
        System.out.println(texto);
    }
    public String AddLibro(){
        try {
            String nombre;
            do{
                System.out.println("Ingrese nombre del Libro");
                nombre=teclado.nextLine().toUpperCase();
                    if(nombre.equals("")){
                        System.out.println("Debe almenos introducir el Nombre del Libro");
                        }
            }while (nombre.equals(""));
            System.out.println("Ingresar nombre del Autor");
            String autor=teclado.nextLine();
            if(autor.equals("")){
                autor= "Desconocido.";
            }
            System.out.println("Ingresar genero del libro");
            String genre =teclado.nextLine();
            if(genre.equals("")){
                genre = "Desconocido.";
            }
            Biblioteca biblioteca = new Biblioteca();
            biblioteca.AñadirLibro(nombre,autor,genre);
            return biblioteca.getLibros();
        } catch (Exception e) {
            System.out.println("Error Exception (Add libro)");
            e.printStackTrace();
        }
        return "";
    }

    public void AddLibrosBiblioteca(String usuario){
        try{
            usuario= usuario.toLowerCase().replace(" ","");
            File file = new File(ruta+usuario+".txt");
            FileWriter fw = new FileWriter(file,true);
            PrintWriter pw = new PrintWriter(fw);
            String contenido= AddLibro();
            pw.println((contenido));
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
                System.out.println(value.getName().replace(".txt",""));
            }
        }catch (Exception e){
            System.out.println("Error exception (MostrarUsuarios)");
        }
    }
    public String BuscarLibroUsuario(String usuario, String nombrelibro) {
        usuario= usuario.toLowerCase().replace(" ","").replace(".txt", "");
        String libro = nombrelibro.toLowerCase();
        String encontrado = "";
        try {
            BufferedReader bf= new BufferedReader(new FileReader(ruta+usuario+".txt"));
            String bfRead,temp;
            while ((bfRead = bf.readLine()) != null){
                temp = (bfRead).toLowerCase();
                if(temp.contains(libro)){
                    encontrado= encontrado + temp + "\n";
                }
            }
        } catch (Exception e) {
            System.out.println("Error Exception(BuscarLibroUsuario)");
        }
        return encontrado;
    }

    public void MostrarBuscarLibroUsuario(String usuario, String nombrelibro) {
        if((BuscarLibroUsuario(usuario, nombrelibro).equals(""))){
            System.out.println("El Usuario introducion no posee ningun libro de nombre: " + nombrelibro);
        }else{
        System.out.println(nombrelibro +" encontrados en " + usuario + ": ");
            System.out.println("----------------");
            System.out.println((BuscarLibroUsuario(usuario, nombrelibro)));
        }
    }
    public void BuscarLibro(String libro) {
        try {
            File file = new File(ruta);
            File[] files = file.listFiles();
            for (File value : files) {
                if(!BuscarLibroUsuario((value.getName()),libro).equals("")){
                    System.out.println(value.getName().replace(".txt", ", Tiene en su biblioteca:"));
                    System.out.println(BuscarLibroUsuario((ruta + value.getName()),libro));
                }
            }
        }catch (Exception e){
            System.out.println("Error exception (Buscar Libro)");
        }
    }
}
