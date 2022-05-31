import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca{
    Scanner teclado= new Scanner(System.in);
    private ArrayList<Libro> listlibro = new ArrayList();

    public ArrayList<Libro> getListlibro() {
        return listlibro;
    }
    public void setListlibro(ArrayList<Libro> listlibro) {
        this.listlibro = listlibro;
    }

    public void AñadirLibro(String titulo, String autor, String genero){
        Libro libro = new Libro();
        libro.setTitulo(titulo);
        libro.setAutor(autor);
        libro.setGenero(genero);
        listlibro.add(libro);
    }
    public String getLibros(){
        String lista= "";
        for(Libro libro: listlibro){
            lista += libro+ "\n";
        }
        return lista;
    }


}
