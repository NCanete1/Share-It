package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class BuscarLibroV extends JFrame {
    private JLabel labelAgregarLibro;
    private JLabel labelTitulo;
    private JLabel labelautor;
    private JLabel labelGenero;
   
    private JTextField autor;
    private JTextField titulo;

    private JButton buttonBuscar;
    private JButton buttonRetroceder;

    private JComboBox genero;
  

    private String user;

    public BuscarLibroV(String rut) {
        user = rut;
        Menu();
        MenuLabel();
        MenuButtons();
        MenuComboBox();
        MenuTextField();
        ColoresLabel();
        ColoresButton();
        ColoresField();
        pack();
        setVisible(true);
    }

    public void MenuLabel() {
        // Componentes
        labelAgregarLibro = new JLabel("Buscar Libro");

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

    public void MenuButtons() {
        // Componentes
        buttonBuscar = new JButton("Buscar");
        buttonRetroceder = new JButton("Retroceder");

        // add componentes
        add(buttonBuscar);
        add(buttonRetroceder);

        // Posicionamiento
        buttonBuscar.setBounds(175, 290, 160, 35);
        buttonRetroceder.setBounds(15, 15, 100, 25);

        //Listener
        ActionListener buscar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (titulo.getText().isEmpty() || autor.getText().isEmpty() ) {
                    JOptionPane.showMessageDialog(null, "Favor de llenar los campos vacios");
                }else{
                PerfilLibroV ventana = new PerfilLibroV(titulo.getText(),autor.getText(),String.valueOf(genero.getSelectedItem()),user);
                ventana.setVisible(true);
                dispose();
                }
            }
        };

        ActionListener regresar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                BibliotecaV ventana = new BibliotecaV(user);
                ventana.setVisible(true);
                dispose();
            }
        };

        //Add
        buttonBuscar.addActionListener(buscar);
        buttonRetroceder.addActionListener(regresar);

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

    public void Menu() {
        ImageIcon img = new ImageIcon("Imagenes/icon.png");
        Color colorfondo= new Color(255, 255, 254);
        setIconImage(img.getImage());
        getContentPane().setBackground(colorfondo);
        // Tamaño y Diseño
        this.setTitle("Buscar Libro");
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

        buttonBuscar.setForeground(colortext);
        buttonBuscar.setBackground(colorButton);
        buttonRetroceder.setBackground(colorCancelar);
        buttonRetroceder.setForeground(colortext);
    }

    public void ColoresField() {
        Color colorField = new Color(216, 238, 254);

        autor.setBackground(colorField);
        titulo.setBackground(colorField);
        genero.setBackground(colorField);

    }

}