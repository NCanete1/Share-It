package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import Modelo.Rutas;

public class InicioSesionV extends JFrame {
    private JButton buttonIngresar;
    private JButton buttonCrearcuenta;
    private JLabel labelNoregistrado;
    private JPasswordField password;
    private JLabel labelContraseña;
    private JTextField usuario;
    private JLabel labelRut;
    private JLabel labelMensaje;
    private JLabel labelIniciosesion;

    public InicioSesionV() {
        Menu();
        MenuLabel();
        MenuButtons();
        MenuTextField();
        pack();
        setVisible(true);
    }

    public void MenuLabel() {
        // Componentes
        labelIniciosesion = new JLabel("Iniciar Sesión ");
        labelMensaje = new JLabel("Hola! Que bueno que volviste.");
        labelNoregistrado = new JLabel("Si no estas registrado, ¡Crea una cuenta! ");

        labelRut = new JLabel("Rut");
        labelContraseña = new JLabel("Contraseña");

        // add componentes
        add(labelMensaje);
        add(labelIniciosesion);
        add(labelNoregistrado);

        add(labelRut);
        add(labelContraseña);

        // Posicionamiento

        labelIniciosesion.setBounds(205, 55, 95, 25);
        labelNoregistrado.setBounds(130, 300, 235, 35);
        labelMensaje.setBounds(155, 80, 235, 25);

        labelRut.setBounds(155, 125, 100, 25);
        labelContraseña.setBounds(155, 185, 100, 25);

    }

    public void MenuTextField() {
        // Componentes
        usuario = new JTextField(5);
        password = new JPasswordField(5);

        // add componentes
        add(usuario);
        add(password);

        // Posicionamiento
        usuario.setBounds(155, 155, 170, 20);
        password.setBounds(155, 215, 170, 20);

    }

    public void MenuButtons() {
        // Componentes
        buttonIngresar = new JButton("Ingresar");
        buttonCrearcuenta = new JButton("crear cuenta");

        // add componentes
        add(buttonIngresar);
        add(buttonCrearcuenta);

        // Posicionamiento
        buttonIngresar.setBounds(155, 265, 170, 30);
        buttonCrearcuenta.setBounds(190, 360, 110, 20);

        // Listener
        Ingresar ingresar = new Ingresar();
        Crear crear = new Crear();

        // Añadir Acciones

        buttonIngresar.addActionListener(ingresar);
        buttonCrearcuenta.addActionListener(crear);

    }

    // ActionListener

    private class Crear implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            CrearCuentaV ventana = new CrearCuentaV();
            ventana.setVisible(true);
            dispose();
        }
    }

    public class Ingresar implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (usuario.getText().isEmpty() || password.getPassword().length == 0) {
                JOptionPane.showMessageDialog(null, "Favor de llenar los espacios vacios");
            } else {
                // Check if the password is correct
                Rutas ruta = new Rutas();
                if ((ruta.LeerUsuario(usuario.getText(), 0)).equals(String.valueOf(password.getPassword()))) {
                    PerfilV ventana = new PerfilV(usuario.getText().replace(".", "").replace(",", ""));
                    ventana.setVisible(true);
                    dispose();

                } else {
                    JOptionPane.showMessageDialog(null,
                            "Usuario o Contraseña Incorrecto. \n Revise con detalle los datos ingresados.");
                }
            }
        }
    }

    public void Menu() {
        // Tamaño y Diseño
        this.setTitle("Iniciar Sesion");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        setLayout(null);
    }

}
