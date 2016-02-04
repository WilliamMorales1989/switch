
package com.ec.tvcable.switchaprov.AprovisionamientoSGR;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HeaderRequest" type="{http://www.example.org/Aprovisionamiento/}HeaderRequest"/>
 *         &lt;element name="BodyRequest" type="{http://www.example.org/Aprovisionamiento/}BodyRequest"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "headerRequest",
    "bodyRequest"
})
@XmlRootElement(name = "Aprovisionamiento")
public class Aprovisionamiento_Type {

    @XmlElement(name = "HeaderRequest", required = true)
    protected HeaderRequest headerRequest;
    @XmlElement(name = "BodyRequest", required = true)
    protected BodyRequest bodyRequest;

    /**
     * Gets the value of the headerRequest property.
     * 
     * @return
     *     possible object is
     *     {@link HeaderRequest }
     *     
     */
    public HeaderRequest getHeaderRequest() {
        return headerRequest;
    }

    /**
     * Sets the value of the headerRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderRequest }
     *     
     */
    public void setHeaderRequest(HeaderRequest value) {
        this.headerRequest = value;
    }

    /**
     * Gets the value of the bodyRequest property.
     * 
     * @return
     *     possible object is
     *     {@link BodyRequest }
     *     
     */
    public BodyRequest getBodyRequest() {
        return bodyRequest;
    }

    /**
     * Sets the value of the bodyRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link BodyRequest }
     *     
     */
    public void setBodyRequest(BodyRequest value) {
        this.bodyRequest = value;
    }

}
