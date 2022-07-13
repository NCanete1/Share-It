package Validadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Telefono {

    public static final String Verificacion = "^(\\+?56)?(\\s?)(0?9)(\\s?)[98765432]\\d{7}$";

    private static Pattern p;
    private static Matcher m;

    public static boolean validarTelefono(String telefono) {
        //Phone validation
        p = Pattern.compile(Verificacion);
        m = p.matcher("+569"+telefono);
        boolean isPhoneValid = m.matches();
        if (!isPhoneValid) {
            return false;
        } else {
            return true;
        }
    }

}
