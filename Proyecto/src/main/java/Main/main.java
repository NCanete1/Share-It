package Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import GUI.InicioSesionV;

public class main {
    public static void main(String[] args) throws IOException {
        InicioSesionV ventana = new InicioSesionV();
        ventana.isVisible();
    }
}
/*
 * InicioSesionV ventana = new InicioSesionV();
 * ventana.isVisible();
 */
