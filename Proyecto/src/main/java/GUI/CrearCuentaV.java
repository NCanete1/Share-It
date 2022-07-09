package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import Datos.Agenda;
import Modelo.Rutas;

public class CrearCuentaV extends JFrame {
    private JLabel labelMensaje;
    private JLabel labelRut;
    private JLabel labelemail;
    private JLabel labelCelular;
    private JLabel labelContraseña;
    private JLabel labelNombre;
    private JTextField rut;
    private JTextField nombre;
    private JTextField email;
    private JTextField celular;
    private JPasswordField contraseña;
    private JButton buttonContinuar;
    private JButton buttonCancelar;

    private Continuar al;

    public CrearCuentaV() {
        Menu();
        MenuLabel();
        MenuButtons();
        MenuTextField();
        pack();
        setVisible(true);
    }

    public void MenuLabel() {
        // Componentes
        labelMensaje = new JLabel("Crea tu cuenta!");

        labelRut = new JLabel("Rut");
        labelNombre= new JLabel("Nombre");
        labelemail = new JLabel("Correo de Contacto");
        labelCelular = new JLabel("Celular");
        labelContraseña = new JLabel("Contraseña");

        // add componentes
        add(labelMensaje);

        add(labelRut);
        add(labelNombre);
        add(labelemail);
        add(labelCelular);
        add(labelContraseña);

        // Posicionamiento
        labelMensaje.setBounds(130, 55, 95, 25);

        labelRut.setBounds(130, 75, 100, 25);
        labelNombre.setBounds(130, 135, 100, 25);
        labelemail.setBounds(130, 195, 155, 20);
        labelCelular.setBounds(130, 255, 100, 25);
        labelContraseña.setBounds(130, 315, 100, 25);

    }

    public void MenuTextField() {
        // Componentes
        rut = new JTextField(5);
        nombre = new JTextField(5);
        email = new JTextField(5);
        celular = new JTextField(5);
        contraseña = new JPasswordField(5);

        // add componentes
        add(rut);
        add(nombre);
        add(email);
        add(celular);
        add(contraseña);

        // Posicionamiento
        rut.setBounds(130, 100, 250, 20);
        nombre.setBounds(130, 160, 250, 20);
        email.setBounds(130, 220, 250, 20);
        celular.setBounds(130, 280, 250, 20);
        contraseña.setBounds(130, 340, 250, 20);

    }

    public void MenuButtons() {
        // Componentes
        buttonContinuar = new JButton("Continuar");
        buttonCancelar = new JButton("Cancelar");

        // add componentes
        add(buttonContinuar);
        add(buttonCancelar);

        // Posicionamiento
        buttonContinuar.setBounds(180, 370, 160, 35);
        buttonCancelar.setBounds(210, 415, 100, 25);

        ActionListener cancelar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {   
                    InicioSesionV ventana = new InicioSesionV();
                    ventana.setVisible(true);
                    dispose();
                }
        };


        //Listener 
        Continuar continuar= new Continuar();

        //add
        buttonContinuar.addActionListener(continuar);
        buttonContinuar.addActionListener(cancelar);

    }

    //Listener

    private class Continuar implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (rut.getText().isEmpty() || contraseña.getPassword().length == 0 ||email.getText().isEmpty() ||celular.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(null, "Favor de llenar los espacios vacios");
            } else {
                Agenda agenda = new Agenda();
                if(!agenda.ValidarRut(rut.getText())) {
                    JOptionPane.showMessageDialog(null, "Ingrese un rut valido");
                    }else{
                        Rutas rutas = new Rutas();
                        if(rutas.ExisteUsuario(rut.getText())){
                            JOptionPane.showMessageDialog(null, "El usuario ya existe");
                        }else{
                            agenda.AñadirUsarios(rut.getText(), String.valueOf(contraseña.getPassword()),nombre.getText(),email.getText(), Integer.parseInt(celular.getText()));
                            PerfilV ventana = new PerfilV(rut.getText());
                            ventana.setVisible(true);
                            dispose();
                        }
                    }
                }
            }
        }

    public void Menu() {
        // Tamaño y Diseño
        this.setTitle("Crear Cuenta");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        setLayout(null);
    }

}