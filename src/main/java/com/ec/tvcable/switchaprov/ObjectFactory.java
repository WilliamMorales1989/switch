
package com.ec.tvcable.switchaprov;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ec.tvcable.switchaprov package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AprovConax_QNAME = new QName("http://pkg_conax/", "Aprov_conax");
    private final static QName _AprovConaxResponse_QNAME = new QName("http://pkg_conax/", "Aprov_conaxResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ec.tvcable.switchaprov
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AprovConax }
     * 
     */
    public AprovConax createAprovConax() {
        return new AprovConax();
    }

    /**
     * Create an instance of {@link AprovConaxResponse }
     * 
     */
    public AprovConaxResponse createAprovConaxResponse() {
        return new AprovConaxResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AprovConax }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pkg_conax/", name = "Aprov_conax")
    public JAXBElement<AprovConax> createAprovConax(AprovConax value) {
        return new JAXBElement<AprovConax>(_AprovConax_QNAME, AprovConax.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AprovConaxResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pkg_conax/", name = "Aprov_conaxResponse")
    public JAXBElement<AprovConaxResponse> createAprovConaxResponse(AprovConaxResponse value) {
        return new JAXBElement<AprovConaxResponse>(_AprovConaxResponse_QNAME, AprovConaxResponse.class, null, value);
    }

}
