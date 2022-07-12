package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import Modelo.Rutas;

public class PerfilV extends JFrame {
    private JLabel labelPerfil;
    private JLabel labelNombre;
    private JTextField email;
    private JLabel labelemail;
    private JLabel labelCelular;
    private JTextField celular;
    private JButton buttonBiblioteca;
    private JButton buttonDesconectarse;
    private String user;


    public PerfilV(String rut) {
        Rutas ruta = new Rutas();
        user=rut;
        Menu();
        MenuLabel(ruta.LeerUsuario(rut,1).toUpperCase());
        MenuButtons();
        MenuTextField(ruta.LeerUsuario(rut,2),Integer.valueOf(ruta.LeerUsuario(rut,3)));
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public PerfilV(String rut,String a) {
        Rutas ruta = new Rutas();
        user=rut;
        Menu();
        MenuLabel(ruta.LeerUsuario(rut,1).toUpperCase());
        MenuTextField(ruta.LeerUsuario(rut,2),Integer.valueOf(ruta.LeerUsuario(rut,3)));
        pack();
        setVisible(true);
    }

    public void MenuLabel() {
        // Componentes
        labelPerfil = new JLabel("Perfil");
        labelNombre = new JLabel("Nombre");

        labelemail = new JLabel("Correo de Contacto");
        labelCelular = new JLabel("Celular");

        // add componentes
        add(labelPerfil);
        add(labelNombre);

        add(labelemail);
        add(labelCelular);

        // Posicionamiento

        labelPerfil.setBounds(130, 55, 95, 25);
        labelNombre.setBounds(185, 95, 140, 25);

        labelemail.setBounds(130, 165, 155, 20);
        labelCelular.setBounds(130, 225, 100, 25);

    }

    public void MenuLabel(String usuario) {
        // Componentes
        labelPerfil = new JLabel("Perfil");
        labelNombre = new JLabel(usuario.toUpperCase());

        labelemail = new JLabel("Correo de Contacto");
        labelCelular = new JLabel("Celular");

        // add componentes
        add(labelPerfil);
        add(labelNombre);

        add(labelemail);
        add(labelCelular);

        // Posicionamiento

        labelPerfil.setBounds(130, 55, 95, 25);
        labelNombre.setBounds(185, 95, 140, 25);

        labelemail.setBounds(130, 165, 155, 20);
        labelCelular.setBounds(130, 225, 100, 25);

    }

    public void MenuTextField() {
        // Componentes
        email = new JTextField(5);
        celular = new JTextField(5);

        //Propiedades
        email.setEditable(false);
        celular.setEditable(false);

        // add componentes
        add(email);
        add(celular);

        // Posicionamiento
        email.setBounds(130, 190, 250, 20);
        celular.setBounds(130, 250, 250, 20);

    }


    public void MenuTextField(String correo, int telefono) {
        // Componentes
        email = new JTextField(correo);
        celular = new JTextField(String.valueOf(telefono));

        //Propiedades
        email.setEditable(false);
        celular.setEditable(false);

        // add componentes
        add(email);
        add(celular);

        // Posicionamiento
        email.setBounds(130, 190, 250, 20);
        celular.setBounds(130, 250, 250, 20);

    }

    public void MenuButtons() {
        // Componentes
        buttonBiblioteca = new JButton("Tu Biblioteca");
        buttonDesconectarse = new JButton("Logout");
        // add componentes
        add(buttonBiblioteca);
        add(buttonDesconectarse);

        // Posicionamiento
        buttonBiblioteca.setBounds(175, 290, 160, 35);
        buttonDesconectarse.setBounds(15, 15, 100, 25);

        // ActionListener

        ActionListener Desconectarse = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JButtonActionPerformed(ae);
            }
        };

        ActionListener Biblioteca = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                BibliotecaV ventana = new BibliotecaV(user);
                ventana.setVisible(true);
                dispose();
            }
        };

        // Añadir Acciones
        buttonBiblioteca.addActionListener(Biblioteca);
        buttonDesconectarse.addActionListener(Desconectarse);

    }

    // Action Performed
    private void JButtonActionPerformed(ActionEvent ae) {
        int respuesta = JOptionPane.showConfirmDialog(this,
                "Esta opción te desconectara de la cuenta. Tendras que volver a ingresar tus datos para volver a usar la aplicacion. \n Desea continuar?",
                "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == JOptionPane.YES_OPTION) {
            InicioSesionV ventana = new InicioSesionV();
            ventana.setVisible(true);
            dispose();
        }
    }

    public void Menu() {
        // Tamaño y Diseño
        this.setTitle("Perfil");
        setPreferredSize(new Dimension(500, 500));
        setLayout(null);
    }

}
