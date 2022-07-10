package Main;
import java.io.IOException;
import java.util.List;

import Datos.Biblioteca;



public class main {
    public static void main(String[] args) throws IOException {
        Biblioteca  rutas = new Biblioteca();
        List<String> list=rutas.sortGeneroEspecifico("fantasia","123456785");
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        } 
} 
}
