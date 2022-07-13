package GUI;

import java.awt.*;
import java.awt.event.*;

import java.util.List;

import javax.swing.*;

import Modelo.Biblioteca;

public class BibliotecaV extends JFrame {
    private DefaultListModel<String> myListModel;
    private JButton buttonBuscar;
    private JButton buttonAgregar;
    private JButton buttonRegresar;
    private JList listLibros;
    private JList listaGenero;
    private JTextField fieldFiltro;
    private JLabel labelBiblioteca;
    private JLabel labelFiltro;
    private JComboBox filtro;

    private String userrut;

    public BibliotecaV(String rut) {
        userrut = rut;
        Menu();
        MenuLabel();
        MenuButtons();
        MenuJComboBox();
        MenuTextField();
        MenuList();
        ColoresLabel();
        ColoresButton();
        ColoresField();
        pack();
        setVisible(true);
    }

    public void MenuLabel() {
        // Componentes
        labelBiblioteca = new JLabel("Biblioteca");
        labelFiltro = new JLabel("Filtro por Genero");

        // add componentes
        add(labelBiblioteca);
        add(labelFiltro);

        // Posicionamiento
        labelBiblioteca.setBounds(225, 40, 65, 25);
        labelFiltro.setBounds(210, 205, 100, 20);
    }

    public void MenuTextField() {
        // Componentes
        fieldFiltro = new JTextField(5);

        // add componentes
        add(fieldFiltro);

        // Posicionamiento
        fieldFiltro.setBounds(100, 75, 320, 25);

    }

    public void MenuButtons() {
        // Componentes
        buttonBuscar = new JButton("🔍️");
        buttonAgregar = new JButton("➕");
        buttonRegresar = new JButton("regresar");

        // add componentes
        add(buttonBuscar);
        add(buttonAgregar);
        add(buttonRegresar);

        // Posicionamiento
        buttonBuscar.setBounds(0, 40, 50, 20);
        buttonAgregar.setBounds(450, 40, 50, 20);
        buttonRegresar.setBounds(0, 0, 90, 20);

        // ActionListener

        ActionListener buscar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                BuscarLibroV ventana = new BuscarLibroV(userrut);
                ventana.setVisible(true);
                dispose();

            }
        };

        ActionListener agregar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                AgregarLibroV ventana = new AgregarLibroV(userrut);
                ventana.setVisible(true);
                dispose();

            }
        };

        ActionListener regresar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                PerfilV ventana = new PerfilV(userrut);
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
        // Pre componentes, Definir las listas, arrays...
        Biblioteca biblioteca = new Biblioteca();
        List<String> list = biblioteca.leerLibros(userrut);
        myListModel = new DefaultListModel<String>();

        String[] listLibrosItems = list.toArray(new String[0]);
        // Componentes
        listLibros = new JList(listLibrosItems);
        listaGenero = new JList<String>(myListModel);

        // add componentes
        add(listLibros);
        add(listaGenero);

        // Propiedades
        listLibros.setEnabled(false);
        listaGenero.setEnabled(false);

        // Posicionamiento
        listLibros.setBounds(110, 120, 300, 80);
        listaGenero.setBounds(110, 265, 300, 165);

        // Listeners

        // Añadir Acciones
    }

    public void MenuJComboBox() {

        // Pre componentes, Definir las listas, arrays...
        String[] filtroItems = { "Fantasia", "CienciaFiccion", "Noficcion", "Bibliografia", "Romance" };

        // Componentes
        filtro = new JComboBox<String>(filtroItems);

        // add componentes
        add(filtro);

        // Posicionamiento
        filtro.setBounds(170, 230, 180, 20);

        // Listeners
        iTems items = new iTems();
        // Añadir Acciones
        filtro.addItemListener(items);
    }

    private class iTems implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent il) {
            if (il.getStateChange() == ItemEvent.SELECTED) {
                String[] jListItems = selecionarItems(filtro.getSelectedIndex());
                myListModel.removeAllElements();
                for (String s : jListItems)
                    myListModel.addElement(s);
            }
        }
    }

    private String[] selecionarItems(int selection) {

        Biblioteca biblioteca = new Biblioteca();
        List<String> list = biblioteca.leerLibros(userrut);
        List<String> listafiltrada = biblioteca.filtrarGenero("Fantasia", userrut);
        String[] listaGeneroItems;
        switch (selection) {
            case 0:
                listafiltrada = biblioteca.filtrarGenero("Fantasia", userrut);
                listaGeneroItems = listafiltrada.toArray(new String[0]);
                return listaGeneroItems;
            case 1:
                listafiltrada = biblioteca.filtrarGenero("CienciaFiccion", userrut);
                listaGeneroItems = listafiltrada.toArray(new String[0]);
                return listaGeneroItems;
            case 2:
                listafiltrada = biblioteca.filtrarGenero("Noficcion", userrut);
                listaGeneroItems = listafiltrada.toArray(new String[0]);
                return listaGeneroItems;
            case 3:
                listafiltrada = biblioteca.filtrarGenero("Bibliografia", userrut);
                listaGeneroItems = listafiltrada.toArray(new String[0]);
                return listaGeneroItems;
            case 4:
                listafiltrada = biblioteca.filtrarGenero("Romance", userrut);
                listaGeneroItems = listafiltrada.toArray(new String[0]);
                return listaGeneroItems;
            default:
                list = biblioteca.leerLibros(userrut);
                listaGeneroItems = list.toArray(new String[0]);
                return listaGeneroItems;
        }

    }

    public void Menu() {
        ImageIcon img = new ImageIcon("Imagenes/icon.png");
        Color colorfondo = new Color(255, 255, 254);
        setIconImage(img.getImage());
        getContentPane().setBackground(colorfondo);
        // Tamaño y Diseño
        this.setTitle("Biblioteca");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        setLayout(null);
    }

    // COLORES

    public void ColoresLabel() {
        Color colorlabel = new Color(9, 64, 103);

        labelBiblioteca.setForeground(colorlabel);
        labelFiltro.setForeground(colorlabel);
    }

    public void ColoresButton() {
        Color colorButton = new Color(61, 169, 252);
        Color colortext = new Color(255, 255, 254);
        Color colorCancelar = new Color(239, 69, 101);

        buttonBuscar.setForeground(colorButton);
        buttonBuscar.setBackground(colortext);
        buttonAgregar.setForeground(colorButton);
        buttonAgregar.setBackground(colortext);
        buttonRegresar.setBackground(colorCancelar);
        buttonRegresar.setForeground(colortext);
    }

    public void ColoresField() {
        Color colorField = new Color(216, 238, 254);

        fieldFiltro.setBackground(colorField);
        filtro.setBackground(colorField);
        listLibros.setBackground(colorField);
        listaGenero.setBackground(colorField);

    }

}
