package foodpileserver.authentication;
/**
 *
 * @author SHRESHTH
 */
import foodpileserver.constants.ResponseCode;
import foodpileserver.main.Main;
import foodpileserver.request.LoginRequest;
import foodpileserver.request.Response;
import foodpileserver.request.SignUpRequest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

       public class Login {
           private LoginRequest loginrequest;
           public Login(LoginRequest loginrequest){
               this.loginrequest=loginrequest;
           }
            public Response getResponse() {
                SignUpRequest signup;
        

        String query = "SELECT * FROM client  WHERE client.username=\"" +
                loginrequest.getUsername() + "\" AND client.password = \"" + loginrequest.getPassword()+"\"";
        try {
            PreparedStatement preparedStatement = Main.connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            if(!rs.next()){
                return new Response (null, ResponseCode.FAILED);
            }
            signup=new SignUpRequest();
            signup.setFname(rs.getString(1));
            signup.setLname(rs.getString(2));
            signup.setUsername(rs.getString(3));
            signup.setPassword(rs.getString(4));
            return new Response(signup,ResponseCode.SUCCESS);

        }catch (SQLException e){
            e.printStackTrace();
        }
        return new Response(null,ResponseCode.FAILED);

    }

}
    

