package Datos;

import Modelo.Rutas;
import Validadores.ValidadorRut;

import java.util.ArrayList;
import java.util.List;

public class Agenda extends Usuario {
    private List<Usuario> usuarioslist;
    
    public Agenda(String contraseña, String rut, String nombre, String correo, int telefono) {
        super(contraseña, rut, nombre, correo, telefono);
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

    public boolean ValidarRut(String rutVR) { // void
        return (ValidadorRut.Verificacion(rutVR));
    }

}
