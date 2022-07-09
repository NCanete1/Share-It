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
    private JTextField rut;
    private JTextField email;
    private JLabel labelemail;
    private JLabel labelCelular;
    private JTextField celular;
    private JLabel labelContraseña;
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
        labelemail = new JLabel("Correo de Contacto");
        labelCelular = new JLabel("Celular");
        labelContraseña = new JLabel("Contraseña");

        // add componentes
        add(labelMensaje);

        add(labelRut);
        add(labelemail);
        add(labelCelular);
        add(labelContraseña);

        // Posicionamiento
        labelMensaje.setBounds(130, 55, 95, 25);

        labelRut.setBounds(130, 105, 100, 25);
        labelemail.setBounds(130, 165, 155, 20);
        labelCelular.setBounds(130, 225, 100, 25);
        labelContraseña.setBounds(130, 285, 100, 25);

    }

    public void MenuTextField() {
        // Componentes
        rut = new JTextField(5);
        email = new JTextField(5);
        celular = new JTextField(5);
        contraseña = new JPasswordField(5);

        // add componentes
        add(rut);
        add(email);
        add(celular);
        add(contraseña);

        // Posicionamiento
        rut.setBounds(130, 130, 250, 20);
        email.setBounds(130, 190, 250, 20);
        celular.setBounds(130, 250, 250, 20);
        contraseña.setBounds(130, 310, 250, 20);

    }

    public void MenuButtons() {
        // Componentes
        buttonContinuar = new JButton("Continuar");
        buttonCancelar = new JButton("Cancelar");

        // add componentes
        add(buttonContinuar);
        add(buttonCancelar);

        // Posicionamiento
        buttonContinuar.setBounds(185, 360, 160, 35);
        buttonCancelar.setBounds(220, 415, 100, 25);

        ActionListener regresar = new ActionListener() {
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
                        if(!rutas.ExisteUsuario(rut.getText())){
                            JOptionPane.showMessageDialog(null, "El usuario ya existe");
                        }else{
                            agenda.AñadirUsarios(rut.getText(), String.valueOf(contraseña.getPassword()), email.getText(), Integer.parseInt(celular.getText()));
                            PerfilV ventana = new PerfilV(rut.getText(), email.getText(),Integer.parseInt(celular.getText()));
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