
package com.ec.tvcable.switchaprov.AprovDTH;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UninstallResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "uninstallResult"
})
@XmlRootElement(name = "UninstallResponse")
public class UninstallResponse {

    @XmlElement(name = "UninstallResult")
    protected String uninstallResult;

    /**
     * Obtiene el valor de la propiedad uninstallResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUninstallResult() {
        return uninstallResult;
    }

    /**
     * Define el valor de la propiedad uninstallResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUninstallResult(String value) {
        this.uninstallResult = value;
    }

}
