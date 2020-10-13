package foodpileserver.authentication;

/**
 *
 * @author SHRESHTH
 */
import foodpileserver.constants.ResponseCode;
import foodpileserver.main.Main;
import foodpileserver.request.Response;
import foodpileserver.request.SignUpRequest;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUp implements Serializable
{
    private String fname, lname,username, password;
   
    public SignUp(SignUpRequest request){
        this.fname=request.getFname();
        this.lname=request.getLname();
        this.password=request.getPassword();
        this.username=request.getUsername();
    }

    public Response insert()
    {
        String q="INSERT INTO User VALUES (?,?,?,?);";
        try
        {
            PreparedStatement stmt= Main.connection.prepareStatement(q);
            stmt.setString(1,this.fname);
            stmt.setString(2,this.lname);
            stmt.setString(3,this.username);
            stmt.setString(4,this.password);
            stmt.executeUpdate();

           

            return new Response(null, ResponseCode.SUCCESS);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return new Response(null,ResponseCode.FAILED);
    }
}

