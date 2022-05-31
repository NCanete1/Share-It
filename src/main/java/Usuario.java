import java.util.ArrayList;

public class Usuario {
    private String nombre, correo , telefono;
    private ArrayList<Biblioteca> bibliotecas = new ArrayList();

    public Usuario() {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.bibliotecas = bibliotecas;
    }

    public ArrayList<Biblioteca> getBibliotecas() {
        return bibliotecas;
    }

    public void setBibliotecas(ArrayList<Biblioteca> bibliotecas) {
        this.bibliotecas = bibliotecas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Usuario: "+ this.nombre +", correo:"+ this.correo+ ", telefono: "+ "cantidad de libros: "+ this.bibliotecas.size();
    }
}
