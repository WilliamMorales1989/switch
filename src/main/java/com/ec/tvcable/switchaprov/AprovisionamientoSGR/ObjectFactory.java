
package com.ec.tvcable.switchaprov.AprovisionamientoSGR;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ec.tvcable.switchaprov.AprovisionamientoSGR package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ec.tvcable.switchaprov.AprovisionamientoSGR
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AprovisionamientoResponse }
     * 
     */
    public AprovisionamientoResponse createAprovisionamientoResponse() {
        return new AprovisionamientoResponse();
    }

    /**
     * Create an instance of {@link HeaderResponse }
     * 
     */
    public HeaderResponse createHeaderResponse() {
        return new HeaderResponse();
    }

    /**
     * Create an instance of {@link BodyResponse }
     * 
     */
    public BodyResponse createBodyResponse() {
        return new BodyResponse();
    }

    /**
     * Create an instance of {@link Aprovisionamiento_Type }
     * 
     */
    public Aprovisionamiento_Type createAprovisionamiento_Type() {
        return new Aprovisionamiento_Type();
    }

    /**
     * Create an instance of {@link HeaderRequest }
     * 
     */
    public HeaderRequest createHeaderRequest() {
        return new HeaderRequest();
    }

    /**
     * Create an instance of {@link BodyRequest }
     * 
     */
    public BodyRequest createBodyRequest() {
        return new BodyRequest();
    }

}
