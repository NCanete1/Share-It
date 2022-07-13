package Validadores;

public class ValidadorRut {
    public static String Rut(String rut) {
        try {
            for (int i = 0; i < rut.length(); i++) {
                if (!Character.isDigit(rut.charAt(i))) {
                    rut = "";
                } else if (2 >= rut.length()) {
                    rut = "";
                    break;
                } else {
                }
            }
        } catch (Exception e) {
        }
        return rut;
    }

    public static String Menor(String rut) {
        rut = Rut(rut);
        int size = rut.length();
        if (size < 8) {
            rut = rut + "0";
        }
        return rut;
    }

    public static String Normalizar(String rut) {
        rut = rut.toLowerCase();
        rut= rut.replace(" ", "").replace("-","").replace(".", "");
        rut = rut.substring(0, rut.length()-1);
        return rut;
    }

    public static String Invertir(String rut) {
        StringBuilder rut_Inv = new StringBuilder(rut);
        rut = rut_Inv.reverse().toString(); // cambiar de vuelta al tipo de variable String
        return rut;
    }

    public static int Verificacion1(String rut) { // Se adquiere la suma de la multiplicaciones para un paso más tarde.
        char[] cadena = Menor(Invertir(rut)).toCharArray();
        int sum = 0;
        int number;
        int multipicador = 2; // variables, multiplicador va de 2 al 7.
        for (int i = 0; i <= 7; i = i + 1) { // Recorre la cadena
            number = Integer.parseInt(String.valueOf(cadena[i])); // convierte el char a String y de String a Int.
                                                                  // Muchas vuelta? posiblemente si, conozco una forma
                                                                  // mas simple? no.
            sum += number * (multipicador);
            multipicador += 1;
            if (multipicador > 7) { // en caso que supere al 7 se reinicia el multiplicador.
                multipicador = 2;
            }
        }
        return sum;
    }

    public static int Verificacion2(String rut) {
        int valor1 = Verificacion1(rut); // el resultado de sum. Verificacion1.
        int valor2 = valor1 / 11; // El resultado puede llegar a dar decimales pero solo se pide el valor entero,
                                  // por eso el Int.
        valor2 = valor2 * 11;
        return valor1 - valor2;
    }

    public static int Digito(String rut) {
        int digito = Verificacion2(rut);
        return 11 - digito;
    }

    public static String DigitoVerificador(String rut) {
        int digito = Digito(Normalizar(rut));
        String verificado;
        if (digito == 10) {
            verificado = "k";
        } else if (digito == 11) {
            verificado = "0";
        } else {
            verificado = String.valueOf(digito);
        }
        return verificado;
    }

    public static String LastDigit(String rut) {
        int digitoint = rut.length();
        char digito = rut.charAt((digitoint - 1));
        return Character.toString(digito);
    }

    public static boolean Verificacion(String rut) {
        String rutn= rut.toLowerCase().replace("k", "0"); 
        if (rut.equals("")) {
            return false;
        }
        if (rutn.contains("[a-zA-Z]+")) {
            return false;
        }
        return DigitoVerificador(rut.toLowerCase()).equals(LastDigit(rut.toLowerCase()));
    }

}
