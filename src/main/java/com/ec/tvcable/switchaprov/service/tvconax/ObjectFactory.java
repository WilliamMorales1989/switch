
package com.ec.tvcable.switchaprov.service.tvconax;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ec.tvcable.switchaprov.service.tvconax package. 
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

    private final static QName _RespuestaServico_QNAME = new QName("urn:com.example.switchyard:ServicioConax:1.0", "respuestaServico");
    private final static QName _RespuestaServicoResponse_QNAME = new QName("urn:com.example.switchyard:ServicioConax:1.0", "respuestaServicoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ec.tvcable.switchaprov.service.tvconax
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RespuestaServicoResponse }
     * 
     */
    public RespuestaServicoResponse createRespuestaServicoResponse() {
        return new RespuestaServicoResponse();
    }

    /**
     * Create an instance of {@link RespuestaServico }
     * 
     */
    public RespuestaServico createRespuestaServico() {
        return new RespuestaServico();
    }

    /**
     * Create an instance of {@link DatosServicio }
     * 
     */
    public DatosServicio createDatosServicio() {
        return new DatosServicio();
    }

    /**
     * Create an instance of {@link RespuestaServicoConax }
     * 
     */
    public RespuestaServicoConax createRespuestaServicoConax() {
        return new RespuestaServicoConax();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaServico }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com.example.switchyard:ServicioConax:1.0", name = "respuestaServico")
    public JAXBElement<RespuestaServico> createRespuestaServico(RespuestaServico value) {
        return new JAXBElement<RespuestaServico>(_RespuestaServico_QNAME, RespuestaServico.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaServicoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com.example.switchyard:ServicioConax:1.0", name = "respuestaServicoResponse")
    public JAXBElement<RespuestaServicoResponse> createRespuestaServicoResponse(RespuestaServicoResponse value) {
        return new JAXBElement<RespuestaServicoResponse>(_RespuestaServicoResponse_QNAME, RespuestaServicoResponse.class, null, value);
    }

}
