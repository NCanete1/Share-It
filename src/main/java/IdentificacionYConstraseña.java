import java.util.HashMap;
public class IdentificacionYConstraseña {

    HashMap<String, String> loginInfo = new HashMap<String, String>();

    IdentificacionYConstraseña(){

        loginInfo.put("1", "1");
        loginInfo.put("2", "2");
        loginInfo.put("3", "3");

    }
    protected HashMap getLoginInfo(){
        return loginInfo;
    }
}
