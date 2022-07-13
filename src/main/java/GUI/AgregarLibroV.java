package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import Modelo.Biblioteca;


public class AgregarLibroV extends JFrame {
    private JLabel labelAgregarLibro;
    private JLabel labelTitulo;
    private JTextField autor;
    private JLabel labelautor;
    private JLabel labelGenero;
    private JComboBox genero;

    private JButton buttonAgregar;
    private JButton buttonRetroceder;
    private JTextField titulo;

    private String user;



    public AgregarLibroV(String rut) {
        user = rut;
        Menu();
        MenuLabel();
        MenuComboBox();
        MenuButtons();
        MenuTextField();
        ColoresLabel();
        ColoresButton();
        ColoresField();
        pack();
        setVisible(true);
    }

    public void MenuLabel() {
        // Componentes
        labelAgregarLibro = new JLabel("Agregar Libro");

        labelTitulo = new JLabel("Titulo");
        labelautor = new JLabel("Autor");
        labelGenero = new JLabel("Genero");
        // add componentes
        add(labelAgregarLibro);

        add(labelTitulo);
        add(labelautor);
        add(labelGenero);

        // Posicionamiento
        labelAgregarLibro.setBounds(130, 55, 95, 25);

        labelTitulo.setBounds(130, 105, 140, 25);
        labelautor.setBounds(130, 165, 155, 20);
        labelGenero.setBounds(130, 225, 100, 25);

    }

    public void MenuTextField() {
        // Componentes
        autor = new JTextField(5);
        titulo = new JTextField(5);

        // add componentes
        add(autor);
        add(titulo);

        // Posicionamiento
        autor.setBounds(130, 190, 250, 20);
        titulo.setBounds(130, 130, 250, 20);

    }

    public void MenuComboBox() {

        //Pre-Componentes
        String[] generosItems = {"Fantasia", "Ciencia Ficcion", "No ficcion","Bibliografia","Romance"};

        // Componentes
        genero = new JComboBox (generosItems);

        //add componentes
        add(genero);

        // Posicionamiento
        genero.setBounds(130, 250, 250, 20);

    }
    public void MenuButtons() {
        // Componentes
        buttonAgregar = new JButton("Agregar");
        buttonRetroceder = new JButton("Retroceder");

        // add componentes
        add(buttonAgregar);
        add(buttonRetroceder);

        // Posicionamiento
        buttonAgregar.setBounds(175, 290, 160, 35);
        buttonRetroceder.setBounds(15, 15, 100, 25);

        // Listener

        ActionListener regresar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                BibliotecaV ventana = new BibliotecaV(user);
                ventana.setVisible(true);
                dispose();
            }
        };

        agregar agregar = new agregar();

        // Add Listenner
        buttonAgregar.addActionListener(agregar);
        buttonRetroceder.addActionListener(regresar);

    }

    private class agregar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (autor.getText().isEmpty() || titulo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Favor de llenar los espacios vacios", "Error",         
                        JOptionPane.WARNING_MESSAGE);
            } else {
                Biblioteca biblioteca = new Biblioteca();
                biblioteca.AñadirLibro(user,titulo.getText().replace(" ", ""),autor.getText().replace(" ", ""),String.valueOf(genero.getSelectedItem()));
                JOptionPane.showMessageDialog(null, "Se ha añadido con exito", "Libro",
                        JOptionPane.INFORMATION_MESSAGE);
                PerfilLibroV ventana = new PerfilLibroV(titulo.getText(),autor.getText(),String.valueOf(genero.getSelectedItem()),user);
                ventana.setVisible(true);
                dispose();
            }
        }
    }

    public void Menu() {
        ImageIcon img = new ImageIcon("Imagenes/icon.png");
        Color colorfondo= new Color(255, 255, 254);
        setIconImage(img.getImage());
        getContentPane().setBackground(colorfondo);
        // Tamaño y Diseño
        this.setTitle("Agregar Libro");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        setLayout(null);
    }

    // COLORES

    public void ColoresLabel() {
        Color colorlabel = new Color(9, 64, 103);

        labelAgregarLibro.setForeground(colorlabel);
        labelTitulo.setForeground(colorlabel);
        labelautor.setForeground(colorlabel);
        labelGenero.setForeground(colorlabel);
    }

    public void ColoresButton() {
        Color colorButton = new Color(61, 169, 252);
        Color colortext = new Color(255, 255, 254);
        Color colorCancelar = new Color(239, 69, 101);

        buttonAgregar.setForeground(colortext);
        buttonAgregar.setBackground(colorButton);
        buttonRetroceder.setBackground(colorCancelar);
        buttonRetroceder.setForeground(colortext);
    }

    public void ColoresField() {
        Color colorField = new Color(216, 238, 254);

        titulo.setBackground(colorField);
        autor.setBackground(colorField);
        genero.setBackground(colorField);

    }

}