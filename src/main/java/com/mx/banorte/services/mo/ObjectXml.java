package com.mx.banorte.services.mo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class ObjectXml {

    private String tipoAutenticacion;
    private String respUsuario;
    private boolean respBinaria;
    private String respBinariaUsuario;
    
    public String getTipoAutenticacion() {
        return tipoAutenticacion;
    }
    
    @XmlElement(name = "TipoAutenticacion", namespace = "http://soapservices.services.banorte.mx.com/")
    public void setTipoAutenticacion(String tipoAutenticacion) {
        this.tipoAutenticacion = tipoAutenticacion;
    }

    
    public String getRespUsuario() {
        return respUsuario;
    }
    
    @XmlElement(name = "RespUsuario", namespace = "http://soapservices.services.banorte.mx.com/")
    public void setRespUsuario(String respUsuario) {
        this.respUsuario = respUsuario;
    }

    
    public boolean isRespBinaria() {
    return respBinaria;
    }

    @XmlElement(name = "RespBinaria", namespace = "http://soapservices.services.banorte.mx.com/")
    public void setRespBinaria(boolean respBinaria) {
    this.respBinaria = respBinaria;
    }

    public String getRespBinariaUsuario() {
        return respBinariaUsuario;
    }

    @XmlElement(name = "RespBinariaUsuario", namespace = "http://soapservices.services.banorte.mx.com/")
    public void setRespBinariaUsuario(String respBinariaUsuario) {
        this.respBinariaUsuario = respBinariaUsuario;
    }
}

