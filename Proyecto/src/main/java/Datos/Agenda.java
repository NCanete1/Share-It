package Datos;

import Modelo.Rutas;
import Validadores.ValidadorRut;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Usuario> usuarioslist;

    String rut, nombre, correo, contraseña;
    int telefono;

    public Agenda() {
        this.usuarioslist = new ArrayList<Usuario>();
    }

    public List<Usuario> getUsuarioslist() {
        return usuarioslist;
    }

    public void setUsuarioslist(List<Usuario> usuarioslist) {
        this.usuarioslist = usuarioslist;
    }

    public void AñadirUsarios(String rut, String contraseña, String nombre, String correo, int telefono) {
        this.usuarioslist.add(new Usuario(rut, contraseña, nombre, correo, telefono));
        Rutas rutas = new Rutas();
        rutas.CrearDatos(rut, contraseña, nombre, correo, telefono);
    }

    /*
     * public void UsuariosPreCreados(){
     * this.usuarioslist.add(new
     * Usuario("123456785","Usuario1","u.suario1@gmail.cl",
     * 987654321));
     * }
     */

    public void mostrarAutosLista(List<Usuario> usuarios) {
        for (Usuario user : usuarios) {
            System.out.println(user.toString());
        }
    }

    public boolean ValidarRut(String rutVR) { // void
        try {
            rut = rutVR;
        } catch (Exception e) {
            System.out.println("Error Exception(ValidarRut): Rut Ingresado no valido. Reintente la operación.");
            ValidarRut(rutVR);
        }
        return (ValidadorRut.Verificacion(rut));
    }

}
