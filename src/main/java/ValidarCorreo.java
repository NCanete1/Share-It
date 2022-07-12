


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarCorreo {

    public static Boolean validaEmail(String email) {
        Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public void Validar(){
        if (!ValidarCorreo.validaEmail("j.huircaleo01@ufromail.cl")) {
            System.out.println("Email Incorrecto");
        }else{
            System.out.println("Correcto");
        }
    }


}