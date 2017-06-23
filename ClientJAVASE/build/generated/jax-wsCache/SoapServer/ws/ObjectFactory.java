
package ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws package. 
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

    private final static QName _TesterResponse_QNAME = new QName("http://ws/", "testerResponse");
    private final static QName _Tester_QNAME = new QName("http://ws/", "tester");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TesterResponse }
     * 
     */
    public TesterResponse createTesterResponse() {
        return new TesterResponse();
    }

    /**
     * Create an instance of {@link Tester }
     * 
     */
    public Tester createTester() {
        return new Tester();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TesterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "testerResponse")
    public JAXBElement<TesterResponse> createTesterResponse(TesterResponse value) {
        return new JAXBElement<TesterResponse>(_TesterResponse_QNAME, TesterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Tester }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "tester")
    public JAXBElement<Tester> createTester(Tester value) {
        return new JAXBElement<Tester>(_Tester_QNAME, Tester.class, null, value);
    }

}
