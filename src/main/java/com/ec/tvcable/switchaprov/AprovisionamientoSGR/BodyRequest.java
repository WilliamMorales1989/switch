
package com.ec.tvcable.switchaprov.AprovisionamientoSGR;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BodyRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BodyRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Serie" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MacAddress1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MacAddress2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MacAddress3" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MacAddress4" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IdUsuario" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IdEmpresa" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DeviceModel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="NombreCiudad" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Bodega" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CodigoArticulo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Usuario" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IdRestype" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Tipo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IdPlan" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BodyRequest", propOrder = {
    "serie",
    "macAddress1",
    "macAddress2",
    "macAddress3",
    "macAddress4",
    "idUsuario",
    "idEmpresa",
    "deviceModel",
    "nombreCiudad",
    "bodega",
    "codigoArticulo",
    "usuario",
    "idRestype",
    "tipo",
    "idPlan"
})
public class BodyRequest {

    @XmlElement(name = "Serie", required = true)
    protected String serie;
    @XmlElement(name = "MacAddress1", required = true)
    protected String macAddress1;
    @XmlElement(name = "MacAddress2", required = true)
    protected String macAddress2;
    @XmlElement(name = "MacAddress3", required = true)
    protected String macAddress3;
    @XmlElement(name = "MacAddress4", required = true)
    protected String macAddress4;
    @XmlElement(name = "IdUsuario")
    protected int idUsuario;
    @XmlElement(name = "IdEmpresa", required = true)
    protected String idEmpresa;
    @XmlElement(name = "DeviceModel")
    protected int deviceModel;
    @XmlElement(name = "NombreCiudad", required = true)
    protected String nombreCiudad;
    @XmlElement(name = "Bodega", required = true)
    protected String bodega;
    @XmlElement(name = "CodigoArticulo", required = true)
    protected String codigoArticulo;
    @XmlElement(name = "Usuario", required = true)
    protected String usuario;
    @XmlElement(name = "IdRestype", required = true)
    protected String idRestype;
    @XmlElement(name = "Tipo", required = true)
    protected String tipo;
    @XmlElement(name = "IdPlan")
    protected int idPlan;

    /**
     * Gets the value of the serie property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerie() {
        return serie;
    }

    /**
     * Sets the value of the serie property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerie(String value) {
        this.serie = value;
    }

    /**
     * Gets the value of the macAddress1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMacAddress1() {
        return macAddress1;
    }

    /**
     * Sets the value of the macAddress1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMacAddress1(String value) {
        this.macAddress1 = value;
    }

    /**
     * Gets the value of the macAddress2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMacAddress2() {
        return macAddress2;
    }

    /**
     * Sets the value of the macAddress2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMacAddress2(String value) {
        this.macAddress2 = value;
    }

    /**
     * Gets the value of the macAddress3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMacAddress3() {
        return macAddress3;
    }

    /**
     * Sets the value of the macAddress3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMacAddress3(String value) {
        this.macAddress3 = value;
    }

    /**
     * Gets the value of the macAddress4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMacAddress4() {
        return macAddress4;
    }

    /**
     * Sets the value of the macAddress4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMacAddress4(String value) {
        this.macAddress4 = value;
    }

    /**
     * Gets the value of the idUsuario property.
     * 
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Sets the value of the idUsuario property.
     * 
     */
    public void setIdUsuario(int value) {
        this.idUsuario = value;
    }

    /**
     * Gets the value of the idEmpresa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * Sets the value of the idEmpresa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdEmpresa(String value) {
        this.idEmpresa = value;
    }

    /**
     * Gets the value of the deviceModel property.
     * 
     */
    public int getDeviceModel() {
        return deviceModel;
    }

    /**
     * Sets the value of the deviceModel property.
     * 
     */
    public void setDeviceModel(int value) {
        this.deviceModel = value;
    }

    /**
     * Gets the value of the nombreCiudad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreCiudad() {
        return nombreCiudad;
    }

    /**
     * Sets the value of the nombreCiudad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreCiudad(String value) {
        this.nombreCiudad = value;
    }

    /**
     * Gets the value of the bodega property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBodega() {
        return bodega;
    }

    /**
     * Sets the value of the bodega property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBodega(String value) {
        this.bodega = value;
    }

    /**
     * Gets the value of the codigoArticulo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoArticulo() {
        return codigoArticulo;
    }

    /**
     * Sets the value of the codigoArticulo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoArticulo(String value) {
        this.codigoArticulo = value;
    }

    /**
     * Gets the value of the usuario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Sets the value of the usuario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuario(String value) {
        this.usuario = value;
    }

    /**
     * Gets the value of the idRestype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdRestype() {
        return idRestype;
    }

    /**
     * Sets the value of the idRestype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdRestype(String value) {
        this.idRestype = value;
    }

    /**
     * Gets the value of the tipo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Sets the value of the tipo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipo(String value) {
        this.tipo = value;
    }

    /**
     * Gets the value of the idPlan property.
     * 
     */
    public int getIdPlan() {
        return idPlan;
    }

    /**
     * Sets the value of the idPlan property.
     * 
     */
    public void setIdPlan(int value) {
        this.idPlan = value;
    }

}
