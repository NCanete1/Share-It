import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarTelefono {
    public void validar(){
        String telefono="+56964011305";
        validarTelefono(telefono);
        if(validarTelefono(telefono)){
            System.out.println("valido");
        }else {
            System.out.println("no valido");
        }
    }
    private static boolean validarTelefono(String telefono) {
        Pattern pattern = Pattern.compile("\\A(\\+?56)?(\\s?)(0?9)(\\s?)[9876543]\\d{7}\\z");
        Matcher m =pattern.matcher(telefono);
        return m.matches();
    }

}
