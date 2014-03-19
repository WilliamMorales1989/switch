
package com.ec.tvcable.switchaprov.service.tvpagada;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ec.tvcable.switchaprov.service.tvpagada package. 
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

    private final static QName _EjecutaComando_QNAME = new QName("http://www.grupotvcable.com.ec/WsdlTvPagada/", "ejecutaComando");
    private final static QName _ConsultaRespuesta_QNAME = new QName("http://www.grupotvcable.com.ec/WsdlTvPagada/", "consultaRespuesta");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ec.tvcable.switchaprov.service.tvpagada
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Respuesta }
     * 
     */
    public Respuesta createRespuesta() {
        return new Respuesta();
    }

    /**
     * Create an instance of {@link Comando }
     * 
     */
    public Comando createComando() {
        return new Comando();
    }

    /**
     * Create an instance of {@link NumEve }
     * 
     */
    public NumEve createNumEve() {
        return new NumEve();
    }

    /**
     * Create an instance of {@link IdEve }
     * 
     */
    public IdEve createIdEve() {
        return new IdEve();
    }

    /**
     * Create an instance of {@link DatosExtrasTVP }
     * 
     */
    public DatosExtrasTVP createDatosExtrasTVP() {
        return new DatosExtrasTVP();
    }

    /**
     * Create an instance of {@link TVpagada }
     * 
     */
    public TVpagada createTVpagada() {
        return new TVpagada();
    }

    /**
     * Create an instance of {@link Comienzo }
     * 
     */
    public Comienzo createComienzo() {
        return new Comienzo();
    }

    /**
     * Create an instance of {@link Cabecera }
     * 
     */
    public Cabecera createCabecera() {
        return new Cabecera();
    }

    /**
     * Create an instance of {@link Mensaje }
     * 
     */
    public Mensaje createMensaje() {
        return new Mensaje();
    }

    /**
     * Create an instance of {@link Final }
     * 
     */
    public Final createFinal() {
        return new Final();
    }

    /**
     * Create an instance of {@link IdPaquetes }
     * 
     */
    public IdPaquetes createIdPaquetes() {
        return new IdPaquetes();
    }

    /**
     * Create an instance of {@link IdEvento }
     * 
     */
    public IdEvento createIdEvento() {
        return new IdEvento();
    }

    /**
     * Create an instance of {@link NumPaq }
     * 
     */
    public NumPaq createNumPaq() {
        return new NumPaq();
    }

    /**
     * Create an instance of {@link Detalle }
     * 
     */
    public Detalle createDetalle() {
        return new Detalle();
    }

    /**
     * Create an instance of {@link IdPay }
     * 
     */
    public IdPay createIdPay() {
        return new IdPay();
    }

    /**
     * Create an instance of {@link IdEventos }
     * 
     */
    public IdEventos createIdEventos() {
        return new IdEventos();
    }

    /**
     * Create an instance of {@link IdPaquete }
     * 
     */
    public IdPaquete createIdPaquete() {
        return new IdPaquete();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Comando }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.grupotvcable.com.ec/WsdlTvPagada/", name = "ejecutaComando")
    public JAXBElement<Comando> createEjecutaComando(Comando value) {
        return new JAXBElement<Comando>(_EjecutaComando_QNAME, Comando.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Respuesta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.grupotvcable.com.ec/WsdlTvPagada/", name = "consultaRespuesta")
    public JAXBElement<Respuesta> createConsultaRespuesta(Respuesta value) {
        return new JAXBElement<Respuesta>(_ConsultaRespuesta_QNAME, Respuesta.class, null, value);
    }

}
