/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientjavase;

import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.ws.WebServiceRef;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

/**
 *
 * @author Super
 */
public class JaxRsClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            
            System.out.println("hello");
        //  System.out.println(testerSoap());
        //  System.out.println("Tester Jax-rs: "+testerRest());
        //  System.out.println("Tester Jax-rs ParamPath: "+testerRestParam());
        //  System.out.println("Tester Jax-rs QueryParam: "+testerRestQuery());            
        //  System.out.println("Tester Jax-rs MatrixParam: "+testerRestMatrix());
        //  System.out.println("Tester Jax-rs HeaderParam: "+testerRestHeader());
        //  System.out.println("Tester Jax-rs CookieParam: "+testerRestCookie());
        //  System.out.println("Tester Jax-rs As Xml: "+testerRestAsXml());
        //  System.out.println("Tester Jax-rs As Json: "+testerRestAsJson());
        //  System.out.println("Tester Jax-rs methode Post: "+testerRestPost());
        //  System.out.println("Tester Jax-rs methode Post String: "+testerRestPostString());
        //  System.out.println("Tester Jax-rs methode Put: "+testerRestPut());
        //  System.out.println("Tester Jax-rs methode Delete: "+testerRestDelete());
        //  System.out.println("Tester Jax-rs Response Created: "+testerRestCreated()); NE MARCHE PAS  
        //  System.out.println("Tester Jax-rs Response Cookies en retour: "+testerRestCookie2());
            System.out.println("Tester Jax-rs Response Cookies en retour: "+testerRestHeader2());
    }

    private static String testerSoap() {
        ws.SoapServerService service = new ws.SoapServerService();
        ws.SoapServer port = service.getSoapServerPort();
        return port.tester();
    }

  private static String testerRest(){
    Client client= ClientBuilder.newClient();
    Response reponse=client.target("http://localhost:8080/TEST1-war/rs/book").request(MediaType.TEXT_PLAIN).get();
    String resultat=reponse.readEntity(String.class);
     return(resultat);  
  } 
   
  
  private static String testerRestParam(){
    Client client= ClientBuilder.newClient();
    URI uri=UriBuilder.fromUri("http://localhost:8080/TEST1-war/rs/").path("book").path("param").path("Abdoulaye diaw").build();
    String resultat=client.target(uri).request(MediaType.TEXT_PLAIN).get(String.class);    
    return(resultat);  
  }
  
    private static String testerRestQuery(){
    Client client= ClientBuilder.newClient();
    URI uri=UriBuilder.fromUri("http://localhost:8080/TEST1-war/rs/").path("book").path("param").path("query").queryParam("text", "Abdoulaye diaw").build();
    String resultat=client.target(uri).request(MediaType.TEXT_PLAIN).get(String.class);    
   
    return(resultat);  
  }
 
    
       private static String testerRestMatrix(){
    Client client= ClientBuilder.newClient();
    URI uri=UriBuilder.fromUri("http://localhost:8080/TEST1-war/rs/").path("book").path("param").path("matrix").matrixParam("text", "Abdoulaye diaw").build();
    String resultat=client.target(uri).request(MediaType.TEXT_PLAIN).get(String.class);    
    return(resultat);  
  }
       
        private static String testerRestHeader(){
     Client client= ClientBuilder.newClient();
     URI uri=UriBuilder.fromUri("http://localhost:8080/TEST1-war/rs/").path("book").path("param").path("headerParam").build();
     Builder builder=client.target(uri).request(MediaType.TEXT_PLAIN);
     builder.header("header1", "bobo");
     builder.header("header2", "baba");
     Invocation inv=builder.buildGet();
     
   String resultat=inv.invoke(String.class);
    return(resultat);  
  }
        
          private static String testerRestCookie(){
     Client client= ClientBuilder.newClient();
     URI uri=UriBuilder.fromUri("http://localhost:8080/TEST1-war/rs/").path("book").path("param").path("cookieParam").build();
     Builder builder=client.target(uri).request(MediaType.TEXT_PLAIN);
     builder.cookie("cookie1", "bobo");
     builder.cookie("cookie2", "baba");
     Invocation inv=builder.buildGet();
     
   String resultat=inv.invoke(String.class);
    return(resultat);  
  }      
     private static String testerRestAsXml(){
    Client client= ClientBuilder.newClient();
    URI uri=UriBuilder.fromUri("http://localhost:8080/TEST1-war/rs/").path("book").path("format").path("asXml").build();
    //String resultat=client.target(uri).request(MediaType.APPLICATION_XML).get(String.class);    
     Book book=client.target(uri).request(MediaType.APPLICATION_XML).get(Book.class);    
    return(book.getNom());  
  }
  
     
     private static String testerRestAsJson(){
    Client client= ClientBuilder.newClient();
    URI uri=UriBuilder.fromUri("http://localhost:8080/TEST1-war/rs/").path("book").path("format").path("asJson").build();
     Book book=client.target(uri).request(MediaType.APPLICATION_JSON).get(Book.class);    
    return(book.getNom());  
  } 
     
      private static String testerRestPost(){
    Client client= ClientBuilder.newClient();
    URI uri=UriBuilder.fromUri("http://localhost:8080/TEST1-war/rs/").path("book").path("methodes").path("postMethode").build();
    Book book=new Book(1, "Livre Post Rest", "Abdoulaye Diaw", 10);
     Response resp=client.target(uri).request(MediaType.TEXT_PLAIN).post(Entity.xml(book));       
     String resultat=resp.readEntity(String.class);
    return(resultat);  
  } 
      
          private static String testerRestPostString(){
    Client client= ClientBuilder.newClient();
    URI uri=UriBuilder.fromUri("http://localhost:8080/TEST1-war/rs/").path("book").path("methodes").path("postMethodeString").build();
    Response resp=client.target(uri).request(MediaType.TEXT_PLAIN).post(null);    
     String resultat=resp.readEntity(String.class);
    return(resultat);  
  } 
          
        private static String testerRestPut(){
    Client client= ClientBuilder.newClient();
    URI uri=UriBuilder.fromUri("http://localhost:8080/TEST1-war/rs/").path("book").path("methodes").path("putMethode").build();
    Book book=new Book(1, "Livre Post Rest", "Abdoulaye Diaw", 10);
    Response resp=client.target(uri).request(MediaType.TEXT_PLAIN).put(Entity.xml(book));          
    String resultat=resp.readEntity(String.class);
    return(resultat);  
  } 
                 
        private static String testerRestDelete(){
    Client client= ClientBuilder.newClient();
    URI uri=UriBuilder.fromUri("http://localhost:8080/TEST1-war/rs/").path("book").path("methodes").path("deleteMethode").queryParam("id", 10).build();
    Book book=new Book(1, "Livre Post Rest", "Abdoulaye Diaw", 10);
    Response resp=client.target(uri).request(MediaType.TEXT_PLAIN).delete();
    String resultat=resp.readEntity(String.class);
    return(resultat);  
  } 
        /*
        Cette fois ci on envoie une information et on récupére le cookie en retour ecrit par le serveur
        */
               private static String testerRestCookie2(){
    Client client= ClientBuilder.newClient();
    URI uri=UriBuilder.fromUri("http://localhost:8080/TEST1-war/rs/").path("book").path("response").path("testOkCookie").build();
    Response resp=client.target(uri).request().get();
    String sessionid=resp.getCookies().get("sessionId").getValue();
    return("Session id:"+sessionid); 
  } 
       
     /*
        Cette fois ci on envoie une information et on récupére le header en retour ecrit par le serveur
        */          
                          private static String testerRestHeader2(){
    Client client= ClientBuilder.newClient();
    URI uri=UriBuilder.fromUri("http://localhost:8080/TEST1-war/rs/").path("book").path("response").path("testOkHeader").build();
    Response resp=client.target(uri).request().get();
    String token=resp.getHeaderString("token");    
    return("Token :"+token); 
  } 
                          
                          
        private static String testerRestMapper(){
    Client client= ClientBuilder.newClient();
    URI uri=UriBuilder.fromUri("http://localhost:8080/TEST1-war/rs/").path("book").path("mapper").build();
    Response resp=client.target(uri).request(MediaType.APPLICATION_JSON).get();
    Personne pers=resp.readEntity(Personne.class);
    return("Mapper:"+pers.getPrenom());  
  } 
}
