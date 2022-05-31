import java.util.HashMap;

public class IdentificacionYContraseña {

    HashMap<String, String> loginInfo = new HashMap<String, String>();

    IdentificacionYContraseña(){

        loginInfo.put("1", "1");
        loginInfo.put("2", "2");
        loginInfo.put("3", "3");

    }
     protected HashMap getLoginInfo(){
        return loginInfo;
    }
}
