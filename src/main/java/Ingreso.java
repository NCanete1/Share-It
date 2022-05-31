import java.awt.*;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ingreso implements ActionListener {

    JFrame frame = new JFrame();
    JButton botonDeIngreso = new JButton("Ingresar");
    JButton botonBorrar = new JButton("Borrar");
    JButton botonRegistro = new JButton("Registrate");
    JTextField campoUsuario = new JTextField();
    JPasswordField campoContraseña = new JPasswordField();
    JLabel txtReferenciaUsuario = new JLabel("Usuario:");
    JLabel txtReferenciaContraseña = new JLabel("Contraseña:");
    JLabel alerta = new JLabel();

    HashMap<String,String> logininfo = new HashMap<String, String>();

    Ingreso(HashMap<String,String> loginInfoOriginal){

        logininfo = loginInfoOriginal;

        txtReferenciaUsuario.setBounds(50, 100, 75, 25);
        txtReferenciaContraseña.setBounds(50, 150, 75, 25);

        alerta.setBounds(125, 250, 250, 35);
        alerta.setFont(new Font(null,Font.ITALIC, 25));

        campoUsuario.setBounds(125, 100, 200, 25);
        campoContraseña.setBounds(125, 150, 200, 25);

        botonDeIngreso.setBounds(125, 200, 100,25);
        botonDeIngreso.addActionListener(this);

        botonBorrar.setBounds(225,200,100,25);
        botonBorrar.addActionListener(this);

        botonRegistro.setBounds(225,230,100,25);
        botonRegistro.addActionListener(this);

        frame.add(txtReferenciaUsuario);
        frame.add(txtReferenciaContraseña);
        frame.add(alerta);
        frame.add(campoUsuario);
        frame.add(campoContraseña);
        frame.add(botonDeIngreso);
        frame.add(botonBorrar);
        frame.add(botonRegistro);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource()== botonBorrar){
            campoUsuario.setText("");
            campoContraseña.setText("");
        }
        if(e.getSource()== botonRegistro){
            frame.dispose();
            Registro registro = new Registro();
        }
        if(e.getSource()== botonDeIngreso){
            String userID = campoUsuario.getText();
            String password = String.valueOf(campoContraseña.getPassword());

            if(logininfo.containsKey(userID)){
                if(logininfo.get(userID).equals(password)){
                    frame.dispose();
                    Bienvenida bienvenida = new Bienvenida();
                }
                else{
                    alerta.setForeground(Color.red);
                    alerta.setText("Contraseña incorrecta");
                }
            }
            else{
                alerta.setForeground(Color.red);
                alerta.setText("El usuario no existe");
            }
        }
    }
}
