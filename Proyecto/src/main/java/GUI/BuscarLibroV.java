package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class BuscarLibroV extends JFrame {
    private JLabel labelAgregarLibro;
    private JLabel labelTitulo;
    private JTextField autor;
    private JLabel labelautor;
    private JLabel labelGenero;
    private JTextField genero;
    private JButton buttonBuscar;
    private JButton buttonRetroceder;
    private JTextField titulo;

    public BuscarLibroV() {
        Menu();
        MenuLabel();
        MenuButtons();
        MenuTextField();
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
        genero = new JTextField(5);
        titulo = new JTextField(5);

        // add componentes
        add(autor);
        add(genero);
        add(titulo);

        // Posicionamiento
        autor.setBounds(130, 190, 250, 20);
        genero.setBounds(130, 250, 250, 20);
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

        //Listerner
        ActionListener buscar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (titulo.getText().isEmpty() && autor.getText().isEmpty() && genero.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Favor de llenar los campos vacios");
                }else{
                PerfilLibroV ventana = new PerfilLibroV(titulo.getText(),autor.getText(),genero.getText());
                ventana.setVisible(true);
                dispose();
                }
            }
        };

        ActionListener regresar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                BibilotecaV ventana = new BibilotecaV();
                ventana.setVisible(true);
                dispose();
            }
        };

        //Add
        buttonBuscar.addActionListener(buscar);
        buttonRetroceder.addActionListener(regresar);

    }

    public void Menu() {
        // Tamaño y Diseño
        this.setTitle("Buscar Libro");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        setLayout(null);
    }

}