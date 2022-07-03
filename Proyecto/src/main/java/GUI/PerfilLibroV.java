package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class PerfilLibroV extends JFrame {
    private JButton buttonRegresar;
    private JList listaContactos;
    private JTextField fieldTitulo;
    private JTextField fieldAutor;
    private JTextField fieldGenero;
    private JLabel labelContacto;

    public PerfilLibroV(String Titulo, String Autor, String Genero) {
        Menu();
        MenuLabel();
        MenuButtons();
        MenuTextField(Titulo, Autor, Genero);
        MenuList();
        pack();
        setVisible(true);
    }

    public void MenuLabel() {
        // Componentes
        labelContacto = new JLabel ("Personas que tienen el libro:");

        // add componentes
        add (labelContacto);

        // Posicionamiento
        labelContacto.setBounds (105, 155, 180, 25);

    }

    public void MenuTextField(String Titulo, String Autor, String Genero) {
        // Componentes
        fieldTitulo = new JTextField (Titulo);
        fieldAutor = new JTextField (Autor);
        fieldGenero = new JTextField (Genero);

        //Propiedades
        fieldTitulo.setEnabled (false);
        fieldAutor.setEnabled (false);
        fieldGenero.setEnabled (false);

        // add componentes
        add (fieldTitulo);
        add (fieldAutor);
        add (fieldGenero);

        // Posicionamiento
        fieldTitulo.setBounds (110, 45, 320, 25);
        fieldAutor.setBounds (205, 80, 145, 20);
        fieldGenero.setBounds (205, 110, 145, 20);

        //Listener

        //Add listener

    }

    public void MenuButtons() {

        // Componentes
        buttonRegresar = new JButton ("regresar");

        // add componentes
        add (buttonRegresar);

        // Posicionamiento
        buttonRegresar.setBounds (0, 0, 85, 20);

        // Listener
        ActionListener regresar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                BuscarLibroV ventana = new BuscarLibroV();
                ventana.setVisible(true);
                dispose();
            }
        };

        //Add
        buttonRegresar.addActionListener (regresar);

    }

    public void MenuList() {
        //Pre componentes, Definir las listas, arrays...
        String[] listaContactosItems = {"Nombre, Apellido 1", "Nombre, Apellido 2"};
    
        // Componentes
        listaContactos = new JList (listaContactosItems);

        //Propiedades
        listaContactos.setEnabled (true);
        
        // add componentes
        add (listaContactos);

        // Posicionamiento
        listaContactos.setBounds (105, 180, 320, 240);

        //Listeners

        listaContactos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {
                    JOptionPane.showMessageDialog(null, list.getSelectedValue());
        
                    // Double-click detected
                    int index = list.locationToIndex(evt.getPoint());
                } else if (evt.getClickCount() == 3) {
        
                    // Triple-click detected
                    int index = list.locationToIndex(evt.getPoint());
                }
            }
        });

        
         // Añadir Acciones


    }

    public void Menu() {
        // Tamaño y Diseño
        this.setTitle("Buscar Libro");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        setLayout(null);
    }

}
