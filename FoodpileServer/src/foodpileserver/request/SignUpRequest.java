package foodpileserver.request;
/**
 *
 * @author SHRESHTH
 */
import java.io.Serializable;
import foodpileserver.constants.RequestCode;

public class SignUpRequest extends Request implements Serializable{
  private String fname,lname,username,password;
 /* public SignUpRequest(String fname,String lname,String username,String password)
  {
      this.fname=fname;
      this.lname=lname;
      this.username=username;
      this.password=password;
  }*/

public String getFname(){
    return fname;
}
public void setFname(String fname) {
        this.fname = fname;
    }
public String getLname() {
        return lname;
    }
public void setLname(String lname) {
        this.lname = lname;
    }
public String getUsername(){
    return username;
}
public void setUsername(String username){
    this.username=username;
}
public String getPassword(){
    return password;
}
public void setPassword(String password){
    this.password=password;
}
@Override
public RequestCode getRequestCode(){
        return RequestCode.SIGNUP_REQUEST;
}
    
}
