package java.request;
import java.constants.RequestCode;

import java.io.Serializable;

public abstract class Request implements Serializable {
    public abstract RequestCode getRequestCode();
}

