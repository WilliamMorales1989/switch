
package com.ec.tvcable.switchaprov.service.intraway;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Estandar complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Estandar">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AuthKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ClienteCRM" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IdProducto" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IdProductoPadre" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IdServicio" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IdServicioPadre" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IdVenta" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IdVentaPadre" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IdPromotor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FechaDiferida" type="{http://www.w3.org/2001/XMLSchema}anySimpleType"/>
 *         &lt;element name="IdEstado" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Estandar", propOrder = {
    "authKey",
    "clienteCRM",
    "idProducto",
    "idProductoPadre",
    "idServicio",
    "idServicioPadre",
    "idVenta",
    "idVentaPadre",
    "idPromotor",
    "fechaDiferida",
    "idEstado"
})
public class Estandar {

    @XmlElement(name = "AuthKey", required = true)
    protected String authKey;
    @XmlElement(name = "ClienteCRM")
    protected int clienteCRM;
    @XmlElement(name = "IdProducto")
    protected int idProducto;
    @XmlElement(name = "IdProductoPadre")
    protected int idProductoPadre;
    @XmlElement(name = "IdServicio")
    protected int idServicio;
    @XmlElement(name = "IdServicioPadre")
    protected int idServicioPadre;
    @XmlElement(name = "IdVenta")
    protected int idVenta;
    @XmlElement(name = "IdVentaPadre")
    protected int idVentaPadre;
    @XmlElement(name = "IdPromotor", required = true)
    protected String idPromotor;
    @XmlElement(name = "FechaDiferida", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected Object fechaDiferida;
    @XmlElement(name = "IdEstado")
    protected int idEstado;

    /**
     * Gets the value of the authKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthKey() {
        return authKey;
    }

    /**
     * Sets the value of the authKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthKey(String value) {
        this.authKey = value;
    }

    /**
     * Gets the value of the clienteCRM property.
     * 
     */
    public int getClienteCRM() {
        return clienteCRM;
    }

    /**
     * Sets the value of the clienteCRM property.
     * 
     */
    public void setClienteCRM(int value) {
        this.clienteCRM = value;
    }

    /**
     * Gets the value of the idProducto property.
     * 
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * Sets the value of the idProducto property.
     * 
     */
    public void setIdProducto(int value) {
        this.idProducto = value;
    }

    /**
     * Gets the value of the idProductoPadre property.
     * 
     */
    public int getIdProductoPadre() {
        return idProductoPadre;
    }

    /**
     * Sets the value of the idProductoPadre property.
     * 
     */
    public void setIdProductoPadre(int value) {
        this.idProductoPadre = value;
    }

    /**
     * Gets the value of the idServicio property.
     * 
     */
    public int getIdServicio() {
        return idServicio;
    }

    /**
     * Sets the value of the idServicio property.
     * 
     */
    public void setIdServicio(int value) {
        this.idServicio = value;
    }

    /**
     * Gets the value of the idServicioPadre property.
     * 
     */
    public int getIdServicioPadre() {
        return idServicioPadre;
    }

    /**
     * Sets the value of the idServicioPadre property.
     * 
     */
    public void setIdServicioPadre(int value) {
        this.idServicioPadre = value;
    }

    /**
     * Gets the value of the idVenta property.
     * 
     */
    public int getIdVenta() {
        return idVenta;
    }

    /**
     * Sets the value of the idVenta property.
     * 
     */
    public void setIdVenta(int value) {
        this.idVenta = value;
    }

    /**
     * Gets the value of the idVentaPadre property.
     * 
     */
    public int getIdVentaPadre() {
        return idVentaPadre;
    }

    /**
     * Sets the value of the idVentaPadre property.
     * 
     */
    public void setIdVentaPadre(int value) {
        this.idVentaPadre = value;
    }

    /**
     * Gets the value of the idPromotor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdPromotor() {
        return idPromotor;
    }

    /**
     * Sets the value of the idPromotor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdPromotor(String value) {
        this.idPromotor = value;
    }

    /**
     * Gets the value of the fechaDiferida property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getFechaDiferida() {
        return fechaDiferida;
    }

    /**
     * Sets the value of the fechaDiferida property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setFechaDiferida(Object value) {
        this.fechaDiferida = value;
    }

    /**
     * Gets the value of the idEstado property.
     * 
     */
    public int getIdEstado() {
        return idEstado;
    }

    /**
     * Sets the value of the idEstado property.
     * 
     */
    public void setIdEstado(int value) {
        this.idEstado = value;
    }

}
