package foodpileserver.request;

/**
 *
 * @author SHRESHTH
 */
import foodpileserver.constants.RequestCode;
import java.io.Serializable;

public abstract class Request implements Serializable {
    public abstract RequestCode getRequestCode();
    
}
