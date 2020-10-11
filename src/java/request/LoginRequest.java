package java.request;

import java.constants.RequestCode;
import java.io.Serializable;

public class LoginRequest extends Request implements Serializable {
    private String username;
    private String password;

    public LoginRequest(String username,String password){
        this.username=username;
        this.password=password;
    }
    /* public login(String name,String username,String password){
         this.username=username;
         this.password=password;
         this.name=name;
     }*/
    public String getusername(){
        return username;
    }
    public void setusername(String username){
        this.username=username;
    }
    public String getpassword()
    {
        return password;
    }
    public void setpassword(String password){
        this.password=password;
    }
    public RequestCode getRequestCode(){
        return RequestCode.LOGIN_REQUEST;
    }
}

