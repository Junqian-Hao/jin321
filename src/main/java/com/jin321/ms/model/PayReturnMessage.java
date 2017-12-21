package com.jin321.ms.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Tyranitarx on 2017/12/21.
 *
 * @Description :
 */
@XmlRootElement(name = "xml")
public class PayReturnMessage {
    private String return_code;
    private String return_msg;

    public String getReturn_code() {
        return return_code;
    }
    @XmlElement
    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }
    @XmlElement
    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }
}
