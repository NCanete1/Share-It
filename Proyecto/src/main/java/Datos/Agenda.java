package Datos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import Modelo.ValidadorRut;



public class Agenda {
    private List<Usuario> usuarioslist;
    private Biblioteca biblioteca;
    

    Scanner teclado = new Scanner(System.in);
    String rut,nombre,correo;
    int telefono;
    

    public Agenda(){
        this.usuarioslist= new ArrayList<Usuario>();
    }

    public List<Usuario> getUsuarioslist() {
        return usuarioslist;
    }

    public void setUsuarioslist(List<Usuario> usuarioslist) {
        this.usuarioslist = usuarioslist;
    }

    public void AñadirUsarios(String rut,String nombre,String correo,int telefono){
        if(!ValidarRut(rut)) {
            try {
                System.out.println("Error en validaciond el rut");
               
            } catch (Exception e) {
                System.out.println("Error Exception(Añadir Vendedor). Verifique el nombre");
            }
        }else {
            this.usuarioslist.add(new Usuario(rut,nombre,correo,telefono,biblioteca));
        }
    }

    public void UsuariosPreCreados(){
        this.usuarioslist.add(new Usuario("123456785","Usuario1","u.suario1@gmail.cl",
                987654321,biblioteca));
    }

    public void mostrarAutosLista(List<Usuario> usuarios){
        for(Usuario user : usuarios){
            System.out.println(user.toString());
        }
    }


    public boolean ValidarRut(String rutVR){   //void
        try {
            rut= rutVR;
        }catch (Exception e){
            System.out.println("Error Exception(ValidarRut): Rut Ingresado no valido. Reintente la operación.");
            ValidarRut(rutVR);
        }
        return  (ValidadorRut.Verificacion(rut));
    }

    
}

