package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Modelo.Rutas;
import Validadores.ValidadorRut;

public class InicioSesionV extends JFrame {
    private JButton buttonIngresar;
    private JButton buttonCrearcuenta;

    private JPasswordField password;
    private JTextField usuario;

    private JLabel labelRut;
    private JLabel labelMensaje;
    private JLabel labelIniciosesion;
    private JLabel labelContraseña;
    private JLabel labelNoregistrado;

    public InicioSesionV() {
        Menu();
        MenuLabel();
        MenuButtons();
        MenuTextField();
        ColoresLabel();
        ColoresButton();
        ColoresField();
        extras();
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

        labelIniciosesion.setBounds(205, 180, 95, 25);
        labelNoregistrado.setBounds(130, 380, 235, 35);
        labelMensaje.setBounds(155, 200, 235, 25);

        labelRut.setBounds(155, 225, 160, 25);
        labelContraseña.setBounds(155, 285, 100, 25);

    }

    public void MenuTextField() {
        // Componentes
        usuario = new JTextField(5);
        password = new JPasswordField(5);

        // add componentes
        add(usuario);
        add(password);

        // Posicionamiento
        usuario.setBounds(155, 255, 170, 20);
        password.setBounds(155, 315, 170, 20);

    }

    public void MenuButtons() {
        // Componentes
        buttonIngresar = new JButton("Ingresar");
        buttonCrearcuenta = new JButton("crear cuenta");

        // add componentes
        add(buttonIngresar);
        add(buttonCrearcuenta);

        // Posicionamiento
        buttonIngresar.setBounds(155, 345, 170, 30);
        buttonCrearcuenta.setBounds(190, 420, 110, 20);

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
                if ((ruta.LeerUsuario(ValidadorRut.Normalizar(usuario.getText()), 0)).equals(String.valueOf(password.getPassword()))) {
                    PerfilV ventana = new PerfilV(ValidadorRut.Normalizar(usuario.getText()));
                    ventana.setVisible(true);
                    dispose();

                } else {
                    JOptionPane.showMessageDialog(null,
                            "Usuario o Contraseña Incorrecto. \n Revise con detalle los datos ingresados.");
                }
            }
        }
    }
    public void extras() {
        JLabel imagen= new JLabel();
        imagen.setIcon(new ImageIcon("Imagenes/Image.png"));
        add(imagen);
        imagen.validate();

        imagen.setBounds(180, 20,150,150);

    }

    public void Menu() { 
        ImageIcon img = new ImageIcon("Imagenes/icon.png");
        Color colorfondo= new Color(255, 255, 254);
        setIconImage(img.getImage());
        getContentPane().setBackground(colorfondo);
        // Tamaño y Diseño
        this.setTitle("Share-it");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        setLayout(null);
    }

    //COLORES

    public void ColoresLabel(){
        Color colorlabel= new Color(9, 64, 103);
        labelRut.setForeground(colorlabel);
        labelMensaje.setForeground(colorlabel);
        labelNoregistrado.setForeground(colorlabel);
        labelContraseña.setForeground(colorlabel);
        labelIniciosesion.setForeground(colorlabel);
    }
    public void ColoresButton(){
        Color colorButton= new Color(61, 169, 252);
        Color colortext= new Color(255, 255, 254);
        buttonIngresar.setForeground(colortext);
        buttonIngresar.setBackground(colorButton);
        buttonCrearcuenta.setBackground(colorButton);
        buttonCrearcuenta.setForeground(colortext); 
    }

    public void ColoresField(){
        Color colorButton= new Color(216, 238, 254);
       
        password.setBackground(colorButton);
        usuario.setBackground(colorButton);
      
    }

}
