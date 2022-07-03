package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class BibilotecaV extends JFrame {
    private JButton buttonBuscar;
    private JButton buttonAgregar;
    private JButton buttonRegresar;
    private JList listLibros;
    private JList listaGenero;
    private JTextField fieldFiltro;
    private JLabel labelBiblioteca;

    public BibilotecaV() {
        Menu();
        MenuLabel();
        MenuButtons();
        MenuTextField();
        MenuList();
        pack();
        setVisible(true);
    }

    public void MenuLabel() {
        // Componentes
        labelBiblioteca = new JLabel ("Biblioteca");

        // add componentes
        add (labelBiblioteca);

        // Posicionamiento
        labelBiblioteca.setBounds (225, 40, 65, 25);
    }

    public void MenuTextField() {
        // Componentes
        fieldFiltro = new JTextField (5);

        // add componentes
        add (fieldFiltro);

        // Posicionamiento
        fieldFiltro.setBounds (100, 75, 320, 25);

    }

    public void MenuButtons() {
        // Componentes
        buttonBuscar = new JButton ("🔍️");
        buttonAgregar = new JButton ("➕");
        buttonRegresar = new JButton ("regresar");

        // add componentes
        add (buttonBuscar);
        add (buttonAgregar);
        add (buttonRegresar);

        // Posicionamiento
        buttonBuscar.setBounds (0, 40, 50, 20);
        buttonAgregar.setBounds (450, 40, 50, 20);
        buttonRegresar.setBounds (0, 0, 90, 20);

        // ActionListener

        ActionListener buscar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                BuscarLibroV ventana = new BuscarLibroV();
                ventana.setVisible(true);
                dispose();
           
            }
        };

        ActionListener agregar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                AgregarLibroV ventana = new AgregarLibroV();
                ventana.setVisible(true);
                dispose();
           
            }
        };

        ActionListener regresar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                PerfilV ventana = new PerfilV();
                ventana.setVisible(true);
                dispose();
            }
        };

        // Añadir Acciones
        buttonBuscar.addActionListener(buscar);
        buttonAgregar.addActionListener(agregar);
        buttonRegresar.addActionListener(regresar);

    }

    public void MenuList() {
        //Pre componentes, Definir las listas, arrays...
        String[] listLibrosItems = {"Libro 1","Libro 2","Libro 3"};
        String[] listaGeneroItems = {"Libros subdivididos en Generos","Aventura","Ciencia Ficcion","Fantasia","No ficcion"};

    
        // Componentes
        listLibros = new JList (listLibrosItems);
        listaGenero = new JList (listaGeneroItems);
        
        // add componentes
        add (listLibros);
        add (listaGenero);

        //Propiedades
        listLibros.setEnabled (false);
        listaGenero.setEnabled (false);

        // Posicionamiento
        listLibros.setBounds (110, 120, 300, 80);
        listaGenero.setBounds (110, 250, 300, 165);

        //Listeners

         // Añadir Acciones
    }

    

    public void Menu() {
        // Tamaño y Diseño
        this.setTitle("Agregar Libro");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        setLayout(null);
    }

}
