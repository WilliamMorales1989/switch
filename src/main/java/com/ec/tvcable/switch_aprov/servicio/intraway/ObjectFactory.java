
package com.ec.tvcable.switch_aprov.servicio.intraway;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ec.tvcable.switch_aprov.servicio.intraway package. 
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

    private final static QName _ConsultaRespuesta_QNAME = new QName("http://www.grupotvcable.com.ec/WsdlIntraway/", "consultaRespuesta");
    private final static QName _EjecutaComando_QNAME = new QName("http://www.grupotvcable.com.ec/WsdlIntraway/", "ejecutaComando");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ec.tvcable.switch_aprov.servicio.intraway
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
     * Create an instance of {@link Mensaje }
     * 
     */
    public Mensaje createMensaje() {
        return new Mensaje();
    }

    /**
     * Create an instance of {@link Estandar }
     * 
     */
    public Estandar createEstandar() {
        return new Estandar();
    }

    /**
     * Create an instance of {@link Intraway }
     * 
     */
    public Intraway createIntraway() {
        return new Intraway();
    }

    /**
     * Create an instance of {@link Interfaz }
     * 
     */
    public Interfaz createInterfaz() {
        return new Interfaz();
    }

    /**
     * Create an instance of {@link Detalle }
     * 
     */
    public Detalle createDetalle() {
        return new Detalle();
    }

    /**
     * Create an instance of {@link Cabecera }
     * 
     */
    public Cabecera createCabecera() {
        return new Cabecera();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Respuesta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.grupotvcable.com.ec/WsdlIntraway/", name = "consultaRespuesta")
    public JAXBElement<Respuesta> createConsultaRespuesta(Respuesta value) {
        return new JAXBElement<Respuesta>(_ConsultaRespuesta_QNAME, Respuesta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Comando }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.grupotvcable.com.ec/WsdlIntraway/", name = "ejecutaComando")
    public JAXBElement<Comando> createEjecutaComando(Comando value) {
        return new JAXBElement<Comando>(_EjecutaComando_QNAME, Comando.class, null, value);
    }

}
