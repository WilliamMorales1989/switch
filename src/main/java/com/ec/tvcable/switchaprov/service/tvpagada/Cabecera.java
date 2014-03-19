
package com.ec.tvcable.switchaprov.service.tvpagada;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Cabecera complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Cabecera">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IDEmpresa" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Negocio" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Interface" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Secuencia" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Cabecera", propOrder = {
    "idEmpresa",
    "negocio",
    "_interface",
    "secuencia"
})
public class Cabecera {

    @XmlElement(name = "IDEmpresa")
    protected int idEmpresa;
    @XmlElement(name = "Negocio")
    protected int negocio;
    @XmlElement(name = "Interface")
    protected int _interface;
    @XmlElement(name = "Secuencia")
    protected int secuencia;

    /**
     * Gets the value of the idEmpresa property.
     * 
     */
    public int getIDEmpresa() {
        return idEmpresa;
    }

    /**
     * Sets the value of the idEmpresa property.
     * 
     */
    public void setIDEmpresa(int value) {
        this.idEmpresa = value;
    }

    /**
     * Gets the value of the negocio property.
     * 
     */
    public int getNegocio() {
        return negocio;
    }

    /**
     * Sets the value of the negocio property.
     * 
     */
    public void setNegocio(int value) {
        this.negocio = value;
    }

    /**
     * Gets the value of the interface property.
     * 
     */
    public int getInterface() {
        return _interface;
    }

    /**
     * Sets the value of the interface property.
     * 
     */
    public void setInterface(int value) {
        this._interface = value;
    }

    /**
     * Gets the value of the secuencia property.
     * 
     */
    public int getSecuencia() {
        return secuencia;
    }

    /**
     * Sets the value of the secuencia property.
     * 
     */
    public void setSecuencia(int value) {
        this.secuencia = value;
    }

}
