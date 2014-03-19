
package com.ec.tvcable.switchaprov.service.tvpagada;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DatosExtrasTVP complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DatosExtrasTVP">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IdServ" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="NumPaq" type="{http://www.grupotvcable.com.ec/WsdlTvPagada/}NumPaq"/>
 *         &lt;element name="NumEve" type="{http://www.grupotvcable.com.ec/WsdlTvPagada/}NumEve"/>
 *         &lt;element name="Credito" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TipoDeco" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CodMap" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Activo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UnitAddres" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Plant" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatosExtrasTVP", propOrder = {
    "idServ",
    "numPaq",
    "numEve",
    "credito",
    "tipoDeco",
    "codMap",
    "activo",
    "unitAddres",
    "plant"
})
public class DatosExtrasTVP {

    @XmlElement(name = "IdServ")
    protected int idServ;
    @XmlElement(name = "NumPaq", required = true)
    protected NumPaq numPaq;
    @XmlElement(name = "NumEve", required = true)
    protected NumEve numEve;
    @XmlElement(name = "Credito")
    protected int credito;
    @XmlElement(name = "TipoDeco")
    protected int tipoDeco;
    @XmlElement(name = "CodMap")
    protected int codMap;
    @XmlElement(name = "Activo", required = true)
    protected String activo;
    @XmlElement(name = "UnitAddres")
    protected int unitAddres;
    @XmlElement(name = "Plant", required = true)
    protected String plant;

    /**
     * Gets the value of the idServ property.
     * 
     */
    public int getIdServ() {
        return idServ;
    }

    /**
     * Sets the value of the idServ property.
     * 
     */
    public void setIdServ(int value) {
        this.idServ = value;
    }

    /**
     * Gets the value of the numPaq property.
     * 
     * @return
     *     possible object is
     *     {@link NumPaq }
     *     
     */
    public NumPaq getNumPaq() {
        return numPaq;
    }

    /**
     * Sets the value of the numPaq property.
     * 
     * @param value
     *     allowed object is
     *     {@link NumPaq }
     *     
     */
    public void setNumPaq(NumPaq value) {
        this.numPaq = value;
    }

    /**
     * Gets the value of the numEve property.
     * 
     * @return
     *     possible object is
     *     {@link NumEve }
     *     
     */
    public NumEve getNumEve() {
        return numEve;
    }

    /**
     * Sets the value of the numEve property.
     * 
     * @param value
     *     allowed object is
     *     {@link NumEve }
     *     
     */
    public void setNumEve(NumEve value) {
        this.numEve = value;
    }

    /**
     * Gets the value of the credito property.
     * 
     */
    public int getCredito() {
        return credito;
    }

    /**
     * Sets the value of the credito property.
     * 
     */
    public void setCredito(int value) {
        this.credito = value;
    }

    /**
     * Gets the value of the tipoDeco property.
     * 
     */
    public int getTipoDeco() {
        return tipoDeco;
    }

    /**
     * Sets the value of the tipoDeco property.
     * 
     */
    public void setTipoDeco(int value) {
        this.tipoDeco = value;
    }

    /**
     * Gets the value of the codMap property.
     * 
     */
    public int getCodMap() {
        return codMap;
    }

    /**
     * Sets the value of the codMap property.
     * 
     */
    public void setCodMap(int value) {
        this.codMap = value;
    }

    /**
     * Gets the value of the activo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivo() {
        return activo;
    }

    /**
     * Sets the value of the activo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivo(String value) {
        this.activo = value;
    }

    /**
     * Gets the value of the unitAddres property.
     * 
     */
    public int getUnitAddres() {
        return unitAddres;
    }

    /**
     * Sets the value of the unitAddres property.
     * 
     */
    public void setUnitAddres(int value) {
        this.unitAddres = value;
    }

    /**
     * Gets the value of the plant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlant() {
        return plant;
    }

    /**
     * Sets the value of the plant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlant(String value) {
        this.plant = value;
    }

}
