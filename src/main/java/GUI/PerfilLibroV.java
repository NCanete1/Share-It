package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

import javax.swing.*;


import Modelo.Biblioteca;
import Modelo.Rutas;

public class PerfilLibroV extends JFrame {
    private JButton buttonRegresar;
    private JList listaContactos;
    private JTextField fieldTitulo;
    private JTextField fieldAutor;
    private JTextField fieldGenero;
    private JLabel labelContacto;

    private String user;
    private String libro;
    Rutas ruta;

    public PerfilLibroV(String titulo, String autor, String genero, String rut) {
        user = rut;
        libro = titulo;
        Menu();
        MenuLabel();
        MenuButtons();
        MenuTextField(titulo, autor, genero);
        MenuList(titulo, autor, genero);
        ColoresLabel();
        ColoresButton();
        ColoresField();
        pack();
        setVisible(true);
    }

    public void MenuLabel() {
        // Componentes
        labelContacto = new JLabel("Personas que tienen el libro:");

        // add componentes
        add(labelContacto);

        // Posicionamiento
        labelContacto.setBounds(105, 155, 180, 25);

    }

    public void MenuTextField(String Titulo, String Autor, String Genero) {
        // Componentes
        fieldTitulo = new JTextField(Titulo);
        fieldAutor = new JTextField(Autor);
        fieldGenero = new JTextField(Genero);

        // Propiedades
        fieldTitulo.setEnabled(false);
        fieldAutor.setEnabled(false);
        fieldGenero.setEnabled(false);

        // add componentes
        add(fieldTitulo);
        add(fieldAutor);
        add(fieldGenero);

        // Posicionamiento
        fieldTitulo.setBounds(110, 45, 320, 25);
        fieldAutor.setBounds(205, 80, 145, 20);
        fieldGenero.setBounds(205, 110, 145, 20);

        // Listener

        // Add listener

    }

    public void MenuButtons() {

        // Componentes
        buttonRegresar = new JButton("regresar");

        // add componentes
        add(buttonRegresar);

        // Posicionamiento
        buttonRegresar.setBounds(0, 0, 85, 20);

        // Listener
        ActionListener regresar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                BuscarLibroV ventana = new BuscarLibroV(user);
                ventana.setVisible(true);
                dispose();
            }
        };

        // Add
        buttonRegresar.addActionListener(regresar);

    }

    public void MenuList(String titulo, String autor, String genero) {
        // Pre componentes, Definir las listas, arrays...
        Biblioteca biblioteca = new Biblioteca();
        List<String> lista = biblioteca.conversionNombre(biblioteca.buscarLibro(genero, libro, autor));

        // Componentes
        String[] listaContactosItems = lista.toArray(new String[0]);

        // Componentes
        listaContactos = new JList(listaContactosItems);

        // Propiedades
        listaContactos.setEnabled(true);

        // add componentes
        add(listaContactos);

        // Posicionamiento
        listaContactos.setBounds(105, 180, 320, 240);

        // Listeners

        listaContactos.addMouseListener(new MouseAdapter() {
            Biblioteca biblioteca = new Biblioteca();
            List<String> lista = biblioteca.buscarLibro(genero, libro, autor);

            public void mouseClicked(MouseEvent evt) {

                JList list = (JList) evt.getSource();
                if (evt.getClickCount() == 2) {
                    PerfilV ventana = new PerfilV(lista.get(list.getSelectedIndex()),
                            lista.get(list.getSelectedIndex()));
                    ventana.setVisible(true);
                }
            }
        });
    }

    public void Menu() {
        ImageIcon img = new ImageIcon("Imagenes/icon.png");
        Color colorfondo= new Color(255, 255, 254);
        setIconImage(img.getImage());
        getContentPane().setBackground(colorfondo);
        // Tamaño y Diseño
        this.setTitle(libro.toUpperCase());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        setLayout(null);
    }

    // COLORES

    public void ColoresLabel() {
        Color colorlabel = new Color(9, 64, 103);

        labelContacto.setForeground(colorlabel);
    }

    public void ColoresButton() {
        Color colortext = new Color(255, 255, 254);
        Color colorCancelar = new Color(239, 69, 101);

        buttonRegresar.setBackground(colorCancelar);
        buttonRegresar.setForeground(colortext);
    }

    public void ColoresField() {
        Color colorField = new Color(216, 238, 254);

        fieldTitulo.setBackground(colorField);
        fieldAutor.setBackground(colorField);
        fieldGenero.setBackground(colorField);
        listaContactos.setBackground(colorField);

    }

}
